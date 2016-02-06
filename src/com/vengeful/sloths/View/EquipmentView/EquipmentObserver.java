package com.vengeful.sloths.View.EquipmentView;

/**
 * Created by luluding on 2/6/16.
 */

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.View.Observers.ModelObserver;

public interface EquipmentObserver extends ModelObserver {
    void alertItemEquipped(EquippableItems item);
    void alertItemUnequipped(EquippableItems item);

}
