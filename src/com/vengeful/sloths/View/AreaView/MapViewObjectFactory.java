package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;
import com.vengeful.sloths.Models.Map.Tile;

/**
 * Created by alexs on 1/31/2016.
 */
public abstract class MapViewObjectFactory {
    protected CameraView currentCameraView;
    public abstract EntityMapViewObject createEntityMapViewObject(Entity entity);
    public abstract TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y);
}
