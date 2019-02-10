package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.elements.HappinessMeter;
import org.academiadecodigo.bootcamp22.unicorngame.elements.TimeCounter;
import org.academiadecodigo.bootcamp22.unicorngame.elements.Unicorn;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Game {


    private final int INITIAL_NUMBER_OF_GAME_OBJECTS = 10;
    private int numberOfNewGameObjects = (int) Math.floor(Math.random() * 4 + 1);

    private Picture background;
    private Unicorn unicorn;
    private TimeCounter timer;
    private HappinessMeter meter;
    private State state;
    private Menu menu;
    private ArrayList<GameObject> gameObjects;

    public Game() {

        background = new Picture(10, 50, "resources/background_sad.png");
        unicorn = new Unicorn();
        timer = new TimeCounter(59);
        meter = new HappinessMeter();
        menu = new Menu();
        gameObjects = new ArrayList<>();
        fillObjectsArray(INITIAL_NUMBER_OF_GAME_OBJECTS);
    }

    private void init() {

        background.draw();
        unicorn.getUnicornPicture().draw();
        meter.draw();
        drawObjects();
        timer.start();

    }

    public void start() throws InterruptedException {

        state = State.MENU;
        state = menu.showMenu();

        if (state == State.GAME) {

            init();
            loop();
        }

        /*if (state = State.LOST;) {

        }

        if (state == State.WON) {

        }*/
    }

    private void loop() throws InterruptedException {

        while (state == State.GAME) {

            updateBackground();
            meter.updateMeter(unicorn.getHappiness());

            if (timer.getSecondsLeft() % 5 == 0) {
                Thread.sleep(1000);
                fillObjectsArray(numberOfNewGameObjects);
                drawObjects();
            }

            if (unicorn.getHappiness() == 100) {
                state = State.WON;
                return;
            }

            if (timer.getSecondsLeft() == 0) {
                state = State.LOST;
                return;
            }

            checkCollision();
        }

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
        WON,
        LOST
    }

}
