package com.vengeful.sloths.Models.Inventory;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Models.SaveLoad.Saveable;
import com.vengeful.sloths.Models.ViewObservable;
import com.vengeful.sloths.View.Observers.InventoryObserver;
import com.vengeful.sloths.View.Observers.ModelObserver;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by qianwen on 1/30/16.
 */
public class Inventory implements ViewObservable, Saveable {
    private ArrayList<InventoryItem> inventory;
    private int currentSize;

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    protected ArrayList<InventoryObserver> inventoryObservers;


    public Inventory() {
        inventory = new ArrayList<InventoryItem>();

        this.inventoryObservers = new ArrayList<>();

        this.currentSize = 0;

    }

    public void listInventoryItems() {
        for (InventoryItem i: inventory) {
            //System.out.Println("hddhadhjkcskhjdskhjdsh");
            //System.out.Println(i);
        }
    }

    public InventoryItem getItem(int index){
        if(index < 0 || index >= inventory.size())
            return null;

        return inventory.get(index);
    }

    public boolean hasItem(InventoryItem item){
        return this.inventory.contains(item);
    }


    public void initInventoryObserversList() {
        this.inventoryObservers = new ArrayList<>();
    }

    public void alertObserversFromLoad() {
        Iterator<InventoryObserver> iter = this.inventoryObservers.iterator();
        while (iter.hasNext()) {


            InventoryObserver io = iter.next();
            for (InventoryItem i : inventory)
            io.alertItemAdded(i);
        }
    }

    public int getSize() {
        return this.currentSize;
    }

    public boolean addItem(InventoryItem item) {
        ++this.currentSize;

        //@TODO: REMOVE REMOVE REMOVE
        Iterator<InventoryObserver> iter = this.inventoryObservers.iterator();
        while (iter.hasNext()) {
            InventoryObserver io = iter.next();
            io.alertItemAdded(item);
        }

        return inventory.add(item);
    }

    public boolean removeItem(InventoryItem item) {
        --this.currentSize;

        if (this.currentSize-- <= 0)
            this.currentSize = 0;

        Iterator<InventoryObserver> iter = this.inventoryObservers.iterator();
        while (iter.hasNext()) {
            InventoryObserver io = iter.next();
            io.alertItemDropped(item);
        }

        return inventory.remove(item);
    }

    public void registerObserver(ModelObserver modelObserver) {
        this.inventoryObservers.add((InventoryObserver) modelObserver);
    }

    public void deregisterObserver(ModelObserver modelObserver) { this.inventoryObservers.remove(modelObserver);}

    public void saveMe(SaveManager sv, int ws)
    {
        sv.writeClassLine(ws, "Inventory");
        for(InventoryItem ii: inventory){
            ii.saveMe(sv, ws+1);
        }
        String cs = ""+currentSize;
        sv.writeVariableLine(ws,"currentSize", cs, true);
    }

    public boolean hasItem(String itemName){
        for (InventoryItem i: inventory) {
            if(i.getItemName().equals(itemName))
                return true;
        }
        return false;
    }

}
