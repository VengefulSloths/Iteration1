package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Utility.Coord;

/**
 * Created by icavitt on 2/7/2016.
 */
public class ObjectWithCoord {
    private Object objectToPlace;
    private Coord c;

    ObjectWithCoord(Object objectToPlace, Coord c){
        this.objectToPlace = objectToPlace;
        this.c = c;
    }

    ObjectWithCoord(Object objectToPlace){
        this.objectToPlace = objectToPlace;
        c = null;
    }

    public Object getObjectToPlace() {
        return objectToPlace;
    }

    public Coord getC() {
        return c;
    }


}
