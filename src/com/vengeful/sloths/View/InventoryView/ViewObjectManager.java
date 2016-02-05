package com.vengeful.sloths.View.InventoryView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by echristiansen on 2/3/2016.
 */
public abstract class ViewObjectManager {

    protected ArrayList<ItemViewObject> itemList;


    public ViewObjectManager() {
        this.itemList = new ArrayList<ItemViewObject>();
    }

    public ViewObjectManager(ArrayList<ItemViewObject> itemList) {
        this.itemList = itemList;
    }


    public int getItemListSize() {
        return itemList.size();
    }

    public Iterator<ItemViewObject> iterator() {
        return itemList.iterator();
    }

}
