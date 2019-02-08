package org.academiadecodigo.bootcamp22.unicorngame.objects;

public abstract class GameObjectFactory {

    public static GameObject getGameObject() {

        double random = Math.random(); //13% chance of everything; 9% chance of black hole

        if(random < 0.09) {
            return new GameObject(GameObjectsType.BLACKHOLE);
        }

        if(random < 0.22) {
            return new GameObject(GameObjectsType.POOP);
        }

        if(random < 0.35) {
            return new GameObject(GameObjectsType.ROCK);
        }

        if(random < 0.48) {
            return new GameObject(GameObjectsType.VAMPIRE);
        }

        if(random < 0.61) {
            return new GameObject(GameObjectsType.CHERRY_POOP);
        }

        if(random < 0.74) {
            return new GameObject(GameObjectsType.CRYSTAL);
        }

        if(random < 0.87) {
            return new GameObject(GameObjectsType.DONUT);
        }

        return new GameObject(GameObjectsType.RAINBOW);

        /* get random objectType
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
        }*/

    }


}
