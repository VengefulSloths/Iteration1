package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.View.AreaView.CameraView;

public class StaticCameraView extends CameraView {
	public StaticCameraView(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public void populate(MapViewObjectManager mvop) {

	}
}
