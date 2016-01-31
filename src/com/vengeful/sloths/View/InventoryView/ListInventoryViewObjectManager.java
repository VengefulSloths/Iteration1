package com.vengeful.sloths.View.InventoryView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryViewObjectManager {
    private ArrayList<InventoryItemViewObject> itemList;

    public ListInventoryViewObjectManager() {
        itemList = new ArrayList<InventoryItemViewObject>();
    }

    public void addInventoryItemViewObject(InventoryItemViewObject itemView) {
        //We can sort on iterator because it will be called less
        itemList.add(itemView);
    }

    public Iterator<InventoryItemViewObject> iterator() {
        return itemList.iterator();
    }

}
