package com.vengeful.sloths.View.AreaView;

public class Centered32PixelCoordinateStrategy extends CoordinateStrategy {
	private int xOffset;
	private int yOffset;
	public Centered32PixelCoordinateStrategy(CameraView cv, AreaView av) {
		this.cv = cv;
		System.out.println("AreaHeight: " + av.getAreaHeight() + ", cvHeight: " + cv.getHeight() );
		System.out.println("AreaWidth: " + av.getAreaWidth() + ", cvWidth: " + cv.getWidth() );

		yOffset = av.getAreaHeight()/2 - cv.getHeight()*32/2;
		xOffset = av.getAreaWidth()/2 - cv.getWidth()*32/2;
		System.out.println(xOffset + " " + yOffset);
	}
	@Override
	public int convertToPixelsX(int x) {
		return xOffset+x*32;
	}

	@Override
	public int convertToPixelsY(int y) {
		return yOffset+y*32;
	}

}
