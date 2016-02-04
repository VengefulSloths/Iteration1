package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.ObserverManager;
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
public class ListInventoryView extends InventoryView implements InventoryObserver {

    public ListInventoryViewObjectManager manager;

    //have width and height here?
    private int viewWidth;
    private int viewHeight;
    private int offset;

    public int getViewWidth() {
        return viewWidth;
    }
    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }
    public int getViewHeight() {
        return viewHeight;
    }
    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
        //System.out.println("SET THE VIEW HEIGHT. IT IS: " + viewHeight);
    }

    /*EDIT: for testing purposes. */
    InventoryItemViewObject GodSwordItemViewObject;
    InventoryItemViewObject PartyHatItemViewObject;

    public ListInventoryView(Inventory inventory) {

        // pass in Inventory
        // pass in self

        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyObserver pio = new ProxyInventoryObserver(this, inventory);
        ObserverManager.instance().addProxyObserver(pio);

        //this.setPreferredSize(new Dimension(viewWidth, viewHeight));
        manager = new ListInventoryViewObjectManager();
        manager.initWithInventory(inventory);

        /* edit the next two lines/maybe delete them */
        setLayout(new BorderLayout());
        this.add(new JLabel("Inventory"), BorderLayout.NORTH);


    }

    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ?
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Iterator<InventoryItemViewObject> iter = manager.iterator();
        //offset = iter.next().IMAGE_HEIGHT; //this causes a problem because it skips the first one in the iterator
        offset = GodSwordItemViewObject.IMAGE_HEIGHT; //going to need to find a better way to get an offset

        while (iter.hasNext()) {
            InventoryItemViewObject current = iter.next();
            if(current.isSelected) {
                //System.out.print("borderersrs");
//                current.setBorder();
                Border b = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.ORANGE);
                b.paintBorder(current, g2d, 0, offset, viewWidth, current.IMAGE_HEIGHT);

                current.paintComponent(g2d, 0, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class

            }else {
                current.paintComponent(g2d, 0, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
            }
            offset = offset + current.IMAGE_HEIGHT + 2;
        }

        Toolkit.getDefaultToolkit().sync(); //purpose?
    }



    @Override
    public void alertItemAdded(InventoryItem item) {

        if (item instanceof Hat) {
            PartyHatItemViewObject = new InventoryItemViewObject(item);
            manager.addInventoryItemViewObject(PartyHatItemViewObject);
        } else if (item instanceof Sword) {
            GodSwordItemViewObject = new InventoryItemViewObject(item);
            manager.addInventoryItemViewObject(GodSwordItemViewObject);
        }



    }

    @Override
    public void alertItemDropped(InventoryItem item) {
        System.out.println("LISTINVENTORYVIEW!!!!");
        System.out.println("Item: " + item.getItemName() + " DROPPED!");
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
