package com.vengeful.sloths.Models.InventoryItems.EquippableItems;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.Stats.BaseStats;

/**
 * Created by qianwen on 1/30/16.
 */
public class Hat extends EquippableItems {

    //TODO: this needs to be uncommented so we can create Hat of different stats
    //public Hat(String hatName, BaseStats b){
    //    super(hatName, b);
    //}


    public Hat(String hatName){
        super(hatName);
        //this.itemStats.setStats(0, 0, 0, 10, 0); //Once equipped, increase avatar stats by these factors. Currently causes error so used line below.
        //this.itemStats = new BaseStats(0,0,0,10,0);
        this.itemStats.setStats(0,0,0,10,0);
    }


}
