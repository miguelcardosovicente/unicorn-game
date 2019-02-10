package org.academiadecodigo.bootcamp22.unicorngame.elements;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Unicorn implements KeyboardHandler {

    private Keyboard keyboard = new Keyboard(this);
    private Picture unicornPicture;

    private final int UPPER_GRID_LIMIT = 50;
    private final int LOWER_GRID_LIMIT = 650;
    private final int LEFT_GRID_LIMIT = 10;
    private final int RIGHT_GRID_LIMIT = 610;
    private int happiness = 0;

    public Unicorn() {

        unicornPicture = new Picture(10, 50, "resources/unicornicon_right.png");

        KeyboardEvent eventUp = new KeyboardEvent();
        eventUp.setKey(KeyboardEvent.KEY_UP);
        eventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventUp);

        KeyboardEvent eventDown = new KeyboardEvent();
        eventDown.setKey(KeyboardEvent.KEY_DOWN);
        eventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventDown);

        KeyboardEvent eventLeft = new KeyboardEvent();
        eventLeft.setKey(KeyboardEvent.KEY_LEFT);
        eventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventLeft);

        KeyboardEvent eventRight = new KeyboardEvent();
        eventRight.setKey(KeyboardEvent.KEY_RIGHT);
        eventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventRight);
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int score) {

        int total = this.happiness + score;

        if(total > 100) {
            this.happiness = 100;
            return;
        }

        if(total < 0) {
            this.happiness = 0;
            return;
        }

        this.happiness = total;
    }

    public Picture getUnicornPicture() {
        return unicornPicture;
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

        if(unicornPicture.getY() > UPPER_GRID_LIMIT) {
            unicornPicture.translate(0, -unicornPicture.getHeight());
        }

    }

    private void moveDown() {

        if(unicornPicture.getMaxY() < LOWER_GRID_LIMIT) {
            unicornPicture.translate(0, unicornPicture.getHeight());
        }

    }

    private void moveLeft() {

        if(unicornPicture.getX() > LEFT_GRID_LIMIT) {
            unicornPicture.load("resources/unicornicon_left.png");
            unicornPicture.translate(-unicornPicture.getWidth(), 0);
        }

    }

    private void moveRight() {

        if(unicornPicture.getMaxX() < RIGHT_GRID_LIMIT) {
            unicornPicture.load("resources/unicornicon_right.png");
            unicornPicture.translate(unicornPicture.getWidth(), 0);
        }

    }

}
