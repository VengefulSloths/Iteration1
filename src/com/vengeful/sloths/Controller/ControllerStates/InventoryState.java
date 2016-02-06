package com.vengeful.sloths.Controller.ControllerStates;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
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

    public InventoryView getInventoryView(){
        return this.inventoryView;
    }

    @Override
    public boolean handleIKey() {
        if(((ListInventoryView) this.inventoryView).manager.getItemListSize() > 0) {
            ((ListInventoryView) this.inventoryView).setDeselected(((ListInventoryView) this.inventoryView).manager.getFromItemList(this.inventoryIndex));
        }
        mainController.setAvatarState();
        return true;
    }

    @Override
    public boolean handleEKey() {

        int itemListSize = ((ListInventoryView) this.inventoryView).manager.getItemListSize();

        System.out.println("Index before equipped: " + this.inventoryIndex);
        System.out.println("Item Size In View before equipping: " + itemListSize);


        //Need to talk to view to get the item to equip


        //Testing purpose
        InventoryItem item = mainController.getAvatar().getInventory().getItem(inventoryIndex);

        //Deselect current item (item to be equipped)
        ((ListInventoryView)this.inventoryView).setDeselected(((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex));

        //Do nothing if item is not equippable item
        if(item instanceof EquippableItems){
            mainController.getAvatar().equip(item);
        }

        if(itemListSize == 0)
            this.inventoryIndex = 0;
        else if(this.inventoryIndex == 0)
            ((ListInventoryView)this.inventoryView).setSelected(((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex));
        else{
            System.out.println("Index after equipped: " + this.inventoryIndex);
            System.out.println("Item Size In View: " + itemListSize);
            this.inventoryIndex--;
            ((ListInventoryView)this.inventoryView).setSelected(((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex));
        }
        //TODO: do the same to drop?


        itemListSize = ((ListInventoryView) this.inventoryView).manager.getItemListSize();

        System.out.println("Index after equipped: " + this.inventoryIndex);
        System.out.println("Item Size In View after equipping: " + itemListSize);

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

        System.out.println(itemListSize + " size");
        this.inventoryIndex++;


        if (this.inventoryIndex >= itemListSize) {
            this.inventoryIndex = itemListSize - 1;
            return false;
        }
        System.out.println("At index: " + this.inventoryIndex + " now");

        ((ListInventoryView)this.inventoryView).setSelected(((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex));
        if (this.inventoryIndex > 0)
            ((ListInventoryView)this.inventoryView).setDeselected(((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex-1));

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

        if (this.inventoryIndex < 0) {
            this.inventoryIndex = 0;
            return false;
        }
        ((ListInventoryView)this.inventoryView).setSelected(((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex));
        if (this.inventoryIndex < itemListSize)
            ((ListInventoryView)this.inventoryView).setDeselected(((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex + 1));
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


        InventoryItem i = null;
        int itemListSize = ((ListInventoryView) this.inventoryView).manager.getItemListSize();
        try {
             i = ((ListInventoryView) this.inventoryView).manager.getFromItemList(this.inventoryIndex).getInventoryItem();
        }catch(NullPointerException e){
            //do nothing
        }



        if(i != null) {

            System.out.println("DROPPING " + i.getItemName());
            mainController.getAvatar().drop(i);



        if (this.inventoryIndex <= 0) this.inventoryIndex = 0;

        if(itemListSize > 1){
            if (inventoryIndex != 0) {
                ((ListInventoryView) this.inventoryView).setSelected(((ListInventoryView) this.inventoryView).manager.getFromItemList(--this.inventoryIndex));
            }else{
                ((ListInventoryView) this.inventoryView).setSelected(((ListInventoryView) this.inventoryView).manager.getFromItemList(this.inventoryIndex+1));

            }
        }
        //System.out.println("should be changing selected to: " + (((ListInventoryView)this.inventoryView).manager.getFromItemList(this.inventoryIndex).getInventoryItem().getItemName()));
        }
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
