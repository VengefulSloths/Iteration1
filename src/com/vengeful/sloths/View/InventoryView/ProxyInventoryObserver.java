package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.ViewObservable;
import com.vengeful.sloths.View.Observers.ModelObserver;
import com.vengeful.sloths.View.Observers.ProxyObserver;

/**
 * Created by zach on 2/1/16.
 */
public class ProxyInventoryObserver extends ProxyObserver
        implements InventoryObserver {

    private InventoryObserver target;

    public ProxyInventoryObserver(InventoryObserver inventoryObserver, ViewObservable subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
        this.target = inventoryObserver;
    }

    @Override
    public ModelObserver getModelObserver() {
        return (ModelObserver) target;
    }

    @Override
    public void alertItemAdded(InventoryItem item) {

        System.out.println("PROXY OBSERVER");
        System.out.println("Item: " + item.getItemName() + " Added!");

        target.alertItemAdded(item);
    }

    @Override
    public void alertItemDropped(InventoryItem item) {
        System.out.println("PROXY OBSERVER");
        System.out.println("Item: " + item.getItemName() + " DROPPED!");
        target.alertItemDropped(item);
    }
}
