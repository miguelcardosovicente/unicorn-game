package org.academiadecodigo.bootcamp22.unicorngame.objects;

import org.academiadecodigo.bootcamp22.unicorngame.field.Position;

public abstract class GameObject {

    private int value;
    private GameObjectsType type;
    private Position position;

    public GameObject() {
        /**
         * Get the value of our object
         */
        value = type.getDamage();

        /** Create a new position for our object */
        this.position = new Position();

    }

     public void getValue(){

        //unicorn not implemented

     }




}
