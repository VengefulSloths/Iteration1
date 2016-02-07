package com.vengeful.sloths.Utility;

/**
 * Created by Alex on 1/30/2016.
 */
public class Config {
    private final int viewFrameRate = 30;

    protected static final int WINDOW_WIDTH = 1100; //set the overall window width
    protected static final int WINDOW_HEIGHT = 800; //set the overall window height

    protected static final double SIDE_PANEL_WIDTH_PROPORTION = 0.25;
    protected static final double SIDE_PANEL_HEIGHT_PROPORTION = 1.0;
    protected static final double AREA_VIEW_WIDTH_PROPORTION = 1.0 - SIDE_PANEL_WIDTH_PROPORTION;
    protected static final double AREA_VIEW_HEIGHT_PROPORTION = 1.0;
    protected static final double INVENTORY_VIEW_WIDTH_PROPORTION = 1.0;
    protected static final double INVENTORY_VIEW_HEIGHT_PROPORTION = 0.50; //edit: this will change when StatsView and HUDView are added
    protected static final double EQUIPMENT_VIEW_WIDTH_PROPORTION = 1.0;
    protected static final double EQUIPMENT_VIEW_HEIGHT_PROPORTION = 0.25; //edit: this will change when StatsView and HUDView are added
    protected static final double STATS_VIEW_WIDTH_PROPORTION = 1.0;
    protected static final double STATS_VIEW_HEIGHT_PROPORTION = .25;
    protected static final double HUD_VIEW_WIDTH_PROPORTION = 1.0;
    protected static final double HUD_VIEW_HEIGHT_PROPORTION = .23;


    protected static final int SIDE_PANEL_WIDTH = (int) (SIDE_PANEL_WIDTH_PROPORTION * WINDOW_WIDTH);
    protected static final int SIDE_PANEL_HEIGHT = (int) (SIDE_PANEL_HEIGHT_PROPORTION * WINDOW_HEIGHT);
    protected static final int MAIN_PANEL_WIDTH = WINDOW_WIDTH-SIDE_PANEL_WIDTH;
    protected static final int MAIN_PANEL_HEIGHT = WINDOW_HEIGHT;


    protected static final int AREA_VIEW_WIDTH = (int) (AREA_VIEW_WIDTH_PROPORTION * WINDOW_WIDTH);
    protected static final int AREA_VIEW_HEIGHT = (int) (AREA_VIEW_HEIGHT_PROPORTION * ((1.0-HUD_VIEW_HEIGHT_PROPORTION)*WINDOW_HEIGHT));
    protected static final int INVENTORY_VIEW_WIDTH = (int) (INVENTORY_VIEW_WIDTH_PROPORTION * SIDE_PANEL_WIDTH); //relative to the
    protected static final int INVENTORY_VIEW_HEIGHT = (int) (INVENTORY_VIEW_HEIGHT_PROPORTION * SIDE_PANEL_HEIGHT); //relative to
    protected static final int EQUIPMENT_VIEW_WIDTH = (int) (EQUIPMENT_VIEW_WIDTH_PROPORTION * SIDE_PANEL_WIDTH); //relative to the4
    protected static final int EQUIPMENT_VIEW_HEIGHT = (int) (EQUIPMENT_VIEW_HEIGHT_PROPORTION * SIDE_PANEL_HEIGHT); //relative to
    protected static final int STATS_VIEW_WIDTH = (int) (STATS_VIEW_WIDTH_PROPORTION * SIDE_PANEL_WIDTH); //relative to the
    protected static final int STATS_VIEW_HEIGHT = (int) (STATS_VIEW_HEIGHT_PROPORTION * SIDE_PANEL_HEIGHT); //relative to the
    protected static final int HUD_VIEW_WIDTH = (int) (HUD_VIEW_WIDTH_PROPORTION*MAIN_PANEL_WIDTH);
    protected static final int HUD_VIEW_HEIGHT = (int) (HUD_VIEW_HEIGHT_PROPORTION * MAIN_PANEL_HEIGHT);



    public final int INVENTORY_IMAGE_HEIGHT = 20; //increment the y positions by height + 24
    public final int INVENTORY_IMAGE_WIDTH = 20; //original was 18x18


    public int getWindowWidth() {
        return WINDOW_WIDTH;
    }
    public int getWindowHeight() {
        return WINDOW_HEIGHT;
    }
    public static int getMainPanelWidth() {
        return MAIN_PANEL_WIDTH;
    }
    public static int getMainPanelHeight() {
        return MAIN_PANEL_HEIGHT;
    }
    public static int getSidePanelWidth() {
        return SIDE_PANEL_WIDTH;
    }
    public static int getSidePanelHeight() {
        return SIDE_PANEL_HEIGHT;
    }
    public static int getAreaViewWidth() {
        return AREA_VIEW_WIDTH;
    }
    public static int getAreaViewHeight() {
        return AREA_VIEW_HEIGHT;
    }
    public static int getInventoryViewWidth() {
        return INVENTORY_VIEW_WIDTH;
    }
    public static int getInventoryViewHeight() {
        return INVENTORY_VIEW_HEIGHT;
    }
    public static int getEquipmentViewWidth() {
        return EQUIPMENT_VIEW_WIDTH;
    }
    public static int getEquipmentViewHeight() {
        return EQUIPMENT_VIEW_HEIGHT;
    }
    public static int getStatsViewWidth() {
        return STATS_VIEW_WIDTH;
    }
    public static int getStatsViewHeight() {
        return STATS_VIEW_HEIGHT;
    }
    public static int getHUDViewWidth() {return HUD_VIEW_WIDTH; }
    public static int getHUDViewHeight() {return HUD_VIEW_HEIGHT; }



    private static Config instance = null;
    private Config() {

    }
    public int getViewFrameRate() {
        return viewFrameRate;
    }
    public static Config instance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
