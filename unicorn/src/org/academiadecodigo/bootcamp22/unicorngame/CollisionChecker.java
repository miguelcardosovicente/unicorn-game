package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;

import java.util.ArrayList;

public class CollisionChecker {

    private ArrayList<GameObject> gameObjects;

    public CollisionChecker(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public void checkCollision(Unicorn unicorn) {

        int unicornX = Math.abs(unicorn.getUnicornPicture().getX());
        int unicornY = Math.abs(unicorn.getUnicornPicture().getY());

        for (GameObject object : gameObjects) {

            int gameObjectX = object.getGameObjectPicture().getX();
            int gameObjectY = object.getGameObjectPicture().getY();

            int collideX = Math.abs(unicornX - gameObjectX);
            int collideY = Math.abs(unicornY - gameObjectY);

            if (collideX < 35 && collideY < 35) { //35 is the size of each game object
                object.getGameObjectPicture().delete();
            }
        }
    }

}
