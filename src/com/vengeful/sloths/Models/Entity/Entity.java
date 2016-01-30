package com.vengeful.sloths.Models.Entity;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Entity {
    private int xCoord;
    private int yCoord;

    public Entity() {

    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }


}
