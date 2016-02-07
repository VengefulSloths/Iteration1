package com.vengeful.sloths.View.EquipmentView;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.View.InventoryView.ItemViewObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 2/1/2016.
 */
public class EquipmentViewObject extends ItemViewObject {

    public boolean isSelected = false;

    public EquipmentViewObject(EquippableItems equipment) {
        super(equipment);
    } //upward casting

}
