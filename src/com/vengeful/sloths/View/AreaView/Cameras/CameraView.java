package com.vengeful.sloths.View.AreaView.Cameras;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.AreaView.MapViewObjectManager;

public abstract class CameraView {
	protected Map map;
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

	public CameraView(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public boolean contains(int x, int y) {
		return (this.x <= x &&
				this.y <= y &&
				this.x + this.width > x &&
				this.y + this.height > y);
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public abstract void populate(MapViewObjectManager mvom);
}
