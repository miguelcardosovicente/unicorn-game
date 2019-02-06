package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.Unicorn;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Unicorn unicorn = new Unicorn();

    public void start() {
        Picture background = new Picture(10, 50, "resources/background.jpg");
        background.draw();

        unicorn.getUnicornPicture().grow(-50, -50);
        unicorn.getUnicornPicture().draw();
        unicorn.move();

    }

}
