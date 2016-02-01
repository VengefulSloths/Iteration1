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

    private final int areaViewWidth = 450;
    private final int areaViewHeight = 450;
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
