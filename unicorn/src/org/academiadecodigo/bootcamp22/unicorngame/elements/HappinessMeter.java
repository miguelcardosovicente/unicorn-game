package org.academiadecodigo.bootcamp22.unicorngame.elements;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HappinessMeter {

    private Picture heart_icon = new Picture(177, 12, "resources/game_heart.png");
    private Rectangle happinessMeterBorder = new Rectangle(12, 13, 152, 25);
    private Rectangle happinessFilling = new Rectangle(13, 14, 0, 24);


    public void draw() {

        heart_icon.draw();

        happinessMeterBorder.draw();

        happinessFilling.setColor(Color.PINK);
        happinessFilling.draw();
        happinessFilling.fill();
    }

    public void update(int happiness) {

        happinessFilling.delete();

        int maxHappiness = 100;

        int percentageHappiness = happiness * 100 / maxHappiness;

        happinessFilling = new Rectangle(13, 14, percentageHappiness * 1.51, 24);

        draw();
    }

}
