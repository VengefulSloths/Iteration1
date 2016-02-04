package com.vengeful.sloths.View.InventoryView;

import java.awt.*;
import java.util.Iterator;

/**
 * Created by echristiansen on 2/1/2016.
 */

    public class EquipmentView extends InventoryView {

        public EquipmentViewObjectManager manager;
        public InventoryItemViewObject headGear;
        public InventoryItemViewObject weapon;

    public enum Slots {
        HEAD, BODY, LEGS, FEET, WEAPON
    }

    @Override
    public void setSelected(InventoryItemViewObject item) {

    }
    @Override
    public void setDeselected(InventoryItemViewObject item) {

    }

    public InventoryItemViewObject getHeadGear() {
            return headGear;
        }

        public void setHeadGear(InventoryItemViewObject headGear) {
            this.headGear = headGear;
        }

        public InventoryItemViewObject getWeapon() {
            return weapon;
        }

        public void setWeapon(InventoryItemViewObject weapon) {
            this.weapon = weapon;
        }

        public EquipmentView() {

            manager = new EquipmentViewObjectManager();

            manager.addEquipment(headGear);

        }


/*
    public void paintComponent(Graphics g) { //change to render(Graphics g, int x, int y) ?
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        Iterator<InventoryItemViewObject> iter = manager.iterator();
        //offset = iter.next().IMAGE_HEIGHT; //this causes a problem because it skips the first one in the iterator
        offset = testItem.IMAGE_HEIGHT; //going to need to find a better way to get an offset

        while (iter.hasNext()) {
            InventoryItemViewObject current = iter.next();
            current.paintComponent(g2d, 0, offset, viewWidth, viewHeight); //this paintComponent method is in the InventoryItemViewObject class
            offset = offset + current.IMAGE_HEIGHT + 2;
        }

        Toolkit.getDefaultToolkit().sync(); //purpose?
    } */
    }


