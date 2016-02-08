package com.vengeful.sloths.View.AreaView.CoordinateStrategies;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;

/**
 * Created by luluding on 2/7/16.
 */
public class Dynamic64PixelCoordinateStrategy extends CoordinateStrategy {

    private int xOffset;
    private int yOffset;
    private EntityMapViewObject player;
    public Dynamic64PixelCoordinateStrategy(CameraView cv) {
        this.cv = cv;
        yOffset = Config.instance().getAreaViewHeight()/2;
        xOffset = Config.instance().getAreaViewWidth()/2;
        System.out.println(xOffset + " " + yOffset);
    }
    public void setPlayer(EntityMapViewObject player) {
        this.player = player;
    }

    public int doOffset(float z, float playerZ, int cameraZ, int pixelOffset) {
        return (int)((z - playerZ )*64) + pixelOffset;
    }

    @Override
    public int convertX(int x) {
        return doOffset((float) x, this.player.getFloatX(), cv.getX(), xOffset);
    }

    @Override
    public int convertX(float x) {
        return doOffset(x, this.player.getFloatX(), cv.getX(), xOffset);
    }

    @Override
    public int convertY(int y) {
        return doOffset((float) y, this.player.getFloatY(), cv.getY(), yOffset);

    }

    @Override
    public int convertY(float y) {
        return doOffset(y, this.player.getFloatY(), cv.getY(), yOffset);
    }
}
