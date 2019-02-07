package org.academiadecodigo.bootcamp22.unicorngame.objects;

public class GameObjectFactory {

    public static GameObject getInstance() {

        // get random objectType
        GameObjectsType[] types = GameObjectsType.values();
        GameObjectsType type = types[(int) (Math.random() * types.length)];

        switch (type) {
            case DONUT:
                return new GameObject(type);
            case CRYSTAL:
                return new GameObject(type);
            case RAINBOW:
                return new GameObject(type);
            case CHERRY_POOP:
                return new GameObject(type);
            case POOP:
                return new GameObject(type);
            case BLACKHOLE:
                return new GameObject(type);
            case ROCK:
                return new GameObject(type);
            case VAMPIRE:
                return new GameObject(type);
            default:
                return null;
        }
    }
}
