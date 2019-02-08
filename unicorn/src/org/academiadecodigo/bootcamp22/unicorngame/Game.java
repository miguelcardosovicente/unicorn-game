package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.HappinessMeter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.TimeCounter;
import org.academiadecodigo.bootcamp22.unicorngame.objects.Unicorn;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game {

    private Picture background = new Picture(10, 50, "resources/background_sad.jpg");
    private Unicorn unicorn = new Unicorn();
    private TimeCounter timer = new TimeCounter(15);
    private HappinessMeter meter = new HappinessMeter();

    public void start() {

        background.draw();
        unicorn.getUnicornPicture().draw();
        meter.draw();

        timer.start();
        unicorn.move();

        while(true) {
            updateBackground();
            meter.updateMeter(unicorn.getHappiness());
        }

    }

    private void updateBackground() {

        if(unicorn.getHappiness() < 40) {
            background.load("resources/background_sad.jpg");
            return;
        }

        if(unicorn.getHappiness() > 70) {
            background.load("resources/background_happy.jpg");
            return;
        }

        background.load("resources/background_medium.jpg");

    }

}
