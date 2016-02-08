package com.vengeful.sloths.View.AreaView.CoordinateStrategies;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;

/**
 * Created by alexs on 2/6/2016.
 */
public class Centered64PixelCoordinateStrategy extends CoordinateStrategy {
    private int xOffset;
    private int yOffset;
    public Centered64PixelCoordinateStrategy(CameraView cv) {
        this.cv = cv;
        yOffset = Config.instance().getAreaViewHeight()/2 - cv.getHeight()*64/2;
        xOffset = Config.instance().getAreaViewWidth()/2 - cv.getWidth()*64/2;
        //System.out.Println(xOffset + " " + yOffset);
    }
    @Override
    public int convertX(int x) {
        return xOffset+(x - cv.getX())*64;
    }

    @Override
    public int convertX(float x) {
        return xOffset+(int)((x - (float)cv.getX())*64);
    }



    @Override
    public int convertY(int y) {
        return yOffset+(y - cv.getY())*64;
    }
    @Override
    public int convertY(float y) {
        return yOffset+(int)((y - (float)cv.getY())*64);
    }

    @Override
    public int getResolution() {
        return 64;
    }
}
