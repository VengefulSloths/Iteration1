package com.vengeful.sloths.Models.Map;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;

import java.util.List;

/**
 * Created by John on 1/30/2016.
 */
public class Tile {

    private Entity entity;
    private boolean canBeMovedOn;
    private List<MapItem> mapItems;
    private List<AreaEffect> areaEffect;
    private List<Decal> decals;
    private Terrain terrain;


    public void execute(){

    }

    public boolean canMove(){
        return terrain.canMove();
    }

    public void addEntity(Entity entity){
        //may need to check for an entity already being on the tile
        this.entity = entity;
    }

    public Entity removeEntity(){
        Entity entity = this.entity;
        this.entity = null;
        return entity;
    }

    private void cleanUp(){
        //check for one shots to with bool to be removed and remove them
    }
}
