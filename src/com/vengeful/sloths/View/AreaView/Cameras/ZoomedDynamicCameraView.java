package com.vengeful.sloths.View.AreaView.Cameras;

import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Centered64PixelCoordinateStrategy;
/**
 * Created by luluding on 2/7/16.
 */
public class ZoomedDynamicCameraView extends DynamicCameraView{

    public ZoomedDynamicCameraView(int x, int y, int width, int height){
        super(x,y,width,height);
        mvoFactory.setCoordinateStrategy(new Centered64PixelCoordinateStrategy(this));
        mvoFactory.set64();

    }
}
