package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.View.InventoryView.InventoryView;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryView extends InventoryView {

    //private int VIEW_HEIGHT = 450;
    //private int VIEW_WIDTH = 450;
    public ListInventoryViewObjectManager manager;
    //private JTextArea inventoryTitle;

    //InventoryItemViewObject testItem = new InventoryItemViewObject("Blue Partyhat", 5, 5, "resources/bluePhat.jpg");
    InventoryItemViewObject testItem = new InventoryItemViewObject("GodSword", 5, 5);
    InventoryItemViewObject testItem2 = new InventoryItemViewObject("Blue Partyhat", 5, 25);

    public ListInventoryView() {

    //this.setLayout(new BorderLayout());
    //inventoryTitle = new JTextArea("Inventory");
    //this.add(inventoryTitle, BorderLayout.NORTH);


    manager = new ListInventoryViewObjectManager();

    //setBackground(Color.WHITE);
    //setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));

}

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        testItem.paintComponent(g2d);
        testItem2.paintComponent(g2d);

//        Iterator<InventoryItemViewObject> iter = manager.iterator();
//        while (iter.hasNext()) {
//            InventoryItemViewObject current = iter.next();
//            current.paintComponent(g2d);
//        }

        Toolkit.getDefaultToolkit().sync(); //purpose?
    }

}
