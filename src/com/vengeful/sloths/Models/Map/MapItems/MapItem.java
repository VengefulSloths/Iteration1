package com.vengeful.sloths.Models.Map.MapItems;

import com.vengeful.sloths.Models.Entity.Entity;

/**
 * Created by John on 1/30/2016.
 */
public abstract class MapItem {

    protected boolean destroy = false;
    protected String itemName;
    protected String graphicFolder;

    public abstract void interact(Entity entity);

    public boolean canMove(){
        return true;
    }

    public String getItemName(){
        return this.itemName;
    }

    public boolean destroyFlag()
    {
        return destroy;
    }

    public void destroy(){
        //add later
        //notify observe
    }
}
