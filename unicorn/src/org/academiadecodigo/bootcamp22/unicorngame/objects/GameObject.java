package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.bootcamp22.unicorngame.elements.Unicorn;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject {

    private final int MIN_X = 10;
    private final int MAX_X = 550;
    private final int MIN_Y = 50;
    private final int MAX_Y = 550;

    private int timesMoved;
    private Unicorn.Direction lastMove;
    private int turnFactor;
    private int pixelTick;

    private GameObjectsType type;
    private Picture gameObjectPicture;
    private boolean crashed = false;

    public GameObject(GameObjectsType type) {
        this.type = type;
        this.turnFactor = 4;
        this.pixelTick = 7;
        this.lastMove = Unicorn.Direction.UP;
        gameObjectPicture = new Picture(randomX(), randomY(), type.getPicturePath());
    }

    public void move() {
        // only bad guy
        if (!crashed && getScore() < 0) {
            Unicorn.Direction choosenDirection = lastMove;

            if (timesMoved > turnFactor) {
                while (choosenDirection == lastMove || choosenDirection == getOposite(lastMove)) {
                    Unicorn.Direction[] directions = Unicorn.Direction.values();
                    choosenDirection = directions[(int) (Math.random() * directions.length)];
                }
                timesMoved = 0;
            }

            timesMoved++;

            switch (choosenDirection) {
                case UP:
                    if (gameObjectPicture.getY() - pixelTick < 50) {
                        return;
                    }
                    gameObjectPicture.translate(0, -pixelTick);
                    lastMove = Unicorn.Direction.UP;
                    break;
                case DOWN:
                    if (gameObjectPicture.getY() + pixelTick > (600 - gameObjectPicture.getWidth())) {
                        return;
                    }
                    gameObjectPicture.translate(0, pixelTick);
                    lastMove = Unicorn.Direction.DOWN;
                    break;
                case RIGHT:
                    if (gameObjectPicture.getX() + pixelTick > (600 - gameObjectPicture.getWidth())) {
                        return;
                    }
                    gameObjectPicture.translate(pixelTick, 0);
                    lastMove = Unicorn.Direction.RIGHT;
                    break;
                case LEFT:
                    if (gameObjectPicture.getX() - pixelTick < 10) {
                        return;
                    }
                    gameObjectPicture.translate(-pixelTick, 0);
                    lastMove = Unicorn.Direction.LEFT;
                    break;
                case STOP:
                    break;
            }
        }
    }

    private Unicorn.Direction getOposite(Unicorn.Direction direction) {
        switch (direction) {
            case UP:
                return Unicorn.Direction.DOWN;
            case DOWN:
                return Unicorn.Direction.UP;
            case LEFT:
                return Unicorn.Direction.RIGHT;
            case RIGHT:
                return Unicorn.Direction.LEFT;
            case STOP:
                return Unicorn.Direction.UP;
        }
        return null;
    }

    public Picture getGameObjectPicture() {
        return gameObjectPicture;
    }

    public int getScore() {
        return type.getScore();
    }

    public boolean isCrashed() {
        return crashed;
    }

    public void setCrashed() {
        crashed = true;
    }

    public int randomX() {
        return (int) Math.floor(Math.random() * MAX_X) + MIN_X;
    }

    public int randomY() {
        return (int) Math.floor(Math.random() * MAX_Y) + MIN_Y;
    }
}
