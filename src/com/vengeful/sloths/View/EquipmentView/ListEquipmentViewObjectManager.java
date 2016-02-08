package com.vengeful.sloths.View.EquipmentView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.View.InventoryView.ViewObjectManager;
import com.vengeful.sloths.Models.Inventory.Equipped;

/**
 * Created by qianwen on 2/5/16.
 */
public class ListEquipmentViewObjectManager extends ViewObjectManager {

    public ListEquipmentViewObjectManager() {
        super();
    }

    public void addEquipmentViewObject(EquipmentViewObject item) {
        //We can sort on iterator because it will be called less
        itemList.add(item);
    }

    public EquipmentViewObject removeEquipmentViewObject(EquippableItems item) {
        //We can sort on iterator because it will be called less
        int index = 0;
        EquipmentViewObject ivo = null;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).getInventoryItem().equals(item)) { //Casting?
                ivo = (EquipmentViewObject) itemList.get(i);
                itemList.remove(i);
            }
        }

        return ivo;
    }

    public EquipmentViewObject getFromItemList(int index) {
        return (EquipmentViewObject) itemList.get(index);
    }

    public void initWithEquipped(Equipped equipped) {

        if(equipped.getHat() != null){
            this.addEquipmentViewObject(new EquipmentViewObject(equipped.getHat()));
        }

        if(equipped.getSword() != null){
            this.addEquipmentViewObject(new EquipmentViewObject(equipped.getSword()));
        }
    }


}
