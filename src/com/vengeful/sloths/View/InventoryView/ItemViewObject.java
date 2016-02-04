package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Utility.Config;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 2/3/2016.
 */
public abstract class ItemViewObject extends JComponent {

    protected Image itemImage;
    private static final int IMAGE_HEIGHT = Config.instance().INVENTORY_IMAGE_HEIGHT; //increment the y positions by height + 2
    private static final int IMAGE_WIDTH = Config.instance().INVENTORY_IMAGE_WIDTH;
    public static final int HORIZONTAL_OFFSET = IMAGE_WIDTH + 100;
    public static final double HORIZONTAL_OFFSET_PROPORTION = 0.50;

    public double horizontalOffset; //might not need, but it's down at the bottom in the paintComponent

    protected String itemName;
    public String imageFileName;
    private InventoryItem item;


    public String getItemName() {
        return itemName;
    }

    public ItemViewObject(InventoryItem item) { //this will be the actual method signature. it takes in item and x,y for drawing position

        this.itemName = item.getItemName(); //get the name directly from the connected item object
        imageFileName = generateImageFileName(itemName);
        ImageIcon itemIcon = new ImageIcon(imageFileName);
        itemImage = itemIcon.getImage();

    }


    public String generateImageFileName(String itemName) {
        imageFileName = "resources/"+itemName+".jpg";
        return imageFileName;
    }


    public void paintComponent(Graphics2D g, int x, int y) {
        //g.drawImage(itemImage, x,y, this);
        g.drawImage(itemImage,x,y, IMAGE_WIDTH, IMAGE_HEIGHT,this);
        g.drawString(itemName, x+ HORIZONTAL_OFFSET, y + IMAGE_HEIGHT); //want to draw the item image and then its name on the same line. Drawing of name is offset by the width of the image.

    }


    public void paintComponent(Graphics2D g, int x, int y, int viewWidth, int viewHeight) {
        horizontalOffset = (HORIZONTAL_OFFSET_PROPORTION * viewWidth) - itemName.length();
        g.drawImage(itemImage,x,y, IMAGE_WIDTH, IMAGE_HEIGHT,this);
        g.drawString(itemName, x+ (int) horizontalOffset, y + IMAGE_HEIGHT); //want to draw the item image and then its name on the same line. Drawing of name is offset by the width of the image.
    }



}
