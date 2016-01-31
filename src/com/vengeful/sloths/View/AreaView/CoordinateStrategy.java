package com.vengeful.sloths.View.AreaView;

public abstract class CoordinateStrategy {
	protected CameraView cv;
	protected abstract int convertToPixelsX(int x);
	protected abstract int convertToPixelsX(float x);
	public final int convertX(int x) {
		x = x - cv.getX();
		return convertToPixelsX(x);
	}
	public final int convertX(float x) {
		x = x - cv.getX();
		return convertToPixelsX(x);
	}
	protected abstract int convertToPixelsY(int y);
	protected abstract int convertToPixelsY(float y);
	public final int convertY(int y) {
		y = y - cv.getX();
		return convertToPixelsY(y);
	}
	public final int convertY(float y) {
		y = y - cv.getX();
		return convertToPixelsY(y);
	}
}
