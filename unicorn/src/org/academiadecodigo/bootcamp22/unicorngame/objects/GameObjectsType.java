package org.academiadecodigo.bootcamp22.unicorngame.objects;

public enum GameObjectsType {

    DONUT(1, "resources/donut.png"),
    CRYSTAL(5, "resources/crystal.png"),
    RAINBOW(3, "resources/rainbow.png"),
    CHERRY_POOP(8, "resources/cherry_poop.png"),
    POOP(-8, "resources/poop.png"),
    BLACKHOLE(-30, "resources/blackhole.png"),
    ROCK(-5, "resources/rock.png"),
    VAMPIRE(-3, "resources/vampire.png");


    private int damage;
    private String picturePath;



    GameObjectsType(int damage, String path) {

        this.damage = damage;
        this.picturePath = path;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public int getDamage() {
        return damage;
    }


    public static GameObjectsType getType() {
        GameObjectsType[] types = GameObjectsType.values();
        return types[(int) (Math.random() * types.length)];
    }
}
