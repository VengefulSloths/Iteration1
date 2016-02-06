package com.vengeful.sloths.Utility;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.Map.AreaEffects.*;
import com.vengeful.sloths.Models.Map.Map;

import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.Map.Terrains.Grass;
import com.vengeful.sloths.Models.Stats.BaseStats;

import com.vengeful.sloths.Models.Map.MapItems.Obstacle;
import com.vengeful.sloths.Models.Map.Terrains.Mountain;
import com.vengeful.sloths.Models.Map.Terrains.Water;
import com.vengeful.sloths.View.AreaView.Cameras.*;
import com.vengeful.sloths.Models.Map.MapItems.*;
import com.vengeful.sloths.View.AreaView.DesertMapViewObjectFactory;

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
        map.getTile(new Coord(1,2)).addMapItem(new Obstacle());
        map.getTile(new Coord(12,3)).addMapItem(new Obstacle());
        map.getTile(new Coord(2,3)).addMapItem(new OneShotTest());


        /* Testing pick up item */

        //MapItem mapItem1 = new TakeableItem(new Hat("BluePartyHat"));
        MapItem mapItem2 = new TakeableItem(new Sword("Dagger"));
        map.getTile(new Coord(3,2)).addMapItem(mapItem2);
        //map.getTile(new Coord(3,2)).addMapItem(mapItem2);
        /***********************/


        /**** Test AE ****/
        AreaEffect ae1 = new TakeDamageAE(1);
        AreaEffect ae2 = new LevelUpAE();
        AreaEffect ae3 = new HealDamageAE(1);
        AreaEffect ae4 = new InstantDeathAE();
        map.getTile(new Coord(7, 0)).addAreaEffect(ae1);
        //map.getTile(new Coord(3, 0)).addAreaEffect(ae2);
        map.getTile(new Coord(8, 0)).addAreaEffect(ae3);
        map.getTile(new Coord(9, 0)).addAreaEffect(ae4);
        map.getTile(new Coord(10,0)).addAreaEffect(ae2);



        return map;
    }
    private CameraViewManager generateTestCV() {
        CameraViewManager cvm = new CameraViewManager(activeMap);
        cvm.addCameraView(new ZoomedStaticCameraView(0,0,5,7));
        cvm.addCameraView(new StaticCameraView(5,0,10,7));
        CameraView test = new DynamicCameraView(15,0,20,20);
        test.setMapViewObjectFactory(new DesertMapViewObjectFactory(test));
        cvm.addCameraView(test);

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
