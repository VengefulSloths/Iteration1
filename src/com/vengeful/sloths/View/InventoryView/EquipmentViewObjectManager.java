package com.vengeful.sloths.View.InventoryView;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by echristiansen on 2/1/2016.
 */
public class EquipmentViewObjectManager extends ViewObjectManager { //don't think equip should be here. should be in the model. here just displaying the equipped


    private ArrayList<EquipmentViewObject> equipmentList;


    public ArrayList<EquipmentViewObject> getEquipmentList() {
        return equipmentList;
    }

    public void setEquipmentList(ArrayList<EquipmentViewObject> equipmentList) {
        this.equipmentList = equipmentList;
    }


    public EquipmentViewObjectManager() {
        equipmentList = new ArrayList<EquipmentViewObject>();
    }

    public void addEquipment(EquipmentViewObject item) { //rename populate(InventoryItemViewObject item)?
        //We can sort on iterator because it will be called less
        equipmentList.add(item);
    }


}
