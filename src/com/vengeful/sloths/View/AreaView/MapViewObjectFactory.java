package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.AreaEffects.AreaEffect;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.AreaEffects.TakeDamageAE;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.Map.Terrains.Terrain;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;

import com.vengeful.sloths.View.AreaView.ViewModels.AreaEffectMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ItemMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.DecalViewObject;
import com.vengeful.sloths.View.Observers.ProxyAreaEffectObserver;

import com.vengeful.sloths.View.Observers.ProxyEntityObserver;
import com.vengeful.sloths.View.Observers.ProxyMapItemObserver;

import java.util.Iterator;

/**
 * Created by alexs on 1/31/2016.
 */
public abstract class MapViewObjectFactory {
    protected CameraView currentCameraView;
    protected CoordinateStrategy coordinateStrategy;
    protected String resources = "resources/";

    public EntityMapViewObject createEntityMapViewObject(Entity entity) {
        Coord loc = entity.getLocation();

        EntityMapViewObject emvo = new EntityMapViewObject(loc.getX(), loc.getY(), coordinateStrategy, resources + "man2", "resources/Audio/grass_step2.wav", entity.getFacingDirection() );

        //TODO: give entity a weapon on camera change
        if (((Avatar) entity).getEquipped().getSword() != null) {
            System.out.println("Created entity, about to equip: " + ((Avatar) entity).getEquipped().getSword().getItemName());
            emvo.equipWeapon(resources + "Equipment/" + ((Avatar) entity).getEquipped().getSword().getItemName());
        }
        //Create a proxy for the observer, regester the proxy w/ entity, add proxy to manager
        ProxyEntityObserver peo = new ProxyEntityObserver(emvo, entity);
        ObserverManager.instance().addProxyObserver(peo);

        return emvo;
    }

    public void set64() {
        this.resources = "resources/64/";
    }

    public abstract TerrainMapViewObject createTerrainMapViewObject(Terrain terrain, int x, int y);

    public ItemMapViewObject createItemMapViewObject(MapItem mapItem, int x, int y) {

        ItemMapViewObject itemViewObject = null;

        //Test pickup/drop item
        if(mapItem instanceof TakeableItem){
            String pickUpSoundPath = "resources/Audio/pickup.wav";
            InventoryItem item = ((TakeableItem) mapItem).getInvItemRep();

            itemViewObject = new ItemMapViewObject(x, y, resources + "Items/Takeable/" + item.getItemName(), pickUpSoundPath, coordinateStrategy);


        }else{
            itemViewObject = new ItemMapViewObject(x, y, resources + "Items/Box", "resources/Audio/break.wav", coordinateStrategy);

        }


        ProxyMapItemObserver pmio = new ProxyMapItemObserver(itemViewObject, mapItem);
        ObserverManager.instance().addProxyObserver(pmio);


        return itemViewObject;
    }
    public abstract Iterator<TerrainMapViewObject> createPrettyTerrain(Map map, int xMin, int yMin, int width, int height);
    public AreaEffectMapViewObject createAEMapViewObject(AreaEffect ae, int x, int y){

        String className = ae.getClass().getSimpleName();


        AreaEffectMapViewObject aeViewObject = new AreaEffectMapViewObject(x, y, resources + "AreaEffect/"+className.substring(0, className.length()-2), coordinateStrategy);

        ProxyAreaEffectObserver paeo = new ProxyAreaEffectObserver(aeViewObject, ae);
        ObserverManager.instance().addProxyObserver(paeo);

        return aeViewObject;
    }

    public DecalViewObject createDecalViewObject(String name, int x, int y) {
        return new DecalViewObject(x, y, resources + "/Decals/" + name, coordinateStrategy);
    }


    public CoordinateStrategy getCoordinateStrategy() {
        return coordinateStrategy;
    }

    public void setCoordinateStrategy(CoordinateStrategy coordinateStrategy) {
        this.coordinateStrategy = coordinateStrategy;
    }
}
