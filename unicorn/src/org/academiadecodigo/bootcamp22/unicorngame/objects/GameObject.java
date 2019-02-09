package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject {

    private final int MIN_X = 10;
    private final int MAX_X = 500;
    private final int MIN_Y = 50;
    private final int MAX_Y = 500;

    //private int value;
    //private String path;
    private GameObjectsType type;
    private Picture gameObjectPicture;
    //private Position position;

    public GameObject(GameObjectsType type) {
        this.type = type;
        gameObjectPicture = new Picture(randomX(), randomY(), type.getPicturePath());
        //this.randomX(10, 500);
        //this.randomY(50, 500);
        //this.path = type.getPicturePath();
        //value = type.getScore();
    }

    /*public Position getPosition() {
        return position;
    }*/

    public Picture getGameObjectPicture() {
        return gameObjectPicture;
    }

    public int getScore() {
        return type.getScore();
    }

    public String getPicturePath() {
        return type.getPicturePath();
    }

    //public void changeUnicornHappiness(int score) { }

    public int randomX() {
        return (int) Math.floor(Math.random() * MAX_X) + MIN_X;
    }

    public int randomY() {
        return (int) Math.floor(Math.random() * MAX_Y) + MIN_Y;
    }
}
