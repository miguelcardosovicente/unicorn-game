package org.academiadecodigo.bootcamp22.unicorngame.objects;

public enum GameObjectsType {

    DONUT(3, "resources/donut.png"),
    CRYSTAL(10, "resources/crystal.png"),
    RAINBOW(5, "resources/rainbow.png"),
    CHERRY_POOP(8, "resources/cherry_poop.png"),
    POOP(-8, "resources/poop.png"),
    BLACKHOLE(-25, "resources/blackhole.png"),
    ROCK(-5, "resources/rock.png"),
    VAMPIRE(-3, "resources/vampire.png");

    private int score;
    private String picturePath;

    GameObjectsType(int score, String path) {
        this.score = score;
        this.picturePath = path;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public int getScore() {
        return score;
    }

}
