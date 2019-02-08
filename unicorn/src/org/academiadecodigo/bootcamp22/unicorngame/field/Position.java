package org.academiadecodigo.bootcamp22.unicorngame.field;

import java.util.Random;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x+10;
    }

    public int getY() {
        return y+10;
    }

    public static int genPos(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(max + 1 - min) + min;
        return randomNumber;
    }
}
