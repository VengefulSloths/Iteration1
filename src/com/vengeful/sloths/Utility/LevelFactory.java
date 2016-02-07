package com.vengeful.sloths.Utility;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Effects.EffectCommandFactory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.Map.AreaEffects.*;
import com.vengeful.sloths.Models.Map.Map;

import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.ActionInteractiveItem;
import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.InteractiveItem;
import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.InventoryInteractiveItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.Map.Terrains.Grass;

import com.vengeful.sloths.Models.Map.MapItems.Obstacle;
import com.vengeful.sloths.Models.Map.Terrains.Mountain;
import com.vengeful.sloths.Models.Map.Terrains.Water;
import com.vengeful.sloths.View.AreaView.Cameras.*;
import com.vengeful.sloths.Models.Map.MapItems.*;
import com.vengeful.sloths.View.AreaView.DesertMapViewObjectFactory;
import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.Quest.*;
import com.vengeful.sloths.View.AreaView.ViewModels.DecalViewObject;

/**
 * Created by alexs on 1/31/2016.
 */
public class LevelFactory {
    private Map activeMap;
    private CameraViewManager activeCVM;
    private Coord startingCoordinates;

    private Map generateTestMap() {
        Map map = new Map(new Coord(35,20));
        for (int i=0; i<35; i++) {
            for (int j=0; j<20; j++) {
                //map.getTile(new Coord(i,j)).setTerrain(new Mountain());
            }
        }
        for (int i=15; i<35; i++) {
            for (int j = 0; j < 20; j++) {
                map.getTile(new Coord(i,j)).setTerrain(new Mountain());
            }
        }
        for (int i=16; i<34; i++) {
            for (int j = 1; j < 19; j++) {
                map.getTile(new Coord(i,j)).setTerrain(new Grass());
            }
        }
        for (int i=19; i<25; i++) {
            for (int j=3; j<8; j++) {
                map.getTile(new Coord(i,j)).addMapItem(new OneShotTest());
            }
        }

        for (int i=25; i<30; i++) {
            for (int j = 10; j < 15; j++) {
                map.getTile(new Coord(i,j)).setTerrain(new Water());
            }
        }
        map.getTile(new Coord(14,0)).setTerrain(new Mountain());
        map.getTile(new Coord(15,1)).setTerrain(new Grass());
        map.getTile(new Coord(14,4)).setTerrain(new Mountain());
        map.getTile(new Coord(14,5)).setTerrain(new Mountain());
        map.getTile(new Coord(14,6)).setTerrain(new Mountain());
        map.getTile(new Coord(13,6)).setTerrain(new Mountain());
        map.getTile(new Coord(12,6)).setTerrain(new Mountain());

        map.getTile(new Coord(14,3)).setTerrain(new Mountain());

        for (int i=6; i <15; i++) {
            map.getTile(new Coord(i,2)).setTerrain(new Mountain());
        }
        for (int i=0; i<12; i++) {
            for(int j=5; j<7; j++) {
                map.getTile(new Coord(i,j)).setTerrain(new Water());
            }
        }
        map.getTile(new Coord(5,5)).addMapItem(new Obstacle());
        map.getTile(new Coord(12,3)).addMapItem(new Obstacle());
        map.getTile(new Coord(2,3)).addMapItem(new OneShotTest());
        MapItem obstacle1 = new Obstacle();
        map.getTile(new Coord(1,2)).addMapItem(obstacle1);
        MapItem obstacle2 = new Obstacle();
        map.getTile(new Coord(27, 8)).addMapItem(obstacle2);


        /* Testing pick up item */

        //MapItem mapItem1 = new TakeableItem(new Hat("BluePartyHat"));
        MapItem testWeapon = new TakeableItem(new Sword("Dagger"));
        MapItem testHat = new TakeableItem(new Hat("SpartanHat"));
        map.getTile(new Coord(3,2)).addMapItem(testWeapon);
        map.getTile(new Coord(3,4)).addMapItem(testHat);

        //map.getTile(new Coord(3,2)).addMapItem(mapItem2);
        /***********************/


        /**** Test AE ****/
        EffectCommandFactory effectCMDFactory = new EffectCommandFactory(map);

        AreaEffect ae1 = new TakeDamageAE(1, effectCMDFactory);
        AreaEffect ae2 = new LevelUpAE(effectCMDFactory);
        AreaEffect ae3 = new HealDamageAE(1, effectCMDFactory);
        AreaEffect ae4 = new InstantDeathAE(effectCMDFactory);
        map.getTile(new Coord(7, 0)).addAreaEffect(ae1);
        //map.getTile(new Coord(3, 0)).addAreaEffect(ae2);
        map.getTile(new Coord(8, 0)).addAreaEffect(ae3);
        map.getTile(new Coord(9, 0)).addAreaEffect(ae4);
        map.getTile(new Coord(10,0)).addAreaEffect(ae2);

        /** Test Interactive Item***/
        EffectCommand cmd = effectCMDFactory.createDestroyObstacleCommand(obstacle1);
        InteractiveItem ii = new InventoryInteractiveItem(cmd, ((TakeableItem)testWeapon).getInvItemRep());
        map.getTile(new Coord(3,3)).addMapItem(ii);


        Quest q = new BreakBoxQuest(map.getTile(new Coord(19, 3)), map.getTile(new Coord(19, 4)), map.getTile(new Coord(19, 5)));
        EffectCommand cmd2 = effectCMDFactory.createDestroyObstacleCommand(obstacle2);
        InteractiveItem ii2 = new ActionInteractiveItem(cmd2, q);
        map.getTile(new Coord(24, 9)).addMapItem(ii2);
        

        return map;
    }
    private CameraViewManager generateTestCV() {

        CameraViewManager cvm = new CameraViewManager(activeMap);
        ZoomedStaticCameraView start = new ZoomedStaticCameraView(0,0,5,7);
        start.addDecal(1,1,"Hydrangeas");
        start.addDecal(0,2, "Roses");

        cvm.addCameraView(start);

        StaticCameraView middle = new StaticCameraView(5,0,10,7);
        middle.addDecal(6,1,"Roses");
        middle.addDecal(13,5, "Hydrangeas");
        middle.addDecal(9,4, "Star");

        cvm.addCameraView(middle);
        CameraView desert = new DynamicCameraView(15,0,20,20);
        desert.addDecal(32,17,"RedX");
        desert.addDecal(30,5, "Skull");

        desert.setMapViewObjectFactory(new DesertMapViewObjectFactory(desert));
        cvm.addCameraView(desert);

        return cvm;
    }

    public Map getMap() {
        return activeMap;
    }
    public CameraViewManager getCVM() {
        return activeCVM;
    }
    public Coord getStartingCoordinates() {
        return startingCoordinates;
    }
    public boolean initilize(String levelname) {
         switch(levelname) {
             case "TEST":
                 activeMap = generateTestMap();
                 activeCVM = generateTestCV();
                 startingCoordinates = new Coord(2,2);
                 return true;
             default:
                 System.out.println("Level: " + levelname + " not found");
                 return false;
         }
    }
}
