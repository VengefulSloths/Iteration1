package com.vengeful.sloths.Utility.TileVisitor;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Models.SaveLoad.Saveable;
import com.vengeful.sloths.Utility.Coord;

import java.util.ArrayList;


/**
 * Created by Ian on 2/5/2016.
 */
public class SaveVisitor extends TileVisitor{
    private SaveManager sm;
    public SaveVisitor(Map m, SaveManager sm){
        this.map = m;
        this.sm = sm;
    }

    public void visitTiles()
    {
        Tile[][] tile =  map.getTiles();
        for(int i =0; i < tile.length;++i) {
            for(int j = 0;j < tile[i].length;++j){
                Coord c = new Coord(i,j);
                map.getTile(c).accept(this);
            }
        }
    }

    public void doVisit(Tile t)
    {
        ArrayList<Saveable> s= t.getSaveables();
        sm.addSaveables(s);
    }
}

