package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.HappinessMeter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.TimeCounter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Game {

    private final int NUMBER_OF_GAME_OBJECTS = 10;

    private Picture background = new Picture(10, 50, "resources/background_sad.png");
    private Unicorn unicorn = new Unicorn();
    private TimeCounter timer = new TimeCounter(59);
    private HappinessMeter meter = new HappinessMeter();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private CollisionChecker collisionChecker;

    private Menu menu = new Menu();
    //private int delay;

    public Game() {
        fillObjectsArray();
        collisionChecker = new CollisionChecker();
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

        while (unicorn.getHappiness() < 100 && timer.getSecondsLeft() > 0) {
            updateBackground();
            meter.updateMeter(unicorn.getHappiness());

            if (timer.getSecondsLeft() % 10 == 0) {
                Thread.sleep(1000);
                fillObjectsArray();
                drawObjects();
                //collisionChecker.checkCollision(unicorn, gameObjects);
            }

            collisionChecker.checkCollision(unicorn, gameObjects);
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

        for (GameObject obj : gameObjects) {
            obj.getGameObjectPicture().draw();
        }

    }

}
