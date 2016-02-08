package com.vengeful.sloths.View.AreaView.CoordinateStrategies;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;

public class Centered32PixelCoordinateStrategy extends CoordinateStrategy {
	private int xOffset;
	private int yOffset;
	public Centered32PixelCoordinateStrategy(CameraView cv) {
		this.cv = cv;
		yOffset = Config.instance().getAreaViewHeight()/2 - cv.getHeight()*32/2;
		xOffset = Config.instance().getAreaViewWidth()/2 - cv.getWidth()*32/2;
		//System.out.Println(xOffset + " " + yOffset);
	}
	@Override
	public int convertX(int x) {
		return xOffset+(x - cv.getX())*32;
	}

	@Override
	public int convertX(float x) {
		return xOffset+(int)((x - (float)cv.getX())*32);
	}



	@Override
	public int convertY(int y) {
		return yOffset+(y - cv.getY())*32;
	}
	@Override
	public int convertY(float y) {
		return yOffset+(int)((y - (float)cv.getY())*32);
	}

}
