package com.vengeful.sloths.Models.InventoryItems.EquippableItems;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.SaveLoad.Saveable;
import com.vengeful.sloths.Models.Stats.BaseStats;

/**
 * Created by qianwen on 1/30/16.
 */
public abstract class EquippableItems extends InventoryItem implements Saveable {
    protected BaseStats itemStats;
    //private BaseStats baseStats;


    public BaseStats getItemStats() {
        return itemStats;
    }

    //public EquippableItems(String itemName, BaseStats b){
        //super(); //not needed
    //    this.itemName = itemName;
    //    this.itemStats = b;
    //}

    public EquippableItems(String itemName){
        //super(); //not needed
        this.itemName = itemName;
        this.itemStats = new BaseStats(0,0,0,0,0);
    }

    public void saveMe(){
        System.out.println("save: " + this.toString());
        itemStats.saveMe();
    }

}
