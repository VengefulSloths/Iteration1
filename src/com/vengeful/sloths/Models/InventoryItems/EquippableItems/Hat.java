package com.vengeful.sloths.Models.InventoryItems.EquippableItems;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.Stats.BaseStats;

/**
 * Created by qianwen on 1/30/16.
 */
public class Hat extends EquippableItems {

    public Hat(BaseStats b){
        super(b);

        //Set BaseStats
        b.setStats(0, 0, 0, 10, 0); //Once equipped, increase avatar stats by these factors
    }

}
