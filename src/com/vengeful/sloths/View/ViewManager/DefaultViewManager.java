package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.InventoryView.EquipmentView;
import com.vengeful.sloths.View.InventoryView.InventoryView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.Sound.SoundEffect;
import com.vengeful.sloths.View.StatsView.StatsView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */

public class DefaultViewManager extends ViewManager {

    public DefaultViewManager(AreaView areaView, ListInventoryView inventoryView, EquipmentView equipmentView, StatsView statsView) {
        
        //backgroundPanel = new JPanel(new BorderLayout());

        /* Initialize the views in the ViewManager */
        sidePanel = new JPanel();
        this.areaView = areaView;
        this.inventoryView = inventoryView;
        this.equipmentView = equipmentView;
        this.statsView = statsView;

        /*Set the viewWidths and viewHeights. Doesn't actually change them visually, this is really
         * just for the render methods held in the view classes (determining offsets, etc. */
        this.inventoryView.setViewWidth(INVENTORY_VIEW_WIDTH);
        this.inventoryView.setViewHeight(INVENTORY_VIEW_HEIGHT);
        this.equipmentView.setViewWidth(EQUIPMENT_VIEW_WIDTH);
        this.equipmentView.setViewHeight(EQUIPMENT_VIEW_HEIGHT);
        this.statsView.setViewWidth(STATS_VIEW_WIDTH);
        this.statsView.setViewHeight(STATS_VIEW_HEIGHT);

        /* Set the visual size of the views */
        this.setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        this.sidePanel.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, SIDE_PANEL_HEIGHT));
        this.areaView.setPreferredSize(new Dimension(AREA_VIEW_WIDTH, AREA_VIEW_HEIGHT));
        this.inventoryView.setPreferredSize(new Dimension(INVENTORY_VIEW_WIDTH, INVENTORY_VIEW_HEIGHT)); //now handled in ListInventoryView
        this.equipmentView.setPreferredSize(new Dimension(EQUIPMENT_VIEW_WIDTH, EQUIPMENT_VIEW_HEIGHT));
        this.statsView.setPreferredSize(new Dimension(STATS_VIEW_WIDTH,STATS_VIEW_HEIGHT));

        /* Set the background colors of the views */
        this.setBackground(Color.BLACK);
        //this.sidePanel.setBackground(new Color(0,0,255,155));
        this.sidePanel.setBackground(Color.BLACK);
        this.areaView.setBackground(Color.BLACK);
        //this.inventoryView.setBackground(Color.RED );
        //this.equipmentView.setBackground(Color.CYAN);
        //this.statsView.setBackground(Color.GREEN);

        /* Set the layouts of the ViewManager */
        this.setLayout(new BorderLayout()); //set the layout of the DefaultViewManager to BorderLayout
        this.sidePanel.setLayout(new FlowLayout(0,0,3)); //not totally necessary - the default is fine. But this allows to specify 0 gap

        /* Add views to the sidePanel */
        this.sidePanel.add(statsView);
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
        this.sidePanel.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        this.inventoryView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        this.areaView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        this.equipmentView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        this.statsView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
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