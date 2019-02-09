package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Unicorn implements KeyboardHandler {
    //DEAL WITH BORDERS!!!!!
    private final int UPPER_GRID_LIMIT = 50; //Y = 50
    private final int LOWER_GRID_LIMIT = 650; //maxY = 650
    private final int LEFT_GRID_LIMIT = 10; //X = 10
    private final int RIGHT_GRID_LIMIT = 610; //maxX = 610

    private Keyboard keyboard = new Keyboard(this);

    private KeyboardEvent eventUp = new KeyboardEvent();
    private KeyboardEvent eventDown = new KeyboardEvent();
    private KeyboardEvent eventLeft = new KeyboardEvent();
    private KeyboardEvent eventRight = new KeyboardEvent();

    private int happiness = 0;

    private Picture unicornPicture = new Picture(350, 310, "resources/unicornicon_left.png");

    public int getHappiness() {
        return happiness;
    }

    public Picture getUnicornPicture() {
        return unicornPicture;
    }

    public void move() {

        if(happiness < 0) {
            happiness = 0;
        }

        if(happiness > 100) {
            happiness = 100;
        }


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

        if(unicornPicture.getY() >= UPPER_GRID_LIMIT) {
            unicornPicture.translate(0, -50);
        }

    }

    private void moveDown() {

        if(unicornPicture.getMaxY() <= LOWER_GRID_LIMIT) {
            unicornPicture.translate(0, 50);
        }

    }

    private void moveLeft() {

        if(unicornPicture.getX() >= LEFT_GRID_LIMIT) {
            unicornPicture.load("resources/unicornicon_left.png");
            unicornPicture.translate(-50, 0);
        }

    }

    private void moveRight() {

        if(unicornPicture.getMaxX() <= RIGHT_GRID_LIMIT) {
            unicornPicture.load("resources/unicornicon_right.png");
            unicornPicture.translate(50, 0);
        }

    }

}
