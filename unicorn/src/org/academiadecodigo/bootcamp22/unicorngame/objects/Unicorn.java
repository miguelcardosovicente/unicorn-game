package org.academiadecodigo.bootcamp22.unicorngame.objects;

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

    private int happiness = 0;

    private Picture unicornPicture = new Picture(250, 250, "resources/unicornicon_left.png");

    public int getHappiness() {
        return happiness;
    }

    public Picture getUnicornPicture() {
        return unicornPicture;
    }

    public void move() {

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

            happiness += 10; //DELETE THIS

            unicornPicture.translate(0, -60);
        }

    }

    private void moveDown() {

        if(unicornPicture.getMaxY() <= 640) {

            happiness -= 5; //DELETE THIS

            unicornPicture.translate(0, 60);
        }

    }

    private void moveLeft() {

        if(unicornPicture.getX() >= 10) {
            unicornPicture.load("resources/unicornicon_left.png");
            unicornPicture.translate(-60, 0);
        }

    }

    private void moveRight() {

        if(unicornPicture.getMaxX() <= 600) {
            unicornPicture.load("resources/unicornicon_right.png");
            unicornPicture.translate(60, 0);
        }

    }

}
