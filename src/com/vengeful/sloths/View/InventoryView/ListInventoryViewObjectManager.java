package com.vengeful.sloths.View.InventoryView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryViewObjectManager { //this just manages all of the listInventoryViewObjects by keeping them in an arraylist and defining an iterator

    private ArrayList<InventoryItemViewObject> itemList;

    public ListInventoryViewObjectManager() {
        itemList = new ArrayList<InventoryItemViewObject>();

    }

    public void addInventoryItemViewObject(InventoryItemViewObject item) { //rename populate(InventoryItemViewObject item)?
        //We can sort on iterator because it will be called less
        itemList.add(item);
    }


    public int getItemListSize() {
        return itemList.size();
    }

    public Iterator<InventoryItemViewObject> iterator() {
        return itemList.iterator();
    }

}
