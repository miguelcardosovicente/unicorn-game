package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class HappinessMeter {

    private Rectangle happinessMeterBorder;

    private Rectangle happinessFilling;

    public HappinessMeter() {
        happinessMeterBorder = new Rectangle(12, 13, 152, 25);
        happinessFilling = new Rectangle(13, 14,  0, 24);
    }

    public void draw() {

        happinessMeterBorder.draw();

        happinessFilling.setColor(Color.PINK);
        happinessFilling.draw();
        happinessFilling.fill();

    }

    public void fillMeter(int happiness) {
        int maxHappiness = 100;
        int percentageHappiness = happiness * 100 / maxHappiness;

        happinessFilling = new Rectangle(13, 14, percentageHappiness * 1.51, 24);
        draw();

    }

    public void delete() {
        happinessFilling.delete();
    }

}

