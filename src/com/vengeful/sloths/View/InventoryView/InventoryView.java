package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.Observers.InventoryObserver;
import com.vengeful.sloths.View.Observers.ProxyInventoryObserver;
import com.vengeful.sloths.View.View;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 1/30/2016.
 */
public abstract class InventoryView extends View implements InventoryObserver{

    String defaultInventoryBackground = "resources/inventoryBackground.jpg";


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

    public InventoryView(Inventory inventory, int width, int height) {
        // pass in Inventory
        // pass in self

        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyInventoryObserver pio = new ProxyInventoryObserver(this, inventory);
        ObserverManager.instance().addProxyObserver(pio);

        //manager = new ViewObjectManager();

    }

    public abstract void setSelected(InventoryItemViewObject item);
    public abstract void setDeselected(InventoryItemViewObject item);
}
