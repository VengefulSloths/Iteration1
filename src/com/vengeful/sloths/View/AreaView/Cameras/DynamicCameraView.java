package com.vengeful.sloths.View.AreaView.Cameras;

import com.vengeful.sloths.Models.Map.AreaEffects.AreaEffect;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.*;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Dynamic32PixelCoordinateStrategy;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.DynamicPixelCoordinateStrategy;
import com.vengeful.sloths.View.Observers.EntityObserver;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;
import com.vengeful.sloths.View.AreaView.MapViewObjectFactory;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;

import java.util.Iterator;

/**
 * Created by alexs on 2/1/2016.
 */
public class DynamicCameraView extends CameraView
        implements EntityObserver {



    public DynamicCameraView(int x, int y, int width, int height) {
        super(x,y,width,height);
        //this.converter = new Dynamic32PixelCoordinateStrategy(this);
        mvoFactory = new DefaultMapViewObjectFactory(this);
        //mvoFactory.setCoordinateStrategy(converter);
    }
    @Override
    public void setMapViewObjectFactory(MapViewObjectFactory mvoFactory) {
        this.mvoFactory = mvoFactory;
        this.mvoFactory.setCoordinateStrategy(new Dynamic32PixelCoordinateStrategy(this));
    }
    @Override
    public void populate(MapViewObjectManager mapViewObjectManager) {
        this.mapViewObjectManager = mapViewObjectManager;

        //First find the player because the factory's strategy needs a player needs a player
        for (int i = x; i < x+width; i++) {
            for (int j = y; j < y + height; j++) {
                Tile tile = map.getTile(new Coord(i, j));
                if (tile.hasEntity()) {
                    EntityMapViewObject playerView = mvoFactory.createEntityMapViewObject(tile.getEntity());
                    ((DynamicPixelCoordinateStrategy)mvoFactory.getCoordinateStrategy()).setPlayer(playerView);
                    mapViewObjectManager.addMapViewObject(playerView);
                }
            }
        }

        for (int i = x; i < x+width; i++) {
            for (int j = y; j<y+height; j++) {
                Tile tile = map.getTile(new Coord(i,j));
                //Add some map items
                Iterator<MapItem> itemIter = tile.getMapItemIterator();
                while (itemIter.hasNext()) {
                    mapViewObjectManager.addMapViewObject(mvoFactory.createItemMapViewObject(itemIter.next(), i, j));
                }

                //Add AreaEffect
                Iterator<AreaEffect> aeIter = tile.getAreaEffectIterator();
                while(aeIter.hasNext()){
                    mapViewObjectManager.addMapViewObject(mvoFactory.createAEMapViewObject(aeIter.next(), i, j));
                }
            }
        }
        Iterator<TerrainMapViewObject> iter = mvoFactory.createPrettyTerrain(map,x,y,width,height);
        while (iter.hasNext()) {
            mapViewObjectManager.addMapViewObject(iter.next());
        }
        super.populate(mapViewObjectManager);


    }



}
