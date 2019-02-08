package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.bootcamp22.unicorngame.RandomGenerator;
import org.academiadecodigo.bootcamp22.unicorngame.field.Position;

import java.util.Comparator;
import java.util.Random;

public class GameObject {

    private int value;
    private String path;

    private GameObjectsType type;
    private Position position;

    public GameObject(GameObjectsType type) {
        this.type = type;
        this.path = type.getPicturePath();

        value = type.getDamage();
        this.position = new Position(RandomGenerator.getRandom(600), RandomGenerator.getRandom(600));

    }

    public Position getPosition() {
        return position;
    }

    public String getTypeString() {
        return type.toString();
    }

    public String getPath() {
        return path;
    }
}
