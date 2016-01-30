package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Utility.Coord;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Entity {
    private Coord loc;

    public Entity() {

    }

    public Coord getLoc() {
        return loc;
    }

    public void setLoc(Coord coord) {
        loc = coord;
    }


}
