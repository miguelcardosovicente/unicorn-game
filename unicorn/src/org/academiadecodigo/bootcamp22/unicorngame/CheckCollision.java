package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.field.Position;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;

public class CheckCollision {

    private GameObject[] gameobjects;
    private Unicorn unicorn;

    public CheckCollision(GameObject[] gameobjects){
        this.gameobjects = gameobjects;
    }

    public boolean samePosition(Position position){
        for (GameObject object: gameobjects) {
            if(object.getPosition() == unicorn.getUnicornPicture().getMaxX(), unicorn.getUnicornPicture().getMaxY());
        }
    }


}
