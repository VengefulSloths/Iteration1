package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by echristiansen on 2/1/2016.
 */
public class EquipmentViewObjectManager extends ViewObjectManager { //don't think equip should be here. should be in the model. here just displaying the equipped

    public EquipmentViewObjectManager() {
        super();
    }

    public void addEquipmentViewObject(EquipmentViewObject item) {
        //We can sort on iterator because it will be called less
        itemList.add(item);
    }

    public EquipmentViewObject removeEquipmentViewObject(InventoryItem item) {
        //We can sort on iterator because it will be called less
        int index = 0;
        EquipmentViewObject ivo = null;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getInventoryItem().equals(item)) {
                ivo = (EquipmentViewObject) itemList.get(i);
                itemList.remove(i);
            }
        }

        return ivo;
    }

    public EquipmentViewObject getFromEquipmentList(int index) {
        return (EquipmentViewObject) itemList.get(index);
    }

}
