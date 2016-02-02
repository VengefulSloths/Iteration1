package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class InventoryItemViewObject extends JComponent{
    //protected int x; //x coordinate where the object will be drawn
   // protected int y; //y coordinate where the object will be drawn
    private Image itemImage;
    public static final int IMAGE_HEIGHT = 18; //increment the y positions by height + 2
    public static final int IMAGE_WIDTH = 18;
    public static final int HORIZONTAL_OFFSET = IMAGE_WIDTH + 100;
    public static final double HORIZONTAL_OFFSET_PROPORTION = 0.50;

    public double horizontalOffset; //might not need, but it's down at the bottom in the paintComponent
    //public static final int HORIZONTAL_OFFSET = IMAGE_WIDTH + 0.75* InventoryViewWidth - IMAGE_WIDTH - ; really want the offset to be  percentage of the overall width
    //like
    private String itemName;
    public String imageFileName;
    public JPanel itemPanel;

    private EquippableItems item; //the connected Item object. For this iteration, all items are equippable

    public String getItemName() {
        return itemName;
    }


    //public InventoryItemViewObject(String itemName) {
    public InventoryItemViewObject(EquippableItems item) { //this will be the actual method signature. it takes in item and x,y for drawing position

        //itemPanel = new JPanel();

        this.itemName = item.getItemName(); //get the name directly from the connected item object
        //imageFileName = generateImageFileName(item); //this will be used to generate the imageFileName from the item itself
        imageFileName = generateImageFileName(itemName);
        ImageIcon itemIcon = new ImageIcon(imageFileName);
        itemImage = itemIcon.getImage();

        ///itemPanel.setLayout(new BorderLayout());
        //itemPanel.add(itemIcon, BorderLayout.WEST);

    }

    public String generateImageFileName(String itemName) {
    //public String generateImageFileName(Item item) { //this will be the proper method signature once item is in place
        //itemName = item.getItemName(); //this will get the String itemName used to grab the file, from the item itself
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
