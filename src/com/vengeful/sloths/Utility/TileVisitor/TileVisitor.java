package com.vengeful.sloths.Utility.TileVisitor;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.Tile;

/**
 * Created by Ian on 2/5/2016.
 */
public abstract class TileVisitor {
    protected Map map;

    public TileVisitor(){}

    public TileVisitor(Map m)
    {
        this.map = m;
    }

    public abstract void visitTiles();
    public abstract void doVisit(Tile t);
}
