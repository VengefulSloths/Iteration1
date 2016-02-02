package com.vengeful.sloths.View.AreaView;

public abstract class CoordinateStrategy {
	protected CameraView cv;
	public abstract int convertX(int x);
	public abstract int convertX(float x);

	public abstract int convertY(int y);
	public abstract int convertY(float y);
}
