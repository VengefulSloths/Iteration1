package com.vengeful.sloths.Models.Map;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.Terrains.Grass;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by John on 1/30/2016.
 */
public class Tile {

    private Entity entity = null;
    private boolean canBeMovedOn;
    private ArrayList<MapItem> mapItems;
    private ArrayList<AreaEffect> areaEffect;
    private ArrayList<Decal> decals;
    private Terrain terrain;


    public Tile(){
        canBeMovedOn = true;
        mapItems = new ArrayList<MapItem>();
        areaEffect = new ArrayList<AreaEffect>();
        decals = new ArrayList<Decal>();
        terrain = new Grass();
    }

    public Tile(Terrain terrain){
        canBeMovedOn = true;
        mapItems = new ArrayList<MapItem>();
        areaEffect = new ArrayList<AreaEffect>();
        decals = new ArrayList<Decal>();
        this.terrain = terrain;
    }

    public void execute(){

    }

    public boolean canMove(){
        if(mapItems.size() <= 0) {
            return terrain.canMove();
        }else{
            boolean canMove = true;

            for (Iterator<MapItem> iter = mapItems.iterator(); iter.hasNext();) {
                MapItem item = iter.next();
                canMove = canMove && item.canMove();
            }
            return (canMove && terrain.canMove());
        }
    }

    public void addEntity(Entity entity){
        //may need to check for an entity already being on the tile
        this.entity = entity;
    }

    public boolean hasEntity() { return this.entity != null; }

    public Entity getEntity() {
        return this.entity;
    }

    public Entity removeEntity(){
        Entity entity = this.entity;
        this.entity = null;
        return entity;
    }

    public Terrain getTerrain() { return this.terrain; }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public Iterator<MapItem> getMapItemIterator() {
        return mapItems.iterator();
    }

    public void addMapItem(MapItem mapItem) {
        mapItems.add(mapItem);
    }
    private void cleanUp(){
        //check for one shots to with bool to be removed and remove them
    }
}
