package com.vengeful.sloths.Utility.TileVisitor;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Models.SaveLoad.MapSaveable;
import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Models.SaveLoad.Saveable;
import com.vengeful.sloths.Utility.Coord;

import java.util.ArrayList;


/**
 * Created by Ian on 2/5/2016.
 */
public class SaveVisitor extends TileVisitor{
    private SaveManager sm;
    private Coord coord = null;
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
                coord = c;
                map.getTile(c).accept(this);
            }
        }
    }

    public void doVisit(Tile t)
    {
        ArrayList<Saveable> S= t.getSaveables();
        ArrayList<MapSaveable> MS = new ArrayList<MapSaveable>();
        for(Saveable s : S)
        {
             MapSaveable ms = new MapSaveable(coord,s);
            MS.add(ms);
        }
        sm.addSaveables(MS);
    }
}

