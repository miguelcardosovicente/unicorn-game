package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Menu implements KeyboardHandler {

    private Keyboard keyboard = new Keyboard(this);
    private Game.State state;

    private Picture menuPicture = new Picture(10, 10, "resources/game_menu.png");

    public Menu() {

        KeyboardEvent eventStart = new KeyboardEvent();
        eventStart.setKey(KeyboardEvent.KEY_SPACE);
        eventStart.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(eventStart);

        state = Game.State.MENU;
    }

    public Game.State showMenu() throws InterruptedException {

        menuPicture.draw();

        while (state == Game.State.MENU) {
            Thread.sleep(50);
        }

        menuPicture.delete();
        return state;

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            state = Game.State.GAME;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        return;
    }

}
