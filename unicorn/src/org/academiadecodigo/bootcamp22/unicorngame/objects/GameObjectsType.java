package org.academiadecodigo.bootcamp22.unicorngame.objects;

public enum GameObjectsType {

    DONUT(1),
    CRYSTAL(5),
    CHERRYPOOP(8),
    RAINBOW(3),
    BLACKHOLE(-30),
    ROCK(-5),
    POOP(-8),
    VAMPIRE(-3);


    private int damage;

    GameObjectsType(int damage) {

        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public static GameObjectsType getType() {

        GameObjectsType[] types = GameObjectsType.values();
        return types[(int) (Math.random() * types.length)];

    }
}
