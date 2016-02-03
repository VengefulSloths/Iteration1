package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.InventoryView.InventoryView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
//all together we have 6 JPanels: an overall background/holder, an areaview, a secondary view panel (containing StatsView, HUDView, InventoryView),
// and the three panels within the secondary view panel: (StatsVIEW, HUDView, InventoryView)
//note/edit: backgroundPanel might not be necessary: the DefaultViewManager overall is a JPanel, and therefore IS the backgroundPanel

public class DefaultViewManager extends ViewManager {

    //JPanel backgroundPanel; //might not be necessary - defaultViewManager is the backgroundPanel
    AreaView areaView;
    JPanel sidePanel; //edit: make private or protected or something because this shouldn't be set elsewhere? it's all contained in this class
    //HUDView hudview;
    //StatsView statsview;
    ListInventoryView inventoryView;
    //private static int VIEW_WIDTH = Config.instance().getAreaViewWidth();
   // private static int VIEW_HEIGHT = Config.instance().getAreaViewHeight();
    private static int VIEW_WIDTH = Config.instance().getWindowWidth();
    private static int VIEW_HEIGHT = Config.instance().getWindowHeight();

    private static final double SIDE_PANEL_WIDTH_PROPORTION = Config.instance().getSidePanelWidthProportion();
    private static final double SIDE_PANEL_HEIGHT_PROPORTION = Config.instance().getSidePanelHeightProportion();

    private static final double AREA_VIEW_WIDTH_PROPORTION = 1.0 - SIDE_PANEL_WIDTH_PROPORTION;
    private static final double AREA_VIEW_HEIGHT_PROPORTION = 1.0;

    //private static final double SIDE_PANEL_WIDTH_PROPORTION = 1.0 - AREA_VIEW_WIDTH_PROPORTION;
    //private static final double SIDE_PANEL_HEIGHT_PROPORTION = 1.0;
    private static final double INVENTORY_VIEW_WIDTH_PROPORTION = 1.0;
    private static final double INVENTORY_VIEW_HEIGHT_PROPORTION = 0.40; //edit: this will change when StatsView and HUDView are added
    //private static final double STATS_VIEW_HEIGHT_PROPORTION = .30;
    //private static final double HUD_VIEW_HEIGHT_PROPORTION = 1.0 - STATS_VIEW_HEIGHT_PROPORTION - INVENTORY_VIEW_HEIGHT_PROPORTION;


    private static final int AREA_VIEW_WIDTH =(int) (AREA_VIEW_WIDTH_PROPORTION * VIEW_WIDTH);
    private static final int AREA_VIEW_HEIGHT = (int) (AREA_VIEW_HEIGHT_PROPORTION * VIEW_HEIGHT);
    private static final int SIDE_PANEL_WIDTH = (int) (SIDE_PANEL_WIDTH_PROPORTION * VIEW_WIDTH);
    private static final int SIDE_PANEL_HEIGHT = (int) (SIDE_PANEL_HEIGHT_PROPORTION * VIEW_HEIGHT);
    private static final int INVENTORY_VIEW_WIDTH = (int) (INVENTORY_VIEW_WIDTH_PROPORTION * SIDE_PANEL_WIDTH); //relative to the
    private static final int INVENTORY_VIEW_HEIGHT = (int) (INVENTORY_VIEW_HEIGHT_PROPORTION * SIDE_PANEL_HEIGHT); //relative to

    //public DefaultViewManager() {
    public DefaultViewManager(AreaView areaView, ListInventoryView inventoryView) {

        /* Create all of the segments of the overall view */
        //backgroundPanel = new JPanel(new BorderLayout());
        sidePanel = new JPanel();
        this.areaView = areaView;
        this.inventoryView = inventoryView;




        this.inventoryView.setViewWidth(INVENTORY_VIEW_WIDTH);
        this.inventoryView.setViewHeight(INVENTORY_VIEW_HEIGHT);

        this.setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        this.sidePanel.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, SIDE_PANEL_HEIGHT));
        this.areaView.setPreferredSize(new Dimension(AREA_VIEW_WIDTH, AREA_VIEW_HEIGHT));
        this.inventoryView.setPreferredSize(new Dimension(INVENTORY_VIEW_WIDTH, INVENTORY_VIEW_HEIGHT)); //now handled in ListInventoryView

        /* //original color scheme
        this.setBackground(Color.BLACK);
        this.sidePanel.setBackground(Color.BLUE);
        this.areaView.setBackground(Color.BLACK);
        this.inventoryView.setBackground(Color.RED);
        */

        //color scheme with some opacity specifications
        this.setBackground(Color.BLACK);
        this.sidePanel.setBackground(new Color(0,0,255,155));
        this.areaView.setBackground(Color.BLACK);
        this.inventoryView.setBackground( new Color(255, 0, 0, 155) );


        this.setLayout(new BorderLayout()); //set the layout of the DefaultViewManager to BorderLayout
        this.sidePanel.setLayout(new BorderLayout()); //set the layout of the sidePanel to BorderLayout
        //inventoryView.setLayout(new BorderLayout());//set layout of inventoryView....maybe this isn't appropriate in this class?

        //this.sidePanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 7));
        this.sidePanel.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));


        //sidePanel.add(inventoryView, BorderLayout.CENTER); //eventually, will add StatsView and HUDView to sidePanel
        this.sidePanel.add(inventoryView, BorderLayout.SOUTH);
        this.add(areaView, BorderLayout.WEST);
        this.add(sidePanel, BorderLayout.EAST);


    }

    public InventoryView getInventoryView() {
        return this.inventoryView;
    }

    private void resetBorders(){
        this.inventoryView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
        this.areaView.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
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