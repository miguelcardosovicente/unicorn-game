package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Keyboard keyboard = new Keyboard(this);

    private KeyboardEvent eventStart = new KeyboardEvent();

    //private Picture menuPicture = new Picture(10, 10, path);
    private Rectangle menuPicture = new Rectangle(10, 10, 610, 650);

    public void showMenu() {

        menuPicture.setColor(Color.CYAN);
        menuPicture.draw();
        menuPicture.fill();

        eventStart.setKey(KeyboardEvent.KEY_SPACE);
        eventStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventStart);

    }

    public boolean startGame() {
        return true;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            System.out.println("Let the game begin!");
            startGame();
            //start game
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        return;
    }
}
