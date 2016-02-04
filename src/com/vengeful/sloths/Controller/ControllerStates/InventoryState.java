package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

/**
 * Created by John on 1/30/2016.
 */
public class InventoryState extends MainControllerState {
    private int inventoryIndex;

    public InventoryState(MainController m){
        super(m);
        this.inventoryIndex = 0;
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
        if (this.inventoryIndex == mainController.getInventory().getSize()) {
            return false;
        } else {
            this.inventoryIndex++;
            System.out.println("Retrieving item at index: " + this.inventoryIndex);
            InventoryItem i = mainController.getInventory().getItem(this.inventoryIndex);
            if (i != null)
                System.out.println("at index: " + (this.inventoryIndex) + ", " + i.getItemName() + " selected!");
            else
                System.out.println("I was null");
            return true;
        }
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



        if (this.inventoryIndex == 0) {
            return false;
        } else {
            this.inventoryIndex--;
            System.out.println("Retrieving item at index: " + this.inventoryIndex);
            InventoryItem i = mainController.getInventory().getItem(this.inventoryIndex);
            if (i != null)
                System.out.println("at index: " + (this.inventoryIndex) + ", " + i.getItemName() + " selected!");
            else
                System.out.println("I was null");
            return true;
        }
    }

    @Override
    public boolean handle9Key() {
        return false;
    }

    @Override
    public boolean handle5Key() {
        return false;
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
