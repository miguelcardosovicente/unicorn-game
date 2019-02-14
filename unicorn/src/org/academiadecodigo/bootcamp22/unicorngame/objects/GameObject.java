package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.bootcamp22.unicorngame.elements.Direction;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObject {

    private final int MIN_X = 10;
    private final int MAX_X = 550;
    private final int MIN_Y = 50;
    private final int MAX_Y = 550;

    private int timesMoved;
    private Direction lastMove;
    private int turnFactor;
    private int pixelTick;

    private GameObjectsType type;
    private Picture gameObjectPicture;
    private boolean crashed = false;

    public GameObject(GameObjectsType type) {
        this.type = type;
        turnFactor = 4;
        pixelTick = 7;
        lastMove = Direction.UP;
        gameObjectPicture = new Picture(randomX(), randomY(), type.getPicturePath());
    }

    public void move() {
        // only bad guy
        if (!crashed && getScore() < 0) {
            Direction chosenDirection = lastMove;

            if (timesMoved > turnFactor) {
                while (chosenDirection == lastMove || chosenDirection == getOpposite(lastMove)) {
                    Direction[] directions = Direction.values();
                    chosenDirection = directions[(int) (Math.random() * directions.length)];
                }
                timesMoved = 0;
            }

            timesMoved++;

            switch (chosenDirection) {
                case UP:
                    if (gameObjectPicture.getY() - pixelTick < 50) {
                        return;
                    }
                    gameObjectPicture.translate(0, -pixelTick);
                    lastMove = Direction.UP;
                    break;
                case DOWN:
                    if (gameObjectPicture.getY() + pixelTick > (600 - gameObjectPicture.getWidth())) {
                        return;
                    }
                    gameObjectPicture.translate(0, pixelTick);
                    lastMove = Direction.DOWN;
                    break;
                case RIGHT:
                    if (gameObjectPicture.getX() + pixelTick > (600 - gameObjectPicture.getWidth())) {
                        return;
                    }
                    gameObjectPicture.translate(pixelTick, 0);
                    lastMove = Direction.RIGHT;
                    break;
                case LEFT:
                    if (gameObjectPicture.getX() - pixelTick < 10) {
                        return;
                    }
                    gameObjectPicture.translate(-pixelTick, 0);
                    lastMove = Direction.LEFT;
                    break;
                case STOP:
                    break;
            }
        }
    }

    private Direction getOpposite(Direction direction) {
        switch (direction) {
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;
            case STOP:
                return Direction.UP;
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
