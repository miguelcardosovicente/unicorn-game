package org.academiadecodigo.bootcamp22.unicorngame;

public class RandomGenerator {
    public static int getRandom(int max) {
        return (int) (Math.random() * max);
    }
}