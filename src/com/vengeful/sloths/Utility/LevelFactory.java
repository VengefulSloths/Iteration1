package com.vengeful.sloths.Utility;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.Map;

import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.Map.Terrains.Grass;
import com.vengeful.sloths.Models.Stats.BaseStats;

import com.vengeful.sloths.Models.Map.MapItems.Obstacle;
import com.vengeful.sloths.Models.Map.Terrains.Mountain;
import com.vengeful.sloths.Models.Map.Terrains.Water;
import com.vengeful.sloths.View.AreaView.CameraView;
import com.vengeful.sloths.View.AreaView.CameraViewManager;
import com.vengeful.sloths.View.AreaView.DynamicCameraView;
import com.vengeful.sloths.View.AreaView.StaticCameraView;
import com.vengeful.sloths.Models.Map.MapItems.*;

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

        MapItem mapItem1 = new TakeableItem(new Hat("Blue Partyhat", new BaseStats()));
        MapItem mapItem2 = new TakeableItem(new Sword("GodSword", new BaseStats()));
        map.getTile(new Coord(3,2)).addMapItem(mapItem1);
        map.getTile(new Coord(3,2)).addMapItem(mapItem2);


        /***********************/


        return map;
    }
    private CameraViewManager generateTestCV() {
        CameraViewManager cvm = new CameraViewManager(activeMap);
        cvm.addCameraView(new StaticCameraView(0,0,5,7));
        cvm.addCameraView(new StaticCameraView(5,0,10,7));
        cvm.addCameraView(new DynamicCameraView(15,0,20,20,10,10));
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
