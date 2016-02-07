package com.vengeful.sloths.Controller.ControllerStates;


import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.View.EquipmentView.EquipmentView;
import com.vengeful.sloths.View.EquipmentView.ListEquipmentView;

/**
 * Created by qianwen on 2/5/16.
 */
public class EquipmentState extends MainControllerState{

    private EquipmentView equipmentView;
    private int equipmentIndex;

    public EquipmentState(MainController m){
        super(m);

        this.equipmentIndex = 0;
        this.equipmentView = m.getDefaultViewManager().getEquipmentView();
    }


    public int getEquipmentIndex() {
        return this.equipmentIndex;
    }


    public EquipmentView getEquipmentView(){
        return this.equipmentView;
    }


    @Override
    public boolean handleIKey() {
        if(((ListEquipmentView) this.equipmentView).manager.getItemListSize() > 0)
            ((ListEquipmentView)this.equipmentView).setDeselected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex));
        mainController.setInventoryState();
        return true;
    }

    @Override
    public boolean handleEKey() {

        if(((ListEquipmentView) this.equipmentView).manager.getItemListSize() > 0)
            ((ListEquipmentView)this.equipmentView).setDeselected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex));
        mainController.setAvatarState();
        return true;
    }

    @Override
    public boolean handleESCKey() {
        mainController.setAvatarState();
        return true;
    }

    @Override
    public boolean handle1Key() {
        return false;
    }

    @Override
    public boolean handle2Key() {
        //move down the list

        int itemListSize = ((ListEquipmentView) this.equipmentView).manager.getItemListSize();

        if(itemListSize == 0)
            return false;


        this.equipmentIndex++;


        if (this.equipmentIndex >= itemListSize) {
            ((ListEquipmentView)this.equipmentView).setDeselected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex-1));
            this.equipmentIndex = 0;
        }else{
            if (this.equipmentIndex > 0)
                ((ListEquipmentView)this.equipmentView).setDeselected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex-1));
        }

        ((ListEquipmentView)this.equipmentView).setSelected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex));
        return true;
    }

    @Override
    public boolean handle3Key() {
        return false;
    }

    @Override
    public boolean handle4Key() {
        return false;
    }

    @Override
    public boolean handle6Key() {
        return false;
    }

    @Override
    public boolean handle7Key() {
        return false;
    }

    @Override
    public boolean handle8Key() {
        // Move up an item
        int itemListSize = ((ListEquipmentView) this.equipmentView).manager.getItemListSize();

        if(itemListSize == 0)
            return false;

        this.equipmentIndex--;

        if (this.equipmentIndex < 0) {
            ((ListEquipmentView)this.equipmentView).setDeselected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex + 1));
            this.equipmentIndex = itemListSize-1;
        }else{
            if (this.equipmentIndex < itemListSize)
                ((ListEquipmentView)this.equipmentView).setDeselected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex + 1));
        }

        ((ListEquipmentView)this.equipmentView).setSelected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex));
        return true;
    }

    @Override
    public boolean handle9Key() {
        return false;
    }

    @Override
    public boolean handle5Key() {

        int itemListSize = ((ListEquipmentView) this.equipmentView).manager.getItemListSize();

        if(itemListSize <= 0)
            return false;
        else if(this.equipmentIndex >= itemListSize || this.equipmentIndex < 0)
            return false;

        InventoryItem i = ((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex).getInventoryItem();
        if(i != null){
            mainController.getAvatar().unequip(i);

            itemListSize = ((ListEquipmentView) this.equipmentView).manager.getItemListSize();

            if(itemListSize == 0)
                this.equipmentIndex = 0; //do not highlight anything
            else if(this.equipmentIndex >= itemListSize){
                this.equipmentIndex--;
                ((ListEquipmentView)this.equipmentView).setSelected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex));
            }else
                ((ListEquipmentView)this.equipmentView).setSelected(((ListEquipmentView)this.equipmentView).manager.getFromItemList(this.equipmentIndex));
        }
        return true;

    }

    @Override
    public boolean handleDKey() {
        return false;
    }

    @Override
    public void handleRelease1Key() {

    }

    @Override
    public void handleRelease2Key() {

    }

    @Override
    public void handleRelease3Key() {

    }

    @Override
    public void handleRelease4Key() {

    }

    @Override
    public void handleRelease6Key() {

    }

    @Override
    public void handleRelease7Key() {

    }

    @Override
    public void handleRelease8Key() {

    }

    @Override
    public void handleRelease9Key() {

    }

    @Override
    public void handleRelease5Key() {

    }
}
