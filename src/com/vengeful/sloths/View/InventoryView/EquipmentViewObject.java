package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 2/1/2016.
 */
public class EquipmentViewObject extends ItemViewObject {

    public EquipmentViewObject(EquippableItems equipment) {
        super(equipment);
    }

    public void paintComponent(Graphics2D g, int x, int y, int viewWidth, int viewHeight) {
        horizontalOffset = (HORIZONTAL_OFFSET_PROPORTION * viewWidth) - itemName.length();
        g.drawImage(itemImage,x,y, IMAGE_WIDTH, IMAGE_HEIGHT,this);
        g.drawString(itemName, x+ (int) horizontalOffset, y + IMAGE_HEIGHT - 5); //want to draw the item image and then its name on the same line. Drawing of name is offset by the width of the image.
    }

}
