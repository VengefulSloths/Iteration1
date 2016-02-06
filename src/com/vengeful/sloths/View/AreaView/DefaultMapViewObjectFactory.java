package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.AreaEffects.AreaEffect;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.Map.Terrains.Grass;
import com.vengeful.sloths.Models.Map.Terrains.Mountain;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;
import com.vengeful.sloths.Models.Map.Terrains.Water;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.*;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.Animation.BoundedAnimation;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Centered32PixelCoordinateStrategy;
import com.vengeful.sloths.View.AreaView.ViewModels.AreaEffectMapViewObject;
import com.vengeful.sloths.View.Observers.ProxyEntityObserver;
import com.vengeful.sloths.View.Observers.ProxyMapItemObserver;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ItemMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by alexs on 1/31/2016.
 */
public class DefaultMapViewObjectFactory extends MapViewObjectFactory {
    public DefaultMapViewObjectFactory(CameraView cv) {
        this.currentCameraView = cv;
        coordinateStrategy = new Centered32PixelCoordinateStrategy(this.currentCameraView);
    }

    @Override
    public TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y) {
        if (terrain.getClass() == Grass.class) {
            return new TerrainMapViewObject(x,y, resources + "Terrain/Grass.png", coordinateStrategy);
        } else if (terrain.getClass() == Mountain.class) {
            return new TerrainMapViewObject(x,y, resources + "Terrain/Mountain.png", coordinateStrategy);
        } else if (terrain.getClass() == Water.class) {
            return new TerrainMapViewObject(x,y, resources + "Terrain/Water.png", coordinateStrategy);
        }
        else {
            System.out.println("Could not create appropriate terrain class");
            return null;
        }
    }


    public Iterator<TerrainMapViewObject> createPrettyTerrain(Map map, int xMin, int yMin, int width, int height) {
        ArrayList<TerrainMapViewObject> terrainArray = new ArrayList<>();
        for (int i = xMin; i < xMin + width; i++) {
            for (int j = yMin; j <yMin + height; j++) {
                Tile tile = map.getTile(new Coord(i,j));
                TerrainMapViewObject terrain = createTerrainMapViewObject(tile.getTerrain(), i, j);

                //TODO: Clean this process up with and object or something
                if (tile.getTerrain().getClass() == Grass.class) {
                    if (j+1 < yMin+height &&  i+1 < xMin+width && map.getTile(new Coord(i+1,j+1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachSouthEast.png");
                    }
                    if (j+1 < yMin+height &&  i-1 >= xMin && map.getTile(new Coord(i-1,j+1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachSouthWest.png");
                    }
                    if (j-1 >= yMin &&  i+1 < xMin+width && map.getTile(new Coord(i+1,j-1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachNorthEast.png");
                    }
                    if (j-1 >= yMin &&  i-1 >= xMin && map.getTile(new Coord(i-1,j-1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachNorthWest.png");
                    }
                    if (j+1 < yMin+height && map.getTile(new Coord(i,j+1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachSouth.png");
                    }
                    if (i+1 < xMin+width && map.getTile(new Coord(i+1,j)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachEast.png");
                    }
                    if (j-1 >= yMin && map.getTile(new Coord(i,j-1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachNorth.png");
                    }
                    if (i-1 >= xMin && map.getTile(new Coord(i-1,j)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage( resources + "Terrain/BeachWest.png");
                    }
                }
                terrainArray.add(terrain);
            }
        }
        return terrainArray.iterator();
    }


}
