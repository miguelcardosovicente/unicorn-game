package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;

import java.util.ArrayList;

public class CollisionChecker {


    public void checkCollision(Unicorn unicorn, ArrayList<GameObject> gameObjects) {

        int unicornX = Math.abs(unicorn.getUnicornPicture().getX());
        int unicornY = Math.abs(unicorn.getUnicornPicture().getY());

        int unicornMaxX = Math.abs(unicorn.getUnicornPicture().getMaxX());
        int unicornMaxY = Math.abs(unicorn.getUnicornPicture().getMaxY());

        for (GameObject object : gameObjects) {

            int gameObjectX = object.getGameObjectPicture().getX();
            int gameObjectY = object.getGameObjectPicture().getY();

            int gameObjectMaxX = object.getGameObjectPicture().getMaxX();
            int gameObjectMaxY = object.getGameObjectPicture().getMaxY();

            int collideX = Math.abs(unicornX - gameObjectX);
            int collideY = Math.abs(unicornY - gameObjectY);

            int collideMaxX = Math.abs(unicornMaxX - gameObjectMaxX);
            int collideMaxY = Math.abs(unicornMaxY - gameObjectMaxY);

            if (collideX < 35 && collideY < 35 || collideMaxX < 35 && collideMaxY < 35) { //35 is the size of each game object
                object.getGameObjectPicture().delete();
            }
        }
    }

}
