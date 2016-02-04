package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ItemMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;
import com.vengeful.sloths.View.Observers.ProxyEntityObserver;
import com.vengeful.sloths.View.Observers.ProxyMapItemObserver;

import java.util.Iterator;

/**
 * Created by alexs on 1/31/2016.
 */
public abstract class MapViewObjectFactory {
    protected CameraView currentCameraView;
    protected CoordinateStrategy coordinateStrategy;
    public EntityMapViewObject createEntityMapViewObject(Entity entity) {
        Coord loc = entity.getLocation();

        EntityMapViewObject emvo = new EntityMapViewObject(loc.getX(), loc.getY(), coordinateStrategy, "resources/man2", "resources/Audio/grass_step3.wav", entity.getFacingDirection() );

        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyEntityObserver peo = new ProxyEntityObserver(emvo, entity);
        ObserverManager.instance().addProxyObserver(peo);

        return emvo;
    }
    public abstract TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y);

    public ItemMapViewObject createItemMapViewObject(MapItem mapItem, int x, int y) {
        System.out.println("NEW CAMERA");
        System.out.println("ITEMS! " + mapItem);

        ItemMapViewObject itemView = null;

        //Test pickup/drop item
        if(mapItem instanceof TakeableItem){
            String pickUpSoundPath = "resources/Audio/pickup.wav";
            if(((TakeableItem) mapItem).getInvItemRep() instanceof Hat){
                itemView = new ItemMapViewObject(x, y, "resources/Items/BluePartyHat", pickUpSoundPath, coordinateStrategy);
            }else if(((TakeableItem) mapItem).getInvItemRep() instanceof Sword){
                itemView = new ItemMapViewObject(x, y, "resources/Items/GodSword", pickUpSoundPath, coordinateStrategy);
            }

        }else{
            itemView = new ItemMapViewObject(x, y, "resources/Items/Box", "resources/Audio/break.wav", coordinateStrategy);

        }


        ProxyMapItemObserver pmio = new ProxyMapItemObserver(itemView, mapItem);
        ObserverManager.instance().addProxyObserver(pmio);


        return itemView;


        /*
        ItemMapViewObject itemView = new ItemMapViewObject(x, y, "resources/Items/Box/Box.png", "resources/Items/Box/Destroyed/temp", 1, 1000, coordinateStrategy);
        ProxyMapItemObserver pmio = new ProxyMapItemObserver(itemView, mapItem);
        ObserverManager.instance().addProxyObserver(pmio);*/
    }
    public abstract Iterator<TerrainMapViewObject> createPrettyTerrain(Map map, int xMin, int yMin, int width, int height);

    public CoordinateStrategy getCoordinateStrategy() {
        return coordinateStrategy;
    }

    public void setCoordinateStrategy(CoordinateStrategy coordinateStrategy) {
        this.coordinateStrategy = coordinateStrategy;
    }
}
