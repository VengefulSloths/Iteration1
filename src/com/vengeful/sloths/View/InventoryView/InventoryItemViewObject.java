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
    private final Image itemImage;

    public InventoryItemViewObject(int x, int y, String image) {
        this.x = x;
        this.y = y;

        ImageIcon itemIcon = new ImageIcon(image);
        itemImage = itemIcon.getImage();
    }

    public void paintComponent(Graphics2D g) {
        g.drawImage(itemImage, x,y, this);
    }
}
