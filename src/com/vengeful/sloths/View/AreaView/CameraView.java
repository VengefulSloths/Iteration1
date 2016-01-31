package com.vengeful.sloths.View.AreaView;

public abstract class CameraView {
	protected int x;
	protected int y;
	protected CoordinateStrategy converter;
	protected int height;
	protected int width;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}

	public abstract void populate(MapViewObjectManager mvom);
}
