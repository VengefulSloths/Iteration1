package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.AreaEffects.AreaEffect;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.AreaView.ViewModels.AreaEffectMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ItemMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;

import java.util.Iterator;

/**
 * Created by alexs on 1/31/2016.
 */
public abstract class MapViewObjectFactory {
    protected CameraView currentCameraView;
    protected CoordinateStrategy coordinateStrategy;
    public abstract EntityMapViewObject createEntityMapViewObject(Entity entity);
    public abstract TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y);
    public abstract ItemMapViewObject createItemMapViewObject(MapItem mapItem, int x, int y);
    public abstract Iterator<TerrainMapViewObject> createPrettyTerrain(Map map, int xMin, int yMin, int width, int height);
    public abstract AreaEffectMapViewObject createAEMapViewObject(AreaEffect mapItem, int x, int y);


    public CoordinateStrategy getCoordinateStrategy() {
        return coordinateStrategy;
    }

    public void setCoordinateStrategy(CoordinateStrategy coordinateStrategy) {
        this.coordinateStrategy = coordinateStrategy;
    }
}
