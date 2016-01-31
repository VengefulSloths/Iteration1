package com.vengeful.sloths.Models.Inventory;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

import java.util.ArrayList;

/**
 * Created by qianwen on 1/30/16.
 */
public class Inventory {
    private ArrayList<InventoryItem> inventory;

    public Inventory(){
        inventory = new ArrayList<InventoryItem>();
    }

    public InventoryItem getItem(int index){
        return inventory.get(index);
    }

    public boolean addItem(InventoryItem item){
        return inventory.add(item);
    }

    public boolean removeItem(InventoryItem item){
        return inventory.remove(item);
    }

}
