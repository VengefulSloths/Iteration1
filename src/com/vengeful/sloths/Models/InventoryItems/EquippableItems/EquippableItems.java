package com.vengeful.sloths.Models.InventoryItems.EquippableItems;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Stats.BaseStats;

/**
 * Created by qianwen on 1/30/16.
 */
public abstract class EquippableItems extends InventoryItem {
    protected BaseStats baseStats;

    public EquippableItems(BaseStats b){
        super();
        this.baseStats = b;
    }
}