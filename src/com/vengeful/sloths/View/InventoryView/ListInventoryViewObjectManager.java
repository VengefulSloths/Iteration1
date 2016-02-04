package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

import java.util.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryViewObjectManager { //this just manages all of the listInventoryViewObjects by keeping them in an arraylist and defining an iterator

    private ArrayList<InventoryItemViewObject> itemList;

    InventoryItemViewObject GodSwordItemViewObject;
    InventoryItemViewObject PartyHatItemViewObject;

    public ListInventoryViewObjectManager() {
        itemList = new ArrayList<InventoryItemViewObject>();
    }

    public void addInventoryItemViewObject(InventoryItemViewObject item) { //rename populate(InventoryItemViewObject item)?
        //We can sort on iterator because it will be called less
        itemList.add(item);
    }

    public InventoryItemViewObject removeInventoryItemViewObject(InventoryItem item) { //rename populate(InventoryItemViewObject item)?
        //We can sort on iterator because it will be called less
        int index = 0;
        InventoryItemViewObject ivo = null;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getInventoryItem().equals(item)) {
                ivo = itemList.get(i);
                itemList.remove(i);
            }
        }

        return ivo;
    }

    public InventoryItemViewObject getFromItemList(int index) {
        return itemList.get(index);
    }

    public void initWithInventory(Inventory inventory) {
        for (int i = 0; i < inventory.getSize(); i++) {
            InventoryItem item = inventory.getItem(i);


            if (item instanceof Hat) {
                PartyHatItemViewObject = new InventoryItemViewObject(item);
                this.addInventoryItemViewObject(PartyHatItemViewObject);
            } else if (item instanceof Sword) {
                GodSwordItemViewObject = new InventoryItemViewObject(item);
                this.addInventoryItemViewObject(GodSwordItemViewObject);
            }
        }
    }

    public int getItemListSize() {
        return itemList.size();
    }

    public Iterator<InventoryItemViewObject> iterator() {
        return itemList.iterator();
    }

}
