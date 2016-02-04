package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Observers.InventoryObserver;
import com.vengeful.sloths.View.AreaView.Observers.ProxyInventoryObserver;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryView extends InventoryView {

    public ListInventoryViewObjectManager manager;

    /*EDIT: for testing purposes. */
    InventoryItemViewObject GodSwordItemViewObject = new InventoryItemViewObject(new Sword("GodSword"));
    InventoryItemViewObject PartyHatItemViewObject = new InventoryItemViewObject(new Hat("Blue Partyhat"));


    //InventoryItemViewObject testItem2 = new InventoryItemViewObject(new Sword("GodSword"));
    //InventoryItemViewObject testItem = new InventoryItemViewObject(new Hat("Blue Partyhat"));


    public ListInventoryView(Inventory inventory) {

        // pass in Inventory
        // pass in self

        setLayout(new BorderLayout());
        this.add(new JLabel("Inventory"), BorderLayout.NORTH);

        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyInventoryObserver pio = new ProxyInventoryObserver(this, inventory);
        ObserverManager.instance().addProxyObserver(pio);

        //this.setPreferredSize(new Dimension(viewWidth, viewHeight));
        manager = new ListInventoryViewObjectManager();
        manager.initWithInventory(inventory);

        /* edit the next two lines/maybe delete them */


//        manager.addInventoryItemViewObject(testItem2);
//        manager.addInventoryItemViewObject(testItem);



//        manager.addInventoryItemViewObject(testItem2);
//        manager.addInventoryItemViewObject(testItem);
//        manager.addInventoryItemViewObject(testItem);
//        manager.addInventoryItemViewObject(testItem);
//        manager.addInventoryItemViewObject(testItem);
//        manager.addInventoryItemViewObject(testItem);
//        manager.addInventoryItemViewObject(testItem2);

    }

    ///*
    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ?
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Iterator<ItemViewObject> iter = manager.iterator();
        //offset = iter.next().IMAGE_HEIGHT; //this causes a problem because it skips the first one in the iterator
        offset = Config.instance().INVENTORY_IMAGE_HEIGHT; //going to need to find a better way to get an offset

        while (iter.hasNext()) {
            ItemViewObject current = iter.next();
            current.paintComponent(g2d, 0, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
            //offset = offset + current.IMAGE_HEIGHT + 2;
            offset = offset + Config.instance().INVENTORY_IMAGE_HEIGHT + 2;

        }

        Toolkit.getDefaultToolkit().sync(); //purpose?
    }
//*/

    //@Override
    public void alertItemAdded(InventoryItem item) {

        System.out.println("LISTINVENTORYVIEW!!!!");
        System.out.println("Item: " + item.getItemName() + " Added!");

        if (item instanceof Hat) {
            manager.addInventoryItemViewObject(PartyHatItemViewObject);
        } else if (item instanceof Sword) {
            manager.addInventoryItemViewObject(GodSwordItemViewObject);
        }
    }

    //@Override
    public void alertItemDropped(InventoryItem item) {
        System.out.println("LISTINVENTORYVIEW!!!!");
        System.out.println("Item: " + item.getItemName() + " DROPPED!");
    }


}
