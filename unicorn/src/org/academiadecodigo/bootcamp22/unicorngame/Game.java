package org.academiadecodigo.bootcamp22.unicorngame;

import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObject;
import org.academiadecodigo.bootcamp22.unicorngame.objects.GameObjectFactory;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;


import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.util.TreeSet;

public class Game {

    private Unicorn unicorn = new Unicorn();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();


    public void start(int elements) {
        init();
        initObjects(elements);
        drawObjects();
    }


    private void init() {
        Picture background = new Picture(10, 50, "resources/background.jpg");
        background.draw();
        unicorn.getUnicornPicture().draw();
        unicorn.move();
    }

    private void initObjects(int elements) {
        for (int i = 0; i < elements; i++) {

            GameObject generated = GameObjectFactory.getInstance();

            //check if the same position has been given
            while (!verifyPosition(generated)) {
               generated =  GameObjectFactory.getInstance();
            };

            gameObjects.add(generated);

        }
    }

    private boolean verifyPosition(GameObject gameObject) {
        for (int i = 0; i < gameObjects.size(); i++) {
            GameObject current = gameObjects.get(i);

            if (current.getPosition().equals(gameObject.getPosition())) {
                return false;
            }
        }
        return true;
    }

    private void drawObjects() {

        for (int i = 0; i < gameObjects.size(); i++) {
            Picture picture = new Picture(gameObjects.get(i).getPosition().getX(), gameObjects.get(i).getPosition().getY(), gameObjects.get(i).getPath());
            picture.draw();

            System.out.println("object: " + gameObjects.get(i).getTypeString());
            System.out.println("x: " + gameObjects.get(i).getPosition().getX());
            System.out.println("y: " + gameObjects.get(i).getPosition().getY());
        }




        //Picture picture = new Picture(gameObjects.get(0).getPosition().getX() ,gameObjects.get(0).getPosition().getY(), "resources/poop.png");
        //picture.draw();

    }

}
