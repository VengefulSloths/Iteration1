package com.vengeful.sloths.View.AreaView.Cameras;

import com.vengeful.sloths.Models.Map.AreaEffects.AreaEffect;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Centered32PixelCoordinateStrategy;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Dynamic32PixelCoordinateStrategy;
import com.vengeful.sloths.View.AreaView.DefaultMapViewObjectFactory;
import com.vengeful.sloths.View.AreaView.MapViewObjectFactory;
import com.vengeful.sloths.View.AreaView.MapViewObjectManager;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;

import java.util.Iterator;

public class StaticCameraView extends CameraView {

	public StaticCameraView(int x, int y, int width, int height) {
		super(x,y,width,height);
		mvoFactory = new DefaultMapViewObjectFactory(this);

	}
	public void populate(MapViewObjectManager mvop) {
		super.populate(mvop);
		this.mapViewObjectManager = mvop;

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

				//add area effect
				Iterator<AreaEffect> aeIter = tile.getAreaEffectIterator();
				while(aeIter.hasNext()){
					mvop.addMapViewObject(mvoFactory.createAEMapViewObject(aeIter.next(), i, j));
				}

			}
		}
		Iterator<TerrainMapViewObject> iter = mvoFactory.createPrettyTerrain(map,x,y,width,height);
		while (iter.hasNext()) {
			mvop.addMapViewObject(iter.next());
		}
	}

	@Override
	public void setMapViewObjectFactory(MapViewObjectFactory mvoFactory) {
		this.mvoFactory = mvoFactory;
		this.mvoFactory.setCoordinateStrategy(new Centered32PixelCoordinateStrategy(this));
	}

}
