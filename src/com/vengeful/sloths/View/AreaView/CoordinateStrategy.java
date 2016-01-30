package com.vengeful.sloths.View.AreaView;

public abstract class CoordinateStrategy {
	protected CameraView cv;
	protected abstract int convertToPixelsX(int x);
	public final int convertX(int x) {
		x = x - cv.getX();
		return convertToPixelsX(x);
	}
	protected abstract int convertToPixelsY(int y);
	public final int convertY(int y) {
		y = y - cv.getX();
		return convertToPixelsY(y);
	}
}
