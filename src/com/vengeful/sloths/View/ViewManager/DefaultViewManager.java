package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.EquipmentView.EquipmentView;
import com.vengeful.sloths.View.HUDView.HUDView;
import com.vengeful.sloths.View.InventoryView.InventoryView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.StatsView.StatsView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */

public class DefaultViewManager extends ViewManager {

    public DefaultViewManager(AreaView areaView, ListInventoryView inventoryView, EquipmentView equipmentView, StatsView statsView, HUDView hudView) {

        //backgroundPanel = new JPanel(new BorderLayout());

        /* Initialize the views in the ViewManager */
        mainPanel = new JPanel();
        sidePanel = new JPanel();
        this.areaView = areaView;
        this.inventoryView = inventoryView;
        this.equipmentView = equipmentView;
        this.statsView = statsView;
        this.hudView = hudView;

        /*Set the viewWidths and viewHeights. Doesn't actually change them visually, this is really
         * just for the render methods held in the view classes (determining offsets, etc. */
        this.inventoryView.setViewWidth(INVENTORY_VIEW_WIDTH);
        this.inventoryView.setViewHeight(INVENTORY_VIEW_HEIGHT);
        this.equipmentView.setViewWidth(EQUIPMENT_VIEW_WIDTH);
        this.equipmentView.setViewHeight(EQUIPMENT_VIEW_HEIGHT);
        this.statsView.setViewWidth(STATS_VIEW_WIDTH);
        this.statsView.setViewHeight(STATS_VIEW_HEIGHT);
        this.hudView.setViewWidth(HUD_VIEW_WIDTH);
        this.hudView.setViewHeight(HUD_VIEW_HEIGHT);


        /* Set the visual size of the views */
        this.setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        this.mainPanel.setPreferredSize(new Dimension(MAIN_PANEL_WIDTH, MAIN_PANEL_HEIGHT));
        this.sidePanel.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, SIDE_PANEL_HEIGHT));
        this.areaView.setPreferredSize(new Dimension(AREA_VIEW_WIDTH, AREA_VIEW_HEIGHT));
        this.inventoryView.setPreferredSize(new Dimension(INVENTORY_VIEW_WIDTH, INVENTORY_VIEW_HEIGHT)); //now handled in ListInventoryView
        this.equipmentView.setPreferredSize(new Dimension(EQUIPMENT_VIEW_WIDTH, EQUIPMENT_VIEW_HEIGHT));
        this.statsView.setPreferredSize(new Dimension(STATS_VIEW_WIDTH,STATS_VIEW_HEIGHT));
        this.hudView.setPreferredSize(new Dimension(HUD_VIEW_WIDTH, HUD_VIEW_HEIGHT));


        /* Set the background colors of the views */
        this.setBackground(Color.BLACK);
        this.sidePanel.setBackground(Color.BLACK);

        /* Set the layouts of the ViewManager */
        this.setLayout(new BorderLayout()); //set the layout of the DefaultViewManager to BorderLayout
        this.mainPanel.setLayout(new BorderLayout());
        this.sidePanel.setLayout(new FlowLayout(0,0,2)); //not totally necessary - the default is fine. But this allows to specify 0 gap

        /* Add views to the sidePanel */
        this.sidePanel.add(statsView);
        this.sidePanel.add(equipmentView);
        this.sidePanel.add(inventoryView);
        mainPanel.add(areaView, BorderLayout.CENTER);
        mainPanel.add(hudView, BorderLayout.SOUTH);
       // mainPanel.add(areaView);
        //mainPanel.add(hudView);


        /* Visually add the areaView and sidePanel to the ViewManager */
        this.add(mainPanel, BorderLayout.WEST);
        //this.add(areaView, BorderLayout.WEST);
        this.add(sidePanel, BorderLayout.EAST);
        //this.add(hudView, BorderLayout.SOUTH);
        //areaView.setLayout(new BorderLayout());
        //areaView.add(hudView, BorderLayout.SOUTH);

        this.setDoubleBuffered(true);
    }

    /* Get the inventoryView in this ViewManager. The attribute is in the superclass definition */
    public InventoryView getInventoryView() {
        return this.inventoryView;
    }

    public EquipmentView getEquipmentView(){
        return this.equipmentView;
    }


    private void resetBorders(){
        //this.sidePanel.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
        this.inventoryView.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
        this.areaView.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
        this.equipmentView.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
        this.statsView.setBorder(BorderFactory.createEtchedBorder(Color.BLACK, Color.BLACK));
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