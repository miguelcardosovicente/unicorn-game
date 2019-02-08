package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.bootcamp22.unicorngame.field.Position;

public class GameObject {

    //private int value;
    //private String path;
    private GameObjectsType type;
    private Position position;

    public GameObject(GameObjectsType type) {
        this.type = type;
        this.position = new Position(Position.randomPosition(10, 500), Position.randomPosition(50, 500));
        //this.path = type.getPicturePath();
        //value = type.getScore();
    }

    public Position getPosition() {
        return position;
    }

    public int getScore() {
        return type.getScore();
    }

    public String getPicturePath() {
        return type.getPicturePath();
    }

    //public void changeUnicornHappiness(int score) { }

}
