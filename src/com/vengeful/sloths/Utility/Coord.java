package com.vengeful.sloths.Utility;

/**
 * Created by John on 1/30/2016.
 */
public class Coord {

    private int x;
    private int y;

    public Coord(){
        x = 0;
        y = 0;
    }

    public Coord(int x, int y){
        this.x = x;
        this.y = y;
    }

    //getters and setters

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String toString() {
        return "("+x+", "+y+")";
    }
}
