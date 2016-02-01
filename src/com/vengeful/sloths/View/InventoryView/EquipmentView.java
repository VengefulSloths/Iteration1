package com.vengeful.sloths.View.InventoryView;

/**
 * Created by echristiansen on 2/1/2016.
 */

    public class EquipmentView extends InventoryView {

        public EquipmentViewObjectManager manager;
        public InventoryItemViewObject headGear;
        public InventoryItemViewObject bodyGear;
        public InventoryItemViewObject legGear;
        public InventoryItemViewObject weapon;

    public enum Slots {
        HEAD, BODY, LEGS, FEET, WEAPON
    }

        public InventoryItemViewObject getHeadGear() {
            return headGear;
        }

        public void setHeadGear(InventoryItemViewObject headGear) {
            this.headGear = headGear;
        }

        public InventoryItemViewObject getBodyGear() {
            return bodyGear;
        }

        public void setBodyGear(InventoryItemViewObject bodyGear) {
            this.bodyGear = bodyGear;
        }

        public InventoryItemViewObject getLegGear() {
            return legGear;
        }

        public void setLegGear(InventoryItemViewObject legGear) {
            this.legGear = legGear;
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
    }


