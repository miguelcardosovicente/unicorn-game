package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject {

    private final int MIN_X = 10;
    private final int MAX_X = 550;
    private final int MIN_Y = 50;
    private final int MAX_Y = 550;

    private GameObjectsType type;
    private Picture gameObjectPicture;

    public GameObject(GameObjectsType type) {
        this.type = type;
        gameObjectPicture = new Picture(randomX(), randomY(), type.getPicturePath());
    }

    public Picture getGameObjectPicture() {
        return gameObjectPicture;
    }

    public int getScore() {
       return type.getScore();
    }

    public int randomX() {
        return (int) Math.floor(Math.random() * MAX_X) + MIN_X;
    }

    public int randomY() {
        return (int) Math.floor(Math.random() * MAX_Y) + MIN_Y;
    }
}
