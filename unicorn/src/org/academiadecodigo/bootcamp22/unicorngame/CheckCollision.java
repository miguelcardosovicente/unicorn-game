package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.ArrayList;

public class CheckCollision {

    private ArrayList<GameObject> gameObjects;

    private Rectangle testCollision = new Rectangle(130, 290, 35, 35);

    public CheckCollision(ArrayList<GameObject> gameObjects) {
        this.gameObjects = gameObjects;

    }

    public Rectangle getTestCollision() {
        return testCollision;
    }

    public boolean collisionDetected(Unicorn unicorn) {

        int unicornX = unicorn.getUnicornPicture().getX();
        int unicornY = unicorn.getUnicornPicture().getY();

        if(unicornX >= testCollision.getX() && unicornY >= testCollision.getY()
                && unicornX <= (testCollision.getX() + testCollision.getWidth()) && unicornY <= (testCollision.getY() + testCollision.getHeight())) {
            testCollision.delete();
            System.out.println("COLLISION");
            return true;
        }

        /*for (GameObject object: gameObjects) {

            if(unicornX == object.getGameObjectPicture().getX() || unicornY == object.getGameObjectPicture().getY()) {
                return true;
            }

        }*/
        return false;
    }


}
