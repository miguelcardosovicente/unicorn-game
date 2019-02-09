package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.HappinessMeter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.TimeCounter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.Unicorn;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.ArrayList;

public class Game {

    private Menu menu = new Menu();

    private Picture background = new Picture(10, 50, "resources/background_sad.jpg");
    private Unicorn unicorn = new Unicorn();
    private TimeCounter timer = new TimeCounter(15);
    private HappinessMeter meter = new HappinessMeter();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();
    private CheckCollision checkCollision = new CheckCollision(gameObjects);

    private int delay;

    public Game(int delay) {
        this.delay = delay;
    }

    public void init() {

        menu.showMenu();

        if(menu.startGame()) {
            start();
        }

    }

    /*?public void start(int numberOfElements) {
        init();
        initObjects(numberOfElements);
        drawObjects();
    }LUCAS*/

    public void start() {

        background.draw();
        unicorn.getUnicornPicture().draw();
        meter.draw();

        timer.start();
        unicorn.move();

        while (true) {
            updateBackground();
            meter.updateMeter(unicorn.getHappiness());
        }

    }

    private void updateBackground() {

        if (unicorn.getHappiness() < 40) {
            background.load("resources/background_sad.jpg");
            return;
        }

        if (unicorn.getHappiness() > 70) {
            background.load("resources/background_happy.jpg");
            return;
        }

        background.load("resources/background_medium.jpg");

    /*private void init() {
        Picture background = new Picture(10, 50, "resources/background.jpg");
        background.draw();
        unicorn.getUnicornPicture().draw();

        //checkCollision.getTestCollision().draw();
        //checkCollision.getTestCollision().fill();
        unicorn.move();

        /*while(true) {

            checkCollisions();
        }


    }

    private void initObjects(int numberOfElements) {

        for (int i = 0; i < numberOfElements; i++) {

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

            if(safeX <= current.getGameObjectPicture().getHeight() && safeY <= current.getGameObjectPicture().getHeight()) {
                return false;
            }
        }

        return true;
    }

    private void drawObjects() {

        for (int i = 0; i < gameObjects.size(); i++) {

            gameObjects.get(i).getGameObjectPicture().draw();

            System.out.println("object: " + gameObjects.get(i).getPicturePath());
            System.out.println("x: " + gameObjects.get(i).getGameObjectPicture().getX());
            System.out.println("y: " + gameObjects.get(i).getGameObjectPicture().getY());
        }
    }*/

    private void checkCollisions() {

        checkCollision = new CheckCollision(gameObjects);

        checkCollision.collisionDetected(unicorn);

    }

}
