package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.View.AreaView.Observers.ModelObserver;

/**
 * Created by zach on 2/1/16.
 */
public interface InventoryObserver extends ModelObserver {
    void alertItemAdded(InventoryItem item);
    void alertItemDropped(InventoryItem item);
}
