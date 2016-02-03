package com.vengeful.sloths.View.AreaView.CoordinateStrategies;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;

/**
 * Created by alexs on 2/1/2016.
 */
public class Dynamic32PixelCoordinateStrategy extends CoordinateStrategy {
    private int xOffset;
    private int yOffset;
    private EntityMapViewObject player;
    public Dynamic32PixelCoordinateStrategy(CameraView cv) {
        this.cv = cv;
        yOffset = Config.instance().getAreaViewHeight()/2;
        xOffset = Config.instance().getAreaViewWidth()/2;
        System.out.println(xOffset + " " + yOffset);
    }
    public void setPlayer(EntityMapViewObject player) {
        this.player = player;
    }

    public int doOffset(float z, float playerZ, int cameraZ, int pixelOffset) {
        return (int)((z - playerZ )*32) + pixelOffset;
    }

    @Override
    public int convertX(int x) {
        return doOffset(x, this.player.getFloatX(), cv.getX(), xOffset);
    }

    @Override
    public int convertX(float x) {
        return doOffset(x, this.player.getFloatX(), cv.getX(), xOffset);
    }

    @Override
    public int convertY(int y) {
        return doOffset(y, this.player.getFloatY(), cv.getY(), yOffset);

    }

    @Override
    public int convertY(float y) {
        return doOffset(y, this.player.getFloatY(), cv.getY(), yOffset);
    }
}
