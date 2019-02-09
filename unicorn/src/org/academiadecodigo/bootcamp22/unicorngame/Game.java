package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.ArrayList;

public class Game {

    private Unicorn unicorn = new Unicorn();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public void start(int numberOfElements) {
        init();
        initObjects(numberOfElements);
        drawObjects();
    }


    private void init() {
        Picture background = new Picture(10, 50, "resources/background.jpg");
        background.draw();
        unicorn.getUnicornPicture().draw();
        unicorn.move();
    }

    private void initObjects(int numberOfElements) {

        for (int i = 0; i < numberOfElements; i++) {

            GameObject gameObject = GameObjectFactory.getGameObject();

            //check if the same position has been given
            while (!verifyPosition(gameObject)) {
                gameObject = GameObjectFactory.getGameObject();
            }

            gameObjects.add(gameObject);

        }
    }

    private boolean verifyPosition(GameObject gameObject) {

        for (int i = 0; i < gameObjects.size(); i++) {

            GameObject current = gameObjects.get(i);

            Picture currentPicture = current.getGameObjectPicture();
            Picture gameObjectPicture = gameObject.getGameObjectPicture();

            if (currentPicture.getX() == gameObjectPicture.getX() || currentPicture.getY() == gameObjectPicture.getY()
                    || currentPicture.getX() > gameObjectPicture.getX() - 60 || currentPicture.getY() > gameObjectPicture.getY() - 60
                    || currentPicture.getX() < gameObjectPicture.getX() + 60 || currentPicture.getY() < gameObjectPicture.getY() + 60) {
                return false;
            }
        }

        return true;
    }

    private void drawObjects() {

        for (int i = 0; i < gameObjects.size(); i++) {
            //Picture picture = new Picture(gameObjects.get(i).getPosition().getX(), gameObjects.get(i).getPosition().getY(), gameObjects.get(i).getPicturePath());
            //picture.draw();

            gameObjects.get(i).getGameObjectPicture().draw();

            System.out.println("object: " + gameObjects.get(i).getPicturePath());
            System.out.println("x: " + gameObjects.get(i).getGameObjectPicture().getX());
            System.out.println("y: " + gameObjects.get(i).getGameObjectPicture().getY());
        }
    }

    /*public boolean checkPosition() {

        for (GameObject object: gameObjects) {

            if(object.) {

            }

            if(object.getPosition().equals(unicorn.getUnicornPicture().getMaxX(), unicorn.getUnicornPicture().getMaxY())) {

            }
        }

    }*/

}
