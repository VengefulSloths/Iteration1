package com.vengeful.sloths.View;

/**
 * Created by Alex on 2/3/2016.
 */
public class ViewTime {
    private long currentTimeMilli;
    private static ViewTime instance = null;
    private ViewTime() {

    }
    public static ViewTime getInstance() {
        if (instance == null) {
            instance = new ViewTime();
        }
        return instance;
    }
    public void tick() {
        this.currentTimeMilli = System.currentTimeMillis();
    }
    public long getCurrentTimeMilli() {
        return currentTimeMilli;
    }
}
