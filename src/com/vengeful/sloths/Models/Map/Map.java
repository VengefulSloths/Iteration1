package com.vengeful.sloths.Models.Map;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by John on 1/30/2016.
 */
public class Map {
    private int maxX;
    private int maxY;
    private Tile[][] tiles;

    public Map(Coord maxCoords) {
        tiles = new Tile[maxCoords.getX()][maxCoords.getY()];

        this.maxX = maxCoords.getX();
        this.maxY = maxCoords.getY();

        for (int i = 0; i < maxCoords.getX(); i++) {
            for (int j = 0; j < maxCoords.getY(); j++) {
                tiles[i][j] = new Tile();
            }
        }




    }

    public void addTile(Coord coord, Tile t) {
        tiles[coord.getX()][coord.getY()] = t;
    }

    public Tile getTile(Coord coord) throws IndexOutOfBoundsException{
        if (coord.getX() < 0 ||
                coord.getY() < 0 ||
                coord.getX() >= maxX ||
                coord.getY() >= maxY) {
            throw new IndexOutOfBoundsException();
        }
        Tile tile = tiles[coord.getX()][coord.getY()];
        return tile;
    }
}
