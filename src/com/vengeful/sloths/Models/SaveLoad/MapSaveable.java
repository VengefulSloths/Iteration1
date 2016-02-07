package com.vengeful.sloths.Models.SaveLoad;

import com.vengeful.sloths.Utility.Coord;

/**
 * Created by icavitt on 2/6/2016.
 */
public class MapSaveable implements Saveable {
    Coord coord;
    Saveable thingOnMap;

    public MapSaveable(Coord coord, Saveable thingOnMap){
        this.coord = coord;
        this.thingOnMap = thingOnMap;
    }
    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Saveable getThingOnMap() {
        return thingOnMap;
    }

    public void setThingOnMap(Saveable thingOnMap) {
        this.thingOnMap = thingOnMap;
    }

    public void saveMe(SaveManager sv, int ws)
    {
        thingOnMap.saveMe(sv, ws);
        String c = "(" + getCoord().getX() + "," + getCoord().getY() + ")";
        sv.writeVariableLine(ws, "Coord", c, true);
    }
}
