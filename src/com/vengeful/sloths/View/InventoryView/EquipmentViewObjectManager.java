package com.vengeful.sloths.View.InventoryView;

import java.util.ArrayList;


/**
 * Created by echristiansen on 2/1/2016.
 */
public class EquipmentViewObjectManager { //don't think equip should be here. should be in the model. here just displaying the equipped


    private ArrayList<InventoryItemViewObject> equipmentList;


    public ArrayList<InventoryItemViewObject> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(ArrayList<InventoryItemViewObject> equipmentList) {
        this.equipmentList = equipmentList;
    }


    public EquipmentViewObjectManager() {
        equipmentList = new ArrayList<InventoryItemViewObject>();

    }

    public void addEquipment(InventoryItemViewObject item) { //rename populate(InventoryItemViewObject item)?
        //We can sort on iterator because it will be called less
        equipmentList.add(item);

    }


}
