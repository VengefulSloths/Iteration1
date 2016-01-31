package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.View.AreaView.ViewObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
public class InventoryItemViewObject extends JComponent{
    protected int x;
    protected int y;
    private Image itemImage;
    private final int imageHeight = 18; //increment the y positions by height + 2
    private final int imageWidth = 18;
    private final int horizontalOffset = imageWidth + 100;
    private String itemName;
    //private Item item; //the connected Item object

        //public InventoryItemViewObject(Item item, int x, int y, String image) { //this will be the constructor so can pass in actual items
        public InventoryItemViewObject(String itemName, int x, int y, String image) {
        this.x = x;
        this.y = y;
        //this.itemName = item.itemName; //get the name directly from the connected item object
        this.itemName = itemName; //this will be removed and replaced with the above line, to get the name directly from the connected Item object
        ImageIcon itemIcon = new ImageIcon(image);
        itemImage = itemIcon.getImage();
    }

    public InventoryItemViewObject(String itemName, int x, int y) {
        this.x = x;
        this.y = y;
        //this.itemName = item.itemName; //get the name directly from the connected item object
        this.itemName = itemName; //this will be removed and replaced with the above line, to get the name directly from the connected Item object
        ImageIcon itemIcon = new ImageIcon("resources/"+itemName+".jpg");
        itemImage = itemIcon.getImage();
    }


    public void paintComponent(Graphics2D g) {
        //g.drawImage(itemImage, x,y, this);
        g.drawImage(itemImage,x,y,imageWidth,imageHeight,this);
        g.drawString(itemName, x+horizontalOffset, y + imageHeight); //want to draw the item image and then its name on the same line. Drawing of name is offset by the width of the image.
    }
}
