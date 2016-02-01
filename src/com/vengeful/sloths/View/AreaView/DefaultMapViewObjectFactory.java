package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.Terrains.Grass;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by alexs on 1/31/2016.
 */
public class DefaultMapViewObjectFactory extends MapViewObjectFactory{
    private CoordinateStrategy coordinateStrategy;
    public DefaultMapViewObjectFactory(CameraView cv) {
        this.currentCameraView = cv;
        coordinateStrategy = new Centered32PixelCoordinateStrategy(this.currentCameraView);
    }
    @Override
    public EntityMapViewObject createEntityMapViewObject(Entity entity) {
        Coord loc = entity.getLocation();
        EntityMapViewObject emvo = new EntityMapViewObject(loc.getX(), loc.getY(), coordinateStrategy, new BoundedAnimation("resources/man2/standing/man_south", 1));
        emvo.setWalkingN(new BoundedAnimation("resources/man2/moving/north/man_north", 5));
        emvo.setWalkingNE(new BoundedAnimation("resources/man2/moving/northeast/man_northeast", 5));
        emvo.setWalkingE(new BoundedAnimation("resources/man2/moving/east/man_east", 5));
        emvo.setWalkingSE(new BoundedAnimation("resources/man2/moving/southeast/man_southeast", 5));
        emvo.setWalkingS(new BoundedAnimation("resources/man2/moving/south/man_south", 5));
        emvo.setWalkingSW(new BoundedAnimation("resources/man2/moving/southwest/man_southwest", 5));
        emvo.setWalkingW(new BoundedAnimation("resources/man2/moving/west/man_west", 5));
        emvo.setWalkingNW(new BoundedAnimation("resources/man2/moving/northwest/man_northwest", 5));


        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyEntityObserver peo = new ProxyEntityObserver(emvo);
        entity.registerObserver(peo);
        ObserverManager.instance().addProxyObserver(peo);

        return emvo;
    }

    @Override
    public TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y) {
        if (terrain.getClass() == Grass.class) {
            return new TerrainMapViewObject(x,y,"resources/grass.png", coordinateStrategy);
        }
        else {
            System.out.println("Could not create appropriate terrain class");
            return null;
        }
    }
}
