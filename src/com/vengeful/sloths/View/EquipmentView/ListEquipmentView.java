package com.vengeful.sloths.View.EquipmentView;

import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.InventoryView.ItemViewObject;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by luluding on 2/5/16.
 */
public class ListEquipmentView extends EquipmentView{

    public ListEquipmentViewObjectManager manager;

    public static final String title = "Equipment";
    public static final String backgroundImageFileName = "resources/inventoryBackground.jpg";


    public ListEquipmentView(Equipped equipped) {

        super(equipped);

        this.setBackgroundImageFileName(backgroundImageFileName);
        generateTitle(title);

        //this.setPreferredSize(new Dimension(viewWidth, viewHeight));
        manager = new ListEquipmentViewObjectManager();
        manager.initWithEquipped(equipped);
    }

    public ListEquipmentView(Equipped equipped, int width, int height) {

        super(equipped, width, height);

        this.setBackgroundImageFileName("resources/inventoryBackground.jpg");
        generateTitle(title);

        this.setViewWidth(width);
        this.setViewHeight(height);

        //this.setPreferredSize(new Dimension(viewWidth, viewHeight));
        manager = new ListEquipmentViewObjectManager();
        manager.initWithEquipped(equipped);
    }


    public void generateBackground() {
        //put the generate background in a method (below)
        setBackground(Color.ORANGE);
    }

    ///*
    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ?
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Iterator<ItemViewObject> iter = manager.iterator();
        offset = Config.instance().INVENTORY_IMAGE_HEIGHT + this.titleLabel.getHeight(); //going to need to find a better way to get an offset
        while (iter.hasNext()) {
            EquipmentViewObject current = (EquipmentViewObject)iter.next();
            if(current.isSelected) {
                Border b = BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.ORANGE, Color.ORANGE);
                b.paintBorder(current, g2d, 0, offset, viewWidth, Config.instance().INVENTORY_IMAGE_HEIGHT);
                //current.paintComponent(g2d, 20, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
                current.paintComponent(g2d, (viewWidth/4) - Config.instance().INVENTORY_IMAGE_WIDTH - (viewWidth/12), offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class

            } else {
                //current.paintComponent(g2d, 20, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
                current.paintComponent(g2d, (viewWidth/4) - Config.instance().INVENTORY_IMAGE_WIDTH - (viewWidth/12), offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class

            }
            offset = offset + Config.instance().INVENTORY_IMAGE_HEIGHT + 2;
        }
        Toolkit.getDefaultToolkit().sync(); //purpose?

    }


    @Override
    public void alertItemEquipped(EquippableItems item) {
        if (item instanceof Hat) {
            manager.addEquipmentViewObject(new EquipmentViewObject(item));
        } else if (item instanceof Sword) {
            manager.addEquipmentViewObject(new EquipmentViewObject(item));
        }
    }

    @Override
    public void alertItemUnequipped(EquippableItems item) {
        manager.removeEquipmentViewObject(item);
    }


    public void setSelected(EquipmentViewObject item){
        //give a border
        item.isSelected = true;

    }

    public void setDeselected(EquipmentViewObject item){
        //give a border
        item.isSelected = false;

    }


}
