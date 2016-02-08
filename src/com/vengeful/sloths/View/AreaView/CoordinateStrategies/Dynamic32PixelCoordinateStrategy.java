package com.vengeful.sloths.View.AreaView.CoordinateStrategies;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;

/**
 * Created by alexs on 2/1/2016.
 */
public class Dynamic32PixelCoordinateStrategy extends DynamicPixelCoordinateStrategy {
    public Dynamic32PixelCoordinateStrategy(CameraView cv) {
        super(cv);
        this.pixel = 32;
    }

    @Override
    public int getResolution() {
        return 32;
    }
}
