package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.InventoryView.EquipmentView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.View;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
//all together we have 6 JPanels: an overall background/holder, an areaview, a secondary view panel (containing StatsView, HUDView, InventoryView),
// and the three panels within the secondary view panel: (StatsVIEW, HUDView, InventoryView)
//note/edit: backgroundPanel might not be necessary: the DefaultViewManager overall is a JPanel, and therefore IS the backgroundPanel

public class DefaultViewManager extends ViewManager {

    //public DefaultViewManager() {
    public DefaultViewManager(AreaView areaView, ListInventoryView inventoryView, EquipmentView equipmentView) {

        //TODO we should change this paramters to ... and then assign each viw based on what class it is, or some other method

        /* Create all of the segments of the overall view */
        //backgroundPanel = new JPanel(new BorderLayout());
        sidePanel = new JPanel();
        this.areaView = areaView;
        this.inventoryView = inventoryView;
        this.equipmentView = equipmentView;

         //use setPreferredSize instead -- no, these are here to set the widths and heights that the drawing/paintComponent calculations are based on
        this.inventoryView.setViewWidth(INVENTORY_VIEW_WIDTH);
        this.inventoryView.setViewHeight(INVENTORY_VIEW_HEIGHT);
        this.equipmentView.setViewWidth(EQUIPMENT_VIEW_WIDTH);
        this.equipmentView.setViewHeight(EQUIPMENT_VIEW_HEIGHT);


        //inventoryViewDimension = new Dimension(this.inventoryView.getViewWidth(), this.inventoryView.getViewHeight());
        //equipmentViewDimension = new Dimension(this.equipmentView.getViewWidth(), this.equipmentView.getViewHeight());


        this.setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        this.sidePanel.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, SIDE_PANEL_HEIGHT));
        this.areaView.setPreferredSize(new Dimension(AREA_VIEW_WIDTH, AREA_VIEW_HEIGHT));
        this.inventoryView.setPreferredSize(new Dimension(INVENTORY_VIEW_WIDTH, INVENTORY_VIEW_HEIGHT)); //now handled in ListInventoryView
        this.equipmentView.setPreferredSize(new Dimension(EQUIPMENT_VIEW_WIDTH, EQUIPMENT_VIEW_HEIGHT));
        //this.inventoryView.setPreferredSize(inventoryViewDimension); //now handled in ListInventoryView
        //this.equipmentView.setPreferredSize(equipmentViewDimension);


        /* //original color scheme
        this.setBackground(Color.BLACK);
        this.sidePanel.setBackground(Color.BLUE);
        this.areaView.setBackground(Color.BLACK);
        this.inventoryView.setBackground(Color.RED);
        */

        //color scheme with some opacity specifications
        this.setBackground(Color.BLACK);
        //this.sidePanel.setBackground(new Color(0,0,255,155));
        this.sidePanel.setBackground(new Color(255, 0, 0, 155));
        this.areaView.setBackground(Color.BLACK);
        this.inventoryView.setBackground( new Color(0, 0, 255, 155) );
        this.equipmentView.setBackground(Color.CYAN);


        this.setLayout(new BorderLayout()); //set the layout of the DefaultViewManager to BorderLayout
        //this.sidePanel.setLayout(new BorderLayout()); //set the layout of the sidePanel to BorderLayout
        //this.sidePanel.setLayout(new GridLayout(3,1));
        inventoryView.setLayout(new BorderLayout());//set layout of inventoryView....maybe this isn't appropriate in this class?

        //this.sidePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 7));
        //this.sidePanel.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        resetBorders();

        //sidePanel.add(inventoryView, BorderLayout.CENTER); //eventually, will add StatsView and HUDView to sidePanel

        this.sidePanel.add(equipmentView, BorderLayout.NORTH); //edit
        this.sidePanel.add(inventoryView, BorderLayout.SOUTH);
        //this.sidePanel.add(equipmentView);
        //this.sidePanel.add(inventoryView);


        this.add(areaView, BorderLayout.WEST);
        this.add(sidePanel, BorderLayout.EAST);




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
        //this.inventoryView.setBorder(BorderFactory.createEtchedBorder(Color.ORANGE, Color.ORANGE));
    }

}