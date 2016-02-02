package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.View.AreaView.CameraView;

import java.util.Iterator;

public class StaticCameraView extends CameraView {
	private MapViewObjectFactory mvoFactory;
	public StaticCameraView(int x, int y, int width, int height) {
		super(x,y,width,height);
		mvoFactory = new DefaultMapViewObjectFactory(this);

	}
	public void populate(MapViewObjectManager mvop) {
		for (int i = x; i < x+width; i++) {
			for (int j = y; j<y+height; j++) {
				Tile tile = map.getTile(new Coord(i,j));

				//Add a entity maybe
				if (tile.hasEntity()) {
					mvop.addMapViewObject(mvoFactory.createEntityMapViewObject(tile.getEntity()));
				}

				//Add some map items
				Iterator<MapItem> itemIter = tile.getMapItemIterator();
				while (itemIter.hasNext()) {
					mvop.addMapViewObject(mvoFactory.createItemMapViewObject(itemIter.next(), i, j));
				}

				mvop.addMapViewObject(mvoFactory.createTerrainMapViewObject(tile.getTerrain(), i, j));
			}
		}
	}
}
