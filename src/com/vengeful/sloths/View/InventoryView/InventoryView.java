package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.Observers.InventoryObserver;
import com.vengeful.sloths.View.Observers.ProxyInventoryObserver;
import com.vengeful.sloths.View.View;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public abstract class InventoryView extends View implements InventoryObserver{

public InventoryView() {
//manager = new ViewObjectManager();

}

    public InventoryView(Inventory inventory) {
        // pass in Inventory
        // pass in self

        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyInventoryObserver pio = new ProxyInventoryObserver(this, inventory);
        ObserverManager.instance().addProxyObserver(pio);

        //manager = new ViewObjectManager();

    }

    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ?

        /*
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        Iterator<ItemViewObject> iter = manager.iterator();

        offset = Config.instance().INVENTORY_IMAGE_HEIGHT; //going to need to find a better way to get an offset

        //System.out.println("PAINTCOMPONENT IS GETTING CALLED!!!!" + iter.next().getItemName());


        while (iter.hasNext()) {
            System.out.println("ITERATING THROUGH SOME ITEMS!!!!!!!!"); //EDIT
            ItemViewObject current = iter.next();
            current.paintComponent(g2d, 0, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
            //offset = offset + current.IMAGE_HEIGHT + 2;
            offset = offset + Config.instance().INVENTORY_IMAGE_HEIGHT + 2;
        }

        Toolkit.getDefaultToolkit().sync(); //purpose?
        */
    }

    public abstract void setSelected(InventoryItemViewObject item);
    public abstract void setDeselected(InventoryItemViewObject item);
}
