package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.View.InventoryView.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryView extends InventoryView {

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
    InventoryItemViewObject testItem = new InventoryItemViewObject(new Sword("GodSword"));
    InventoryItemViewObject testItem2 = new InventoryItemViewObject(new Hat("Blue Partyhat"));

    public ListInventoryView() {

    //this.setPreferredSize(new Dimension(viewWidth, viewHeight));
    manager = new ListInventoryViewObjectManager();

        /* edit the next two lines/maybe delete them */
        setLayout(new BorderLayout());
        this.add(new JLabel("Inventory"), BorderLayout.NORTH);

        manager.addInventoryItemViewObject(testItem2);
        manager.addInventoryItemViewObject(testItem);
        manager.addInventoryItemViewObject(testItem2);
        manager.addInventoryItemViewObject(testItem);
        manager.addInventoryItemViewObject(testItem);
        manager.addInventoryItemViewObject(testItem);
        manager.addInventoryItemViewObject(testItem);
        manager.addInventoryItemViewObject(testItem);
        manager.addInventoryItemViewObject(testItem2);

    }

    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ? WHERE IS THIS GETTING CALLED? Whenever a listInventoryView is created?
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
    }

}
