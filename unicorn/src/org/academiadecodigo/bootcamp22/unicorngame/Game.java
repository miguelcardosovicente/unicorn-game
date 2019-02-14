package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.elements.HappinessMeter;
import org.academiadecodigo.bootcamp22.unicorngame.elements.Sound;
import org.academiadecodigo.bootcamp22.unicorngame.elements.TimeCounter;
import org.academiadecodigo.bootcamp22.unicorngame.elements.Unicorn;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Game {

    private final int DELAY = 30;
    private final int INITIAL_NUMBER_OF_GAME_OBJECTS = 10;

    private Picture background;
    private Picture game_won;
    private Picture game_lost;
    private Sound sound;

    private Unicorn unicorn;
    private TimeCounter timer;
    private HappinessMeter meter;

    private State state;
    private Menu menu;
    private ArrayList<GameObject> gameObjects;

    private int currentSecond;

    public Game() {

        background = new Picture(10, 50, "resources/background_sad.png");
        game_won = new Picture(10, 50, "resources/game_won.jpg");
        game_lost = new Picture(10, 50, "resources/game_lost.png");

        unicorn = new Unicorn();
        timer = new TimeCounter(59);
        meter = new HappinessMeter();

        menu = new Menu();
        gameObjects = new ArrayList<>();
        fillObjectsArray(INITIAL_NUMBER_OF_GAME_OBJECTS);
    }

    public void start() throws InterruptedException {

        state = State.MENU;
        state = menu.showMenu();

        if (state == State.GAME) {

            init();
            loop();
        }
    }

    private void init() {

        sound = new Sound("rresources/music/game_song.wav");
        sound.play(true);
        sound.alwaysLoop();
        background.draw();
        unicorn.getUnicornPicture().draw();
        meter.draw();
        drawObjects();
        timer = new TimeCounter(59);
        timer.start();
    }

    private void loop() throws InterruptedException {

        while (state == State.GAME) {

            Thread.sleep(DELAY);
            unicorn.move();
            updateBackground();
            meter.updateMeter(unicorn.getHappiness());

            if (currentSecond != timer.getSecondsLeft() && timer.getSecondsLeft() % 5 == 0) {
                currentSecond = timer.getSecondsLeft();
                fillObjectsArray((int) Math.floor(Math.random() * 6 + 2));
                removeObjects((int) Math.floor(Math.random() * 3));
                drawObjects();
            }

            if (unicorn.getHappiness() == 100) {
                game_won.draw();
                timer.endTimer();
                state = State.WON;
                break;
            }

            if (timer.getSecondsLeft() == 0) {
                game_lost.draw();
                state = State.LOST;
                break;
            }

            checkCollision();
        }

        sound.stop();

        if(state == State.LOST) {
            sound = new Sound("rresources/music/lost_game.wav");
            sound.play(true);
            sound.alwaysLoop();
        }

        if(state == State.WON) {
            sound = new Sound("rresources/music/won_game.wav");
            sound.play(true);
            sound.alwaysLoop();
        }

        restart();

    }

    private void restart() throws InterruptedException {

        Thread.sleep(4000);

        sound.stop();
        timer.getTimerText().delete();
        background.delete();
        unicorn.getUnicornPicture().delete();
        timer = new TimeCounter(59);
        unicorn = new Unicorn();
        gameObjects.clear();
        fillObjectsArray(INITIAL_NUMBER_OF_GAME_OBJECTS);

        if (state == State.WON) {
            game_won.delete();
        }
        if (state == State.LOST) {
            game_lost.delete();
        }

        state = State.MENU;
        menu = new Menu();

        start();
    }

    private void updateBackground() {

        if (unicorn.getHappiness() < 40) {
            background.load("resources/background_sad.png");
            return;
        }

        if (unicorn.getHappiness() > 70) {
            background.load("resources/background_happy.png");
            return;
        }

        background.load("resources/background_medium.png");
    }


    private void fillObjectsArray(int numberOfGameObjects) {

        for (int i = 0; i < numberOfGameObjects; i++) {

            GameObject gameObject = GameObjectFactory.getGameObject();

            //check if the same position has been given
            while (!safePicturePos(gameObject)) {
                gameObject = GameObjectFactory.getGameObject();
            }

            gameObjects.add(gameObject);

        }
    }

    private boolean safePicturePos(GameObject gameObject) {

        for (int i = 0; i < gameObjects.size(); i++) {

            GameObject current = gameObjects.get(i);

            int safeX = Math.abs(gameObject.getGameObjectPicture().getX() - current.getGameObjectPicture().getX());
            int safeY = Math.abs(gameObject.getGameObjectPicture().getY() - current.getGameObjectPicture().getY());

            if (safeX <= current.getGameObjectPicture().getHeight() && safeY <= current.getGameObjectPicture().getHeight()) {
                return false;
            }
        }

        return true;
    }

    private void drawObjects() {

        for (GameObject object : gameObjects) {

            if (object.isCrashed()) {
                continue;
            }

            object.getGameObjectPicture().draw();
        }
    }

    private void removeObjects(int quantity) {
        int index = 0;

        for (GameObject gameObject : gameObjects) {

            if (!gameObject.isCrashed()) {
                gameObject.getGameObjectPicture().delete();
                gameObject.setCrashed();

                if(index == quantity) {
                    break;
                }
                index++;
            }
        }
    }

    private void checkCollision() {

        int unicornX = Math.abs(unicorn.getUnicornPicture().getX());
        int unicornY = Math.abs(unicorn.getUnicornPicture().getY());

        int unicornMaxX = Math.abs(unicorn.getUnicornPicture().getMaxX());
        int unicornMaxY = Math.abs(unicorn.getUnicornPicture().getMaxY());

        for (GameObject object : gameObjects) {

            if (object.isCrashed()) {
                continue;
            }

            int gameObjectX = object.getGameObjectPicture().getX();
            int gameObjectY = object.getGameObjectPicture().getY();

            int gameObjectMaxX = object.getGameObjectPicture().getMaxX();
            int gameObjectMaxY = object.getGameObjectPicture().getMaxY();

            int collideX = Math.abs(unicornX - gameObjectX);
            int collideY = Math.abs(unicornY - gameObjectY);

            int collideMaxX = Math.abs(unicornMaxX - gameObjectMaxX);
            int collideMaxY = Math.abs(unicornMaxY - gameObjectMaxY);

            if (collideX < object.getGameObjectPicture().getWidth() &&
                    collideY < object.getGameObjectPicture().getHeight() ||
                    collideMaxX < object.getGameObjectPicture().getWidth() &&
                            collideMaxY < object.getGameObjectPicture().getHeight()) {

                object.getGameObjectPicture().delete();
                unicorn.setHappiness(object.getScore());
                object.setCrashed();

            }

        }
    }

    public enum State {
        MENU,
        GAME,
        LOST,
        WON
    }

}
