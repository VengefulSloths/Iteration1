package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Utility.Config;

public class Centered32PixelCoordinateStrategy extends CoordinateStrategy {
	private int xOffset;
	private int yOffset;
	public Centered32PixelCoordinateStrategy(CameraView cv) {
		this.cv = cv;
		yOffset = Config.instance().getAreaViewHeight()/2 - cv.getHeight()*32/2;
		xOffset = Config.instance().getAreaViewWidth()/2 - cv.getWidth()*32/2;
		System.out.println(xOffset + " " + yOffset);
	}
	@Override
	public int convertToPixelsX(int x) {
		return xOffset+x*32;
	}

	@Override
	public int convertToPixelsX(float x) {
		return xOffset+(int)(x*32);
	}



	@Override
	public int convertToPixelsY(int y) {
		return yOffset+y*32;
	}
	@Override
	public int convertToPixelsY(float y) {
		return yOffset+(int)(y*32);
	}

}
