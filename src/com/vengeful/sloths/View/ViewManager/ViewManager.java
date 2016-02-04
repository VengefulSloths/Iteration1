package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.InventoryView.EquipmentView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
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
    //StatsView statsview;
    ListInventoryView inventoryView;
    EquipmentView equipmentView;
    //private static int VIEW_WIDTH = Config.instance().getAreaViewWidth();
    // private static int VIEW_HEIGHT = Config.instance().getAreaViewHeight();
    protected static int VIEW_WIDTH = Config.instance().getWindowWidth();
    protected static int VIEW_HEIGHT = Config.instance().getWindowHeight();

    protected static final double SIDE_PANEL_WIDTH_PROPORTION = Config.instance().getSidePanelWidthProportion();
    protected static final double SIDE_PANEL_HEIGHT_PROPORTION = Config.instance().getSidePanelHeightProportion();

    protected static final double AREA_VIEW_WIDTH_PROPORTION = 1.0 - SIDE_PANEL_WIDTH_PROPORTION;
    protected static final double AREA_VIEW_HEIGHT_PROPORTION = 1.0;

    //private static final double SIDE_PANEL_WIDTH_PROPORTION = 1.0 - AREA_VIEW_WIDTH_PROPORTION;
    //private static final double SIDE_PANEL_HEIGHT_PROPORTION = 1.0;
    protected static final double INVENTORY_VIEW_WIDTH_PROPORTION = 1.0;
    protected static final double INVENTORY_VIEW_HEIGHT_PROPORTION = 0.50; //edit: this will change when StatsView and HUDView are added
    protected static final double EQUIPMENT_VIEW_WIDTH_PROPORTION = 1.0;
    protected static final double EQUIPMENT_VIEW_HEIGHT_PROPORTION = 0.40; //edit: this will change when StatsView and HUDView are added

    //private static final double STATS_VIEW_HEIGHT_PROPORTION = .30;
    //private static final double HUD_VIEW_HEIGHT_PROPORTION = 1.0 - STATS_VIEW_HEIGHT_PROPORTION - INVENTORY_VIEW_HEIGHT_PROPORTION;


    protected static final int AREA_VIEW_WIDTH =(int) (AREA_VIEW_WIDTH_PROPORTION * VIEW_WIDTH);
    protected static final int AREA_VIEW_HEIGHT = (int) (AREA_VIEW_HEIGHT_PROPORTION * VIEW_HEIGHT);
    protected static final int SIDE_PANEL_WIDTH = (int) (SIDE_PANEL_WIDTH_PROPORTION * VIEW_WIDTH);
    protected static final int SIDE_PANEL_HEIGHT = (int) (SIDE_PANEL_HEIGHT_PROPORTION * VIEW_HEIGHT);
    protected static final int INVENTORY_VIEW_WIDTH = (int) (INVENTORY_VIEW_WIDTH_PROPORTION * SIDE_PANEL_WIDTH); //relative to the
    protected static final int INVENTORY_VIEW_HEIGHT = (int) (INVENTORY_VIEW_HEIGHT_PROPORTION * SIDE_PANEL_HEIGHT); //relative to
    protected static final int EQUIPMENT_VIEW_WIDTH = (int) (EQUIPMENT_VIEW_WIDTH_PROPORTION * SIDE_PANEL_WIDTH); //relative to the
    protected static final int EQUIPMENT_VIEW_HEIGHT = (int) (EQUIPMENT_VIEW_HEIGHT_PROPORTION * SIDE_PANEL_HEIGHT); //relative to



    public abstract void selectInventoryView();
    public abstract void selectEquipView();
    public abstract void selectAreaView();
}
