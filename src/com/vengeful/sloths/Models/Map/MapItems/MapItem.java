package com.vengeful.sloths.Models.Map.MapItems;

import com.vengeful.sloths.Models.Entity.Entity;

/**
 * Created by John on 1/30/2016.
 */
public abstract class MapItem {

    protected boolean destroy = false;

    public abstract void interact(Entity entity);

    public boolean canMove(){
        return true;
    }
}
