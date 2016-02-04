package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
//public class InventoryItemViewObject extends JComponent{
public class InventoryItemViewObject extends ItemViewObject{

    public boolean isSelected = false;

    public InventoryItemViewObject(InventoryItem item) { //this will be the actual method signature. it takes in item and x,y for drawing position
        super(item);
    }

}
