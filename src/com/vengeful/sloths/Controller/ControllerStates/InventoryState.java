package com.vengeful.sloths.Controller.ControllerStates;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.View.InventoryView.InventoryView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;

/**
 * Created by John on 1/30/2016.
 */
public class InventoryState extends MainControllerState {
    private InventoryView inventoryView;

    private int inventoryIndex;

    public InventoryState(MainController m){
        super(m);
        this.inventoryIndex = 0;
        this.inventoryView = m.getDefaultViewManager().getInventoryView();
    }



    public int getInventoryIndex() {
        return this.inventoryIndex;
    }

    public void setInventoryIndex(int index) {
        this.inventoryIndex = index;
    }

    @Override
    public boolean handleIKey() {
        mainController.setAvatarState();
        return true;
    }

    @Override
    public boolean handleEKey() {
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
        
        // Move down an item

        int itemListSize = ((ListInventoryView) this.inventoryView).manager.getItemListSize();

        this.inventoryIndex++;

        System.out.println("At index: " + this.inventoryIndex + " now");
        if (this.inventoryIndex >= itemListSize) {
            this.inventoryIndex = itemListSize - 1;
            return false;
        }



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


        int itemListSize = ((ListInventoryView) this.inventoryView).manager.getItemListSize();

        this.inventoryIndex--;

        if (this.inventoryIndex <= 0) {
            this.inventoryIndex = 0;
            return false;
        }

        System.out.println("At index: " + this.inventoryIndex + " now");

        return true;
    }

    @Override
    public boolean handle9Key() {
        return false;
    }

    @Override
    public boolean handle5Key() {
        //return false;

        return true;
    }

    @Override
    public boolean handleDKey() {

        InventoryItem i = ((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex--).getInventoryItem();


        System.out.println("DROPPING " + i.getItemName());

        mainController.getAvatar().drop(i);

        if (this.inventoryIndex <= 0) this.inventoryIndex = 0;

        return true;

    }

    public String toString() {
         return "InventoryState";
    }

    public void handleRelease1Key(){
        mainController.getAvatar().setMoving(false);
    }
    public void handleRelease2Key(){}
    public void handleRelease3Key(){}
    public void handleRelease4Key(){}
    public void handleRelease6Key(){}
    public void handleRelease7Key(){}
    public void handleRelease8Key(){}
    public void handleRelease9Key(){}
    public void handleRelease5Key(){}
}
