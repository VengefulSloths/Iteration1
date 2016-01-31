package com.vengeful.sloths.Models.Map;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by John on 1/30/2016.
 */
public class Map {

    private Tile[][] tiles;

    public Map(Coord maxCoords) {
        tiles = new Tile[maxCoords.getX()][maxCoords.getY()];

        for (int i = 0; i < maxCoords.getX(); i++) {
            for (int j = 0; j < maxCoords.getY(); j++) {
                tiles[i][j] = new Tile();
            }
        }
    }

    public void addTile(Coord coord, Tile t) {
        tiles[coord.getX()][coord.getY()] = t;
    }

    public Tile getTile(Coord coord){
        Tile tile = tiles[coord.getX()][coord.getY()];
        return tile;
    }
}
