package com.vengeful.sloths.Models.InventoryItems;

import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;

/**
 * Created by qianwen on 1/30/16.
 */
public abstract class InventoryItem {

    private TakeableItem mapItemRep;
    protected String itemName;

    public InventoryItem(){

    }


    //Will be called in TakeableItem when takeable item is created
    public void setTakeableItem(TakeableItem item){
        this.mapItemRep = item;
    }

    public String getItemName(){
        return this.itemName;
    }

    public TakeableItem getMapItemRep(){
        return this.mapItemRep;
    }

}
