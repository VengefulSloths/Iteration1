package com.vengeful.sloths.Models.Inventory;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

import java.util.ArrayList;

/**
 * Created by qianwen on 1/30/16.
 */
public class Equipped {
    private ArrayList<EquippableItems> equipped;

    public Equipped(){
        equipped = new ArrayList<EquippableItems>();
    }

    public InventoryItem getItem(int itemIndex){
        return equipped.get(itemIndex);
    }

    public boolean addItem(EquippableItems item){
        return equipped.add(item);
    }

    public boolean removeItem(EquippableItems item){
        return equipped.remove(item);
    }

}
