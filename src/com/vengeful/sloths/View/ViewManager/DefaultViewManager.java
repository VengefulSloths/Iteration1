package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.View.AreaView.AreaView;
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
    private static final int VIEW_WIDTH = 1100;
    private static final int VIEW_HEIGHT = 800;

    private static final double AREA_VIEW_WIDTH_PROPORTION = 0.75;
    private static final double AREA_VIEW_HEIGHT_PROPORTION = 1.0;
    private static final double SIDE_PANEL_WIDTH_PROPORTION = 1.0 - AREA_VIEW_WIDTH_PROPORTION;
    private static final double SIDE_PANEL_HEIGHT_PROPORTION = 1.0;
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

    /* View getters and setters */
    public AreaView getAreaView() {
        return areaView;
    }
    public void setAreaView(AreaView areaView) {
        this.areaView = areaView;
    }
    public ListInventoryView getInventoryView() {
        return inventoryView;
    }
    public void setInventoryView(ListInventoryView inventoryView) {
        this.inventoryView = inventoryView;
    }

    public DefaultViewManager() {


        /* Create all of the segments of the overall view */
        //backgroundPanel = new JPanel(new BorderLayout());
        sidePanel = new JPanel();
        areaView = new AreaView();
        inventoryView = new ListInventoryView();

        inventoryView.setViewWidth(INVENTORY_VIEW_WIDTH);
        inventoryView.setViewHeight(INVENTORY_VIEW_HEIGHT);

        this.setPreferredSize(new Dimension(VIEW_WIDTH, VIEW_HEIGHT));
        sidePanel.setPreferredSize(new Dimension(SIDE_PANEL_WIDTH, SIDE_PANEL_HEIGHT));
        areaView.setPreferredSize(new Dimension(AREA_VIEW_WIDTH, AREA_VIEW_HEIGHT));
        inventoryView.setPreferredSize(new Dimension(INVENTORY_VIEW_WIDTH, INVENTORY_VIEW_HEIGHT)); //now handled in ListInventoryView

        this.setBackground(Color.BLACK);
        sidePanel.setBackground(Color.BLUE);
        areaView.setBackground(Color.WHITE);
        inventoryView.setBackground(Color.RED);

        setLayout(new BorderLayout()); //set the layout of the DefaultViewManager to BorderLayout
        sidePanel.setLayout(new BorderLayout()); //set the layout of the sidePanel to BorderLayout
        //inventoryView.setLayout(new BorderLayout());//set layout of inventoryView....maybe this isn't appropriate in this class?

        sidePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 7));


        //sidePanel.add(inventoryView, BorderLayout.CENTER); //eventually, will add StatsView and HUDView to sidePanel
        sidePanel.add(inventoryView, BorderLayout.SOUTH);
        add(areaView, BorderLayout.WEST);
        add(sidePanel, BorderLayout.EAST);


    }
}