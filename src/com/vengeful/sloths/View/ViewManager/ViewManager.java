package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.InventoryView.EquipmentView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.StatsView.StatsView;
import com.vengeful.sloths.View.View;

import javax.swing.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
public abstract class ViewManager extends JPanel {

    //JPanel backgroundPanel; //might not be necessary - defaultViewManager is the backgroundPanel
    AreaView areaView;
    JPanel sidePanel; //edit: make private or protected or something because this shouldn't be set elsewhere? it's all contained in this class
    //HUDView hudview;
    StatsView statsView;
    ListInventoryView inventoryView;
    EquipmentView equipmentView;

    protected static int VIEW_WIDTH = Config.instance().getWindowWidth();
    protected static int VIEW_HEIGHT = Config.instance().getWindowHeight();

    protected static final int AREA_VIEW_WIDTH =(int) Config.instance().getAreaViewWidth();
    protected static final int AREA_VIEW_HEIGHT = (int) Config.instance().getAreaViewHeight();
    protected static final int SIDE_PANEL_WIDTH = (int) Config.instance().getSidePanelWidth();
    protected static final int SIDE_PANEL_HEIGHT = (int) Config.instance().getSidePanelHeight();
    protected static final int INVENTORY_VIEW_WIDTH = (int) Config.instance().getInventoryViewWidth(); //relative to the
    protected static final int INVENTORY_VIEW_HEIGHT = (int) Config.instance().getInventoryViewHeight(); //relative to
    protected static final int EQUIPMENT_VIEW_WIDTH = (int) Config.instance().getEquipmentViewWidth(); //relative to the
    protected static final int EQUIPMENT_VIEW_HEIGHT = (int) Config.instance().getEquipmentViewHeight(); //relative to
    protected static final int STATS_VIEW_WIDTH = (int) Config.instance().getStatsViewWidth(); //relative to the
    protected static final int STATS_VIEW_HEIGHT = (int) Config.instance().getStatsViewHeight(); //relative to the


    public abstract void selectInventoryView();
    public abstract void selectEquipView();
    public abstract void selectAreaView();
}
