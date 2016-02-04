package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.Terrains.Grass;
import com.vengeful.sloths.Models.Map.Terrains.Mountain;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;
import com.vengeful.sloths.Models.Map.Terrains.Water;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Centered32PixelCoordinateStrategy;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Alex on 2/3/2016.
 */
public class DesertMapViewObjectFactory extends MapViewObjectFactory {

    public DesertMapViewObjectFactory(CameraView cv) {
        this.currentCameraView = cv;
        coordinateStrategy = new Centered32PixelCoordinateStrategy(this.currentCameraView);
    }

    @Override
    public TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y) {
        if (terrain.getClass() == Grass.class) {
            return new TerrainMapViewObject(x,y,"resources/Terrain/Sand.png", coordinateStrategy);
        } else if (terrain.getClass() == Mountain.class) {
            return new TerrainMapViewObject(x,y,"resources/Terrain/Mountain.png", coordinateStrategy);
        } else if (terrain.getClass() == Water.class) {
            return new TerrainMapViewObject(x,y, "resources/Terrain/DesertWater.png", coordinateStrategy);
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
                if (tile.getTerrain().getClass() == Water.class) {
                    if (    j+1 < yMin+height &&    map.getTile(new Coord(i,j+1)).getTerrain().getClass() == Grass.class &&
                            i+1 < xMin+width &&     map.getTile(new Coord(i+1,j)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderSouthEast.png");
                    }
                    else  if (  j-1 >= yMin &&    map.getTile(new Coord(i,j-1)).getTerrain().getClass() == Grass.class &&
                                i-1 >= xMin &&     map.getTile(new Coord(i-1,j)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderNorthWest.png");
                    }
                    else  if (  j+1 < yMin+height &&    map.getTile(new Coord(i,j+1)).getTerrain().getClass() == Grass.class &&
                                i-1 >= xMin &&     map.getTile(new Coord(i-1,j)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderSouthWest.png");
                    }
                    else  if (  j-1 >= yMin &&    map.getTile(new Coord(i,j-1)).getTerrain().getClass() == Grass.class &&
                                i+1 < xMin+width &&     map.getTile(new Coord(i+1,j)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderNorthEast.png");

                    } else  if (j+1 < yMin+height &&    map.getTile(new Coord(i,j+1)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderSouth.png");
                    } else  if (j-1 >= yMin &&    map.getTile(new Coord(i,j-1)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderNorth.png");
                    } else  if (i+1 < xMin+width &&     map.getTile(new Coord(i+1,j)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderEast.png");
                    } else  if (i-1 >= xMin &&     map.getTile(new Coord(i-1,j)).getTerrain().getClass() == Grass.class) {
                        terrain.addTerrainImage("resources/Terrain/WaterSandBorderWest.png");
                    }

                }
                terrainArray.add(terrain);
            }
        }
        return terrainArray.iterator();
    }
}
