package org.academiadecodigo.bootcamp22.unicorngame.objects;

public enum GameObjectsType {

    DONUT(5, "resources/donut.png"),
    CRYSTAL(10, "resources/crystal.png"),
    RAINBOW(20, "resources/rainbow.png"),
    CHERRY_POOP(10, "resources/cherry_poop.png"),
    POOP(-8, "resources/poop.png"),
    BLACKHOLE(-30, "resources/blackhole.png"),
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
