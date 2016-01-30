package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.View.InventoryView.InventoryView;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class ListInventoryView extends InventoryView {

    private int VIEW_HEIGHT = 250;
    private int VIEW_WIDTH = 250;
    public ListInventoryViewObjectManager manager;


public ListInventoryView() {

    manager = new ListInventoryViewObjectManager();


}

    @Override
    int getAreaWidth() {
        return VIEW_WIDTH;
    }

    @Override
    int getAreaHeight() {
        return VIEW_HEIGHT;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Iterator<InventoryItemViewObject> iter = manager.iterator();
        while (iter.hasNext()) {
            InventoryItemViewObject current = iter.next();
            current.paintComponent(g2d);
        }
    }

}
