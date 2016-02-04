package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.InventoryView.EquipmentView;
import com.vengeful.sloths.View.InventoryView.InventoryView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */

public class DefaultViewManager extends ViewManager {

    public DefaultViewManager(AreaView areaView, ListInventoryView inventoryView, EquipmentView equipmentView) {

        //backgroundPanel = new JPanel(new BorderLayout());
        /* Initialize the views in the ViewManager */
        sidePanel = new JPanel();
        this.areaView = areaView;
        this.inventoryView = inventoryView;
        this.equipmentView = equipmentView;

        /*Set the viewWidths and viewHeights. Doesn't actually change them visually, this is really
         * just for the render methods held in the view classes (determining offsets, etc. */
        this.inventoryView.setViewWidth(INVENTORY_VIEW_WIDTH);
        this.inventoryView.setViewHeight(INVENTORY_VIEW_HEIGHT);
        this.equipmentView.setViewWidth(EQUIPMENT_VIEW_WIDTH);
        this.equipmentView.setViewHeight(EQUIPMENT_VIEW_HEIGHT);

        /* Set the visual size of the views */
        this.setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        this.sidePanel.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, SIDE_PANEL_HEIGHT));
        this.areaView.setPreferredSize(new Dimension(AREA_VIEW_WIDTH, AREA_VIEW_HEIGHT));
        this.inventoryView.setPreferredSize(new Dimension(INVENTORY_VIEW_WIDTH, INVENTORY_VIEW_HEIGHT)); //now handled in ListInventoryView
        this.equipmentView.setPreferredSize(new Dimension(EQUIPMENT_VIEW_WIDTH, EQUIPMENT_VIEW_HEIGHT));

        /* Set the background colors of the views */
        this.setBackground(Color.BLACK);
        //this.sidePanel.setBackground(new Color(0,0,255,155));
        this.sidePanel.setBackground(new Color(255, 0, 0, 155));
        this.areaView.setBackground(Color.BLACK);
        this.inventoryView.setBackground( new Color(0, 0, 255, 155) );
        this.equipmentView.setBackground(Color.CYAN);

        /* Set the layouts of the ViewManager and the sidePanel */
        this.setLayout(new BorderLayout()); //set the layout of the DefaultViewManager to BorderLayout
        //this.sidePanel.setLayout(new BorderLayout()); //set the layout of the sidePanel to BorderLayout
        this.sidePanel.setLayout(new GridLayout(3,1));

        /* Add views to the sidePanel */
        //this.sidePanel.add(equipmentView, BorderLayout.NORTH); //edit
        //this.sidePanel.add(inventoryView, BorderLayout.SOUTH);
        this.sidePanel.add(equipmentView);
        this.sidePanel.add(inventoryView);

        /* Visually add the areaView and sidePanel to the ViewManager */
        this.add(areaView, BorderLayout.WEST);
        this.add(sidePanel, BorderLayout.EAST);

    }

    /* Get the inventoryView in this ViewManager. The attribute is in the superclass definition */
    public InventoryView getInventoryView() {
        return this.inventoryView;
    }

    private void resetBorders(){
        this.inventoryView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        this.areaView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        this.equipmentView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
    }

    public void selectInventoryView(){
        resetBorders();
        this.inventoryView.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.ORANGE));
    }
    public void selectAreaView(){
        resetBorders();
        this.areaView.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.ORANGE));
    }
    public void selectEquipView(){
        resetBorders();
        this.equipmentView.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.ORANGE));
    }

}