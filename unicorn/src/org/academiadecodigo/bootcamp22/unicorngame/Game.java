package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.HappinessMeter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.TimeCounter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Game {

    private final int NUMBER_OF_GAME_OBJECTS = 10;

    private Picture background;
    private Unicorn unicorn;
    private TimeCounter timer;
    private HappinessMeter meter;

    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    private Menu menu = new Menu();
    //private int delay;

    public Game() {

        background = new Picture(10, 50, "resources/background_sad.png");
        unicorn = new Unicorn();
        timer = new TimeCounter(59);
        meter = new HappinessMeter();

        fillObjectsArray();

    }

    /*private void initMenu() {

        menu.showMenu();

        if (menu.startGame()) {
            start();
        }

    }*/

    private void init() {

        background.draw();
        unicorn.getUnicornPicture().draw();
        meter.draw();
        drawObjects();

        timer.start();
        unicorn.move();

    }

    public void start() throws InterruptedException {

        init();

        /**
         *
         * GAME RUNNING
         *
         */

        while (unicorn.getHappiness() < 100 && timer.getSecondsLeft() > 0) {
            updateBackground();
            meter.updateMeter(unicorn.getHappiness());

            if (timer.getSecondsLeft() % 10 == 0) {
                Thread.sleep(1000);
                fillObjectsArray();
                drawObjects();
                //collisionChecker.checkCollision(unicorn, gameObjects);
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


    private void fillObjectsArray() {

        for (int i = 0; i < NUMBER_OF_GAME_OBJECTS; i++) {

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

            int safeX = Math.abs(gameObject.getGameObjectPicture().getX() - current.getGameObjectPicture().getX()); //> 35 is safe
            int safeY = Math.abs(gameObject.getGameObjectPicture().getY() - current.getGameObjectPicture().getY()); //> 35 is safe

            if (safeX <= current.getGameObjectPicture().getHeight() && safeY <= current.getGameObjectPicture().getHeight()) {
                return false;
            }
        }

        return true;
    }

    private void drawObjects() {

        for (GameObject object : gameObjects) {

            if(object.isCrashed()) {
                continue;
            }

            object.getGameObjectPicture().draw();
        }

    }

    private void checkCollision() {
        int unicornX = Math.abs(unicorn.getUnicornPicture().getX());
        int unicornY = Math.abs(unicorn.getUnicornPicture().getY());

        for (GameObject object : gameObjects) {

            if(object.isCrashed()) {
                continue;
            }

            int gameObjectX = object.getGameObjectPicture().getX();
            int gameObjectY = object.getGameObjectPicture().getY();

            int collideX = Math.abs(unicornX - gameObjectX);
            int collideY = Math.abs(unicornY - gameObjectY);

            if (collideX < 35 && collideY < 35) { //35 is the size of each game object
                object.getGameObjectPicture().delete();

                // debug purposes
                System.out.println("happiness: " + unicorn.getHappiness());
                System.out.println("object value: "  + object.getScore());

                unicorn.setHappiness(object.getScore());
                object.setCrashed();

                }
            }
        }
    }
