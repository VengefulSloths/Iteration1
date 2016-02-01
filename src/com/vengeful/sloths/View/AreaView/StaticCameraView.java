package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.View.AreaView.CameraView;

public class StaticCameraView extends CameraView {
	private MapViewObjectFactory mvoFactory;
	public StaticCameraView(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		mvoFactory = new DefaultMapViewObjectFactory(this);

	}
	public void populate(MapViewObjectManager mvop) {
		for (int i = x; i < x+width; i++) {
			for (int j = y; j<y+height; j++) {
				Tile tile = map.getTile(new Coord(i,j));
				if (tile.hasEntity()) {
					mvop.addMapViewObject(mvoFactory.createEntityMapViewObject(tile.getEntity()));
				}
				mvop.addMapViewObject(mvoFactory.createTerrainMapViewObject(tile.getTerrain(), i, j));
			}
		}
	}
}
