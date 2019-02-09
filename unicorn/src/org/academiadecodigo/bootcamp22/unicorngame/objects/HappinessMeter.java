package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class HappinessMeter {

    private Rectangle happinessMeterBorder = new Rectangle(12, 13, 152, 25);

    private Rectangle happinessFilling = new Rectangle(13, 14, 0, 24);


    public void draw() {

        happinessMeterBorder.draw();

        happinessFilling.setColor(Color.PINK);
        happinessFilling.draw();
        happinessFilling.fill();

    }

    public void updateMeter(int happiness) {

        happinessFilling.delete();

        int maxHappiness = 100;

        if(happiness < 0) {
            happiness = 0;
        }

        if(happiness > maxHappiness) {
            happiness = maxHappiness;
        }

        int percentageHappiness = happiness * 100 / maxHappiness;

        happinessFilling = new Rectangle(13, 14, percentageHappiness * 1.51, 24);

        draw();
    }

}
