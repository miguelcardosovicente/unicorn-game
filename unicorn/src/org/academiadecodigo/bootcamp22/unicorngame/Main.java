package org.academiadecodigo.bootcamp22.unicorngame;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        try {
            game.start();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
