package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 2/1/2016.
 */

    public class EquipmentView extends InventoryView {

    public static final String title = "Equipment";
    public static final String backgroundImageFileName = "resources/inventoryBackground2.jpg";

    public EquipmentViewObjectManager manager;
        public InventoryItemViewObject headGear;
        public InventoryItemViewObject weapon;


    @Override
    public void setSelected(InventoryItemViewObject item) {

    }
    @Override
    public void setDeselected(InventoryItemViewObject item) {

    }

    public InventoryItemViewObject getHeadGear() {
            return headGear;
        }


    public EquipmentView(){

        generateTitle(title);
        this.setBackgroundImageFileName(backgroundImageFileName);
        manager = new EquipmentViewObjectManager();

        }

    @Override
    public void alertItemAdded(InventoryItem item) {
        if (!(item instanceof EquippableItems)) {
            System.out.println("Cannot wield item");
            return;
        }
    }

    @Override
    public void alertItemDropped(InventoryItem item) {
        if(!(item instanceof EquippableItems)) {
            System.out.println("Why am I printing? Should not be able to unwield unequippable");
            return;
        }

    }


    public void generateBackground() {
        setBackground(Color.ORANGE);
    }



/*
    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ?
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Iterator<InventoryItemViewObject> iter = manager.iterator();
        //offset = iter.next().IMAGE_HEIGHT; //this causes a problem because it skips the first one in the iterator
        offset = testItem.IMAGE_HEIGHT; //going to need to find a better way to get an offset

        while (iter.hasNext()) {
            InventoryItemViewObject current = iter.next();
            current.paintComponent(g2d, 0, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
            offset = offset + current.IMAGE_HEIGHT + 2;
        }

        Toolkit.getDefaultToolkit().sync(); //purpose?
    } */
    }


