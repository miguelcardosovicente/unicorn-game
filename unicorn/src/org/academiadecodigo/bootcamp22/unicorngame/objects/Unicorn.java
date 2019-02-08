package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Unicorn implements KeyboardHandler {

    private Keyboard keyboard = new Keyboard(this);

    private KeyboardEvent eventUp = new KeyboardEvent();
    private KeyboardEvent eventDown = new KeyboardEvent();
    private KeyboardEvent eventLeft = new KeyboardEvent();
    private KeyboardEvent eventRight = new KeyboardEvent();

    private int happiness = 30;

    private Picture unicornPicture = new Picture(250, 250, "resources/unicornicon_left.png");

    private HappinessMeter meter = new HappinessMeter();

    public int getHappiness() {
        return happiness;
    }

    public void move() {

        unicornPicture.draw();
        meter.draw();

        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                moveDown();
                break;
            case KeyboardEvent.KEY_LEFT:
                moveLeft();
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveRight();
                break;
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        return;
    }

    private void moveUp() {

        if(unicornPicture.getY() >= 50) {
            happiness += 10;
            meter.fillMeter(happiness);

            unicornPicture.translate(0, -60);
        }

    }

    private void moveDown() {

        if(unicornPicture.getMaxY() <= 640) {

            happiness -= 10;

            Rectangle blank = new Rectangle(13, 14,  151, 24);
            blank.setColor(Color.WHITE);
            blank.draw();
            blank.fill();

            meter.fillMeter(happiness);
            unicornPicture.translate(0, 60);
        }

    }

    private void moveLeft() {

        if(unicornPicture.getX() >= 10) {

            int currentX = unicornPicture.getX();
            int currentY = unicornPicture.getY();

            unicornPicture.delete();
            unicornPicture = new Picture(currentX, currentY, "resources/unicornicon_left.png");
            unicornPicture.draw();

            unicornPicture.translate(-60, 0);
        }

    }

    private void moveRight() {

        if(unicornPicture.getMaxX() <= 600) {

            int currentX = unicornPicture.getX();
            int currentY = unicornPicture.getY();

            unicornPicture.delete();
            unicornPicture = new Picture(currentX, currentY, "resources/unicornicon_right.png");
            unicornPicture.draw();

            unicornPicture.translate(60, 0);
        }

    }

    private class HappinessMeter {

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

}
