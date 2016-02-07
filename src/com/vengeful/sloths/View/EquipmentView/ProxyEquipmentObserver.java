package com.vengeful.sloths.View.EquipmentView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.ViewObservable;
import com.vengeful.sloths.View.Observers.ModelObserver;
import com.vengeful.sloths.View.Observers.ProxyObserver;

/**
 * Created by luluding on 2/6/16.
 */
public class ProxyEquipmentObserver extends ProxyObserver implements EquipmentObserver{

    private EquipmentObserver target;

    public ProxyEquipmentObserver(EquipmentObserver equipmentObserver, ViewObservable subject){
        this.subject = subject;
        this.subject.registerObserver(this);
        this.target = equipmentObserver;
    }

    @Override
    public ModelObserver getModelObserver() {
        return (ModelObserver)target;
    }

    @Override
    public void alertItemEquipped(EquippableItems item) {
        target.alertItemEquipped(item);
    }

    @Override
    public void alertItemUnequipped(EquippableItems item) {
        target.alertItemUnequipped(item);
    }
}
