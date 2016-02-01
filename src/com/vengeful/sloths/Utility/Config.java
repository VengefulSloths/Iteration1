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

    private final int windowWidth = 1100;
    private final int windowHeight = 800;

    private final double sidePanelWidthProportion = 0.25;
    private final double sidePanelHeightProportion = 1.0;

    private final double sidePanelWidth = sidePanelWidthProportion * windowWidth;
    private final double sidePanelHeight = sidePanelHeightProportion * windowHeight;

    private final int areaViewWidth = (int) (windowWidth - sidePanelWidth);
    private final int areaViewHeight = (int) (windowHeight);

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
