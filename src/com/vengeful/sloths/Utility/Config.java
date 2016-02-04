package com.vengeful.sloths.Utility;

/**
 * Created by Alex on 1/30/2016.
 */
public class Config {
    private final int viewFrameRate = 30;

    public int getAreaViewHeight() {
        return areaViewHeight;
    }

    public int getAreaViewWidth() {
        return areaViewWidth;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public double getSidePanelWidth() {
        return sidePanelWidth;
    }

    public double getSidePanelHeight() {
        return sidePanelHeight;
    }

    public double getSidePanelWidthProportion() {
        return sidePanelWidthProportion;
    }

    public double getSidePanelHeightProportion() {
        return sidePanelHeightProportion;
    }

    private final int windowWidth = 1100; //set the overall window width
    private final int windowHeight = 800; //set the overall window height

    private final double sidePanelWidthProportion = 0.25; //proportion of the overall window width that is the sidePanel
    private final double sidePanelHeightProportion = 1.0; //proportion of the overall window height that is the sidePanel

    private final double sidePanelWidth = sidePanelWidthProportion * windowWidth; //sidePanelWidth relative to windowWidth
    private final double sidePanelHeight = sidePanelHeightProportion * windowHeight; //sidePanelHeight relative to windowHeight

    private final int areaViewWidth = (int) (windowWidth - sidePanelWidth); //areaViewWidth (gameplay area) relative to window width and sidePanelWidth
    private final int areaViewHeight = (int) (windowHeight); //area ViewHeight (same as windowviewHeight)

    public final int INVENTORY_IMAGE_HEIGHT = 18; //increment the y positions by height + 2
    public final int INVENTORY_IMAGE_WIDTH = 18;

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
