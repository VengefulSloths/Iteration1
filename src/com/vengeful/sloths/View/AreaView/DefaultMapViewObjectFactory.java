package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
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
import com.vengeful.sloths.View.AreaView.Animation.BoundedAnimation;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Centered32PixelCoordinateStrategy;
import com.vengeful.sloths.View.AreaView.Observers.ProxyEntityObserver;
import com.vengeful.sloths.View.AreaView.Observers.ProxyMapItemObserver;
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
    public EntityMapViewObject createEntityMapViewObject(Entity entity) {
        Coord loc = entity.getLocation();

        Direction facingDir = entity.getFacingDirection();
        BoundedAnimation facingImage;

        switch (facingDir) {
            case N:
                facingImage = new BoundedAnimation("resources/man2/standing/man_north", 1);
                break;
            case E:
                facingImage = new BoundedAnimation("resources/man2/standing/man_east", 1);
                break;
            case S:
                facingImage = new BoundedAnimation("resources/man2/standing/man_south", 1);
                break;
            case W:
                facingImage = new BoundedAnimation("resources/man2/standing/man_west", 1);
                break;
            case NE:
                facingImage = new BoundedAnimation("resources/man2/standing/man_northeast", 1);
                break;
            case NW:
                facingImage = new BoundedAnimation("resources/man2/standing/man_northwest", 1);
                break;
            case SE:
                facingImage = new BoundedAnimation("resources/man2/standing/man_southeast", 1);
                break;
            case SW:
                facingImage = new BoundedAnimation("resources/man2/standing/man_southwest", 1);
                break;
            default:
                facingImage = new BoundedAnimation("resources/man2/standing/man_south", 1);
                break;
        }

        EntityMapViewObject emvo = new EntityMapViewObject(loc.getX(), loc.getY(), coordinateStrategy, facingImage);
        emvo = new EntityMapViewObject(loc.getX(), loc.getY(), coordinateStrategy, facingImage);
        emvo.setWalkingN(new BoundedAnimation("resources/man2/moving/north/man_north", 5));
        emvo.setWalkingNE(new BoundedAnimation("resources/man2/moving/northeast/man_northeast", 5));
        emvo.setWalkingE(new BoundedAnimation("resources/man2/moving/east/man_east", 5));
        emvo.setWalkingSE(new BoundedAnimation("resources/man2/moving/southeast/man_southeast", 5));
        emvo.setWalkingS(new BoundedAnimation("resources/man2/moving/south/man_south", 5));
        emvo.setWalkingSW(new BoundedAnimation("resources/man2/moving/southwest/man_southwest", 5));
        emvo.setWalkingW(new BoundedAnimation("resources/man2/moving/west/man_west", 5));
        emvo.setWalkingNW(new BoundedAnimation("resources/man2/moving/northwest/man_northwest", 5));


        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyEntityObserver peo = new ProxyEntityObserver(emvo, entity);
        ObserverManager.instance().addProxyObserver(peo);

        return emvo;
    }

    @Override
    public TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y) {
        if (terrain.getClass() == Grass.class) {
            return new TerrainMapViewObject(x,y,"resources/Terrain/Grass.png", coordinateStrategy);
        } else if (terrain.getClass() == Mountain.class) {
            return new TerrainMapViewObject(x,y,"resources/Terrain/Mountain.png", coordinateStrategy);
        } else if (terrain.getClass() == Water.class) {
            return new TerrainMapViewObject(x,y, "resources/Terrain/Water.png", coordinateStrategy);
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
                        terrain.addTerrainImage("resources/Terrain/BeachSouthEast.png");
                    }
                    if (j+1 < yMin+height &&  i-1 >= xMin && map.getTile(new Coord(i-1,j+1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage("resources/Terrain/BeachSouthWest.png");
                    }
                    if (j-1 >= yMin &&  i+1 < xMin+width && map.getTile(new Coord(i+1,j-1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage("resources/Terrain/BeachNorthEast.png");
                    }
                    if (j-1 >= yMin &&  i-1 >= xMin && map.getTile(new Coord(i-1,j-1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage("resources/Terrain/BeachNorthWest.png");
                    }
                    if (j+1 < yMin+height && map.getTile(new Coord(i,j+1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage("resources/Terrain/BeachSouth.png");
                    }
                    if (i+1 < xMin+width && map.getTile(new Coord(i+1,j)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage("resources/Terrain/BeachEast.png");
                    }
                    if (j-1 >= yMin && map.getTile(new Coord(i,j-1)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage("resources/Terrain/BeachNorth.png");
                    }
                    if (i-1 >= xMin && map.getTile(new Coord(i-1,j)).getTerrain().getClass() == Water.class) {
                        terrain.addTerrainImage("resources/Terrain/BeachWest.png");
                    }



                }
                terrainArray.add(terrain);


            }
        }
        return terrainArray.iterator();
    }

    public ItemMapViewObject createItemMapViewObject(MapItem mapItem, int x, int y) {
        System.out.println("NEW CAMERA");
        System.out.println("ITEMS! " + mapItem);

        ItemMapViewObject itemView = null;

        //Test pickup/drop item
        if(mapItem instanceof TakeableItem){
            if(((TakeableItem) mapItem).getInvItemRep() instanceof Hat){
                itemView = new ItemMapViewObject(x, y, "resources/BlueHat.jpg", "", 1, 1000, coordinateStrategy);
            }else if(((TakeableItem) mapItem).getInvItemRep() instanceof Sword){
                itemView = new ItemMapViewObject(x, y, "resources/GodSword.jpg", "", 1, 1000, coordinateStrategy);
            }

        }else{
            itemView = new ItemMapViewObject(x, y, "resources/Items/Box/Box.png", "resources/Items/Box/Destroyed/temp", 1, 1000, coordinateStrategy);

        }


        ProxyMapItemObserver pmio = new ProxyMapItemObserver(itemView, mapItem);
        ObserverManager.instance().addProxyObserver(pmio);


        return itemView;


        /*
        ItemMapViewObject itemView = new ItemMapViewObject(x, y, "resources/Items/Box/Box.png", "resources/Items/Box/Destroyed/temp", 1, 1000, coordinateStrategy);
        ProxyMapItemObserver pmio = new ProxyMapItemObserver(itemView, mapItem);
        ObserverManager.instance().addProxyObserver(pmio);*/
    }
}
