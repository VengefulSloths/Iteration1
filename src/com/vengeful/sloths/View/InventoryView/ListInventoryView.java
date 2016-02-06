package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.Observers.InventoryObserver;
import com.vengeful.sloths.View.Observers.ProxyInventoryObserver;

import com.vengeful.sloths.View.Observers.InventoryObserver;
import com.vengeful.sloths.View.Observers.ProxyInventoryObserver;
import com.vengeful.sloths.View.Observers.ProxyObserver;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryView extends InventoryView {

    public ListInventoryViewObjectManager manager;

    /*EDIT: for testing purposes. */
    InventoryItemViewObject GodSwordItemViewObject;
    InventoryItemViewObject PartyHatItemViewObject;

    //InventoryItemViewObject testItem2 = new InventoryItemViewObject(new Sword("GodSword"));
    //InventoryItemViewObject testItem = new InventoryItemViewObject(new Hat("Blue Partyhat"));

    public static final String title = "Inventory";
    public static final String backgroundImageFileName = "resources/inventoryBackground.jpg";


    public ListInventoryView(Inventory inventory) {

        // pass in Inventory
        // pass in self
        this.setBackgroundImageFileName(backgroundImageFileName);
        generateTitle(title);
        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyObserver pio = new ProxyInventoryObserver(this, inventory);
        ObserverManager.instance().addProxyObserver(pio);

        //this.setPreferredSize(new Dimension(viewWidth, viewHeight));
        manager = new ListInventoryViewObjectManager();
        manager.initWithInventory(inventory);


        /* edit the next two lines/maybe delete them */

    }

    public ListInventoryView(Inventory inventory, int width, int height) {

        // pass in Inventory
        // pass in self
        this.setBackgroundImageFileName("resources/inventoryBackground.jpg");
        generateTitle(title);

        this.setViewWidth(width);
        this.setViewHeight(height);
               //Create a proxy for the observer, register the proxy w/ entity, add proxy to manager
        ProxyObserver pio = new ProxyInventoryObserver(this, inventory);
        ObserverManager.instance().addProxyObserver(pio);

        //this.setPreferredSize(new Dimension(viewWidth, viewHeight));
        manager = new ListInventoryViewObjectManager();
        manager.initWithInventory(inventory);


        /* edit the next two lines/maybe delete them */

    }


    public void generateBackground() {
        //put the generate background in a method (below)
      setBackground(Color.ORANGE);
    }

    ///*
    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ?
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Iterator<ItemViewObject> iter = manager.iterator();
        offset = Config.instance().INVENTORY_IMAGE_HEIGHT + this.titleLabel.getHeight(); //going to need to find a better way to get an offset
        while (iter.hasNext()) {
            InventoryItemViewObject current = (InventoryItemViewObject)iter.next();
            if(current.isSelected) {
                Border b = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.ORANGE);
                b.paintBorder(current, g2d, 0, offset, viewWidth, Config.instance().INVENTORY_IMAGE_HEIGHT);
                //current.paintComponent(g2d, 20, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
                current.paintComponent(g2d, (viewWidth/4) - Config.instance().INVENTORY_IMAGE_WIDTH - (viewWidth/12), offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class

            } else {
                //current.paintComponent(g2d, 20, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
                current.paintComponent(g2d, (viewWidth/4) - Config.instance().INVENTORY_IMAGE_WIDTH - (viewWidth/12), offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class

            }
            offset = offset + Config.instance().INVENTORY_IMAGE_HEIGHT + 2;
        }
        Toolkit.getDefaultToolkit().sync(); //purpose?

    }
//*/

    //@Override
    public void alertItemAdded(InventoryItem item) {

        if (item instanceof Hat) {
            PartyHatItemViewObject = new InventoryItemViewObject(item);
            manager.addInventoryItemViewObject(PartyHatItemViewObject);
            //???Can't we just do..
            //manager.addInventoryItemViewObject(new InventoryItemViewObject(item));
        } else if (item instanceof Sword) {
            GodSwordItemViewObject = new InventoryItemViewObject(item);
            manager.addInventoryItemViewObject(GodSwordItemViewObject);
        }
    }

    //@Override
    public void alertItemDropped(InventoryItem item) {
        //System.out.println("LISTINVENTORYVIEW!!!!");
        //System.out.println("Item: " + item.getItemName() + " DROPPED!");
        manager.removeInventoryItemViewObject(item);
    }

    public void setSelected(InventoryItemViewObject item){
        //give a border
        item.isSelected = true;

    }

    public void setDeselected(InventoryItemViewObject item){
        //give a border
        item.isSelected = false;

    }



}
