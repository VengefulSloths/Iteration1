package com.vengeful.sloths.Models.InventoryItems;

import com.vengeful.sloths.Models.Stats.BaseStats;

/**
 * Created by qianwen on 1/30/16.
 */
public abstract class EquippableItems extends InventoryItem {
    protected BaseStats equipmentStats;

    public EquippableItems(){
        super();
    }
}
