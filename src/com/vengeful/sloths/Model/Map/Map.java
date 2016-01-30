package com.vengeful.sloths.Model.Map;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by John on 1/30/2016.
 */
public class Map {

    private Tile[][] tiles;


    public Tile getTile(Coord coord){
        Tile tile = tiles[coord.getX()][coord.getY()];
        return tile;
    }

}
