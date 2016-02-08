package com.vengeful.sloths.View.AreaView.CoordinateStrategies;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;

/**
 * Created by luluding on 2/7/16.
 */
public class Dynamic64PixelCoordinateStrategy extends DynamicPixelCoordinateStrategy {

    public Dynamic64PixelCoordinateStrategy(CameraView cv) {
        super(cv);
        this.pixel = 64;
    }

    @Override
    public int getResolution() {
        return 64;
    }

}
