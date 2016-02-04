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
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.Animation.BoundedAnimation;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.Centered32PixelCoordinateStrategy;
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
    public EntityMapViewObject createEntityMapViewObject(Entity entity) {
        Coord loc = entity.getLocation();

        Direction facingDir = entity.getFacingDirection();
        AnimatedImage facingImage;

        switch (facingDir) {
            case N:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_north");
                break;
            case E:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_east");
                break;
            case S:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_south");
                break;
            case W:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_west");
                break;
            case NE:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_northeast");
                break;
            case NW:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_northwest");
                break;
            case SE:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_southeast");
                break;
            case SW:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_southwest");
                break;
            default:
                facingImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage("resources/man2/standing/man_south");
                break;
        }

        EntityMapViewObject emvo = new EntityMapViewObject(loc.getX(), loc.getY(), coordinateStrategy, facingImage);

        AnimatedImageFactory aif = AnimatedImageFactory.instance();
        emvo.setWalkingN( aif.createTimedAnimatedImage("resources/man2/moving/north/man_north"));
        emvo.setWalkingNE(aif.createTimedAnimatedImage("resources/man2/moving/northeast/man_northeast"));
        emvo.setWalkingE( aif.createTimedAnimatedImage("resources/man2/moving/east/man_east"));
        emvo.setWalkingSE(aif.createTimedAnimatedImage("resources/man2/moving/southeast/man_southeast"));
        emvo.setWalkingS( aif.createTimedAnimatedImage("resources/man2/moving/south/man_south"));
        emvo.setWalkingSW(aif.createTimedAnimatedImage("resources/man2/moving/southwest/man_southwest"));
        emvo.setWalkingW( aif.createTimedAnimatedImage("resources/man2/moving/west/man_west"));
        emvo.setWalkingNW(aif.createTimedAnimatedImage("resources/man2/moving/northwest/man_northwest"));



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
                itemView = new ItemMapViewObject(x, y, "resources/Items/BluePartyHat", coordinateStrategy);
            }else if(((TakeableItem) mapItem).getInvItemRep() instanceof Sword){
                itemView = new ItemMapViewObject(x, y, "resources/Items/GodSword", coordinateStrategy);
            }

        }else{
            itemView = new ItemMapViewObject(x, y, "resources/Items/Box", coordinateStrategy);

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
