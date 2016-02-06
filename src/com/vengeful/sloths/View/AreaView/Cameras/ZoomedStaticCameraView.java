package com.vengeful.sloths.View.AreaView.Cameras;

import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Centered64PixelCoordinateStrategy;
import com.vengeful.sloths.View.AreaView.DefaultMapViewObjectFactory;
import com.vengeful.sloths.View.AreaView.MapViewObjectManager;

/**
 * Created by alexs on 2/6/2016.
 */
public class ZoomedStaticCameraView extends StaticCameraView {

    public ZoomedStaticCameraView(int x, int y, int width, int height) {
        super(x,y,width,height);
        mvoFactory.setCoordinateStrategy(new Centered64PixelCoordinateStrategy(this));
        mvoFactory.set64();
    }

}
