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
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Models.SaveLoad.ObjectParsers.ObjectWithCoord;
import com.vengeful.sloths.Models.Stats.BaseStats;
import com.vengeful.sloths.View.AreaView.Cameras.*;
import com.vengeful.sloths.Models.Map.MapItems.*;
import com.vengeful.sloths.View.AreaView.DefaultMapViewObjectFactory;
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


    private Map generateMapBase() {
        Map map = new Map(new Coord(35,20));


        for (int i=0; i<35; i++) {
            for (int j=0; j<20; j++) {
                map.getTile(new Coord(i,j)).setTerrain(new Grass());
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

        //new
        for (int i=3; i<13; i++) {
            map.getTile(new Coord(2,i)).setTerrain(new Grass());
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


        //new
        for (int i=3; i<13; i++) {
            map.getTile(new Coord(2,i)).setTerrain(new Grass());
        }

        return map;
    }


    private Map loadPopulate(Map map) {
        EffectCommandFactory effectCMDFactory = new EffectCommandFactory(map);
        MapItem obstacle2 = new Obstacle();
        map.getTile(new Coord(27, 8)).addMapItem(obstacle2);
        AreaEffect ae1 = new TakeDamageAE(1, effectCMDFactory);
        AreaEffect ae2 = new LevelUpAE(effectCMDFactory);
        AreaEffect ae3 = new HealDamageAE(1, effectCMDFactory);
        AreaEffect ae4 = new InstantDeathAE(effectCMDFactory);
        map.getTile(new Coord(7, 0)).addAreaEffect(ae1);
        //map.getTile(new Coord(3, 0)).addAreaEffect(ae2);
        map.getTile(new Coord(8, 0)).addAreaEffect(ae3);
        map.getTile(new Coord(9, 0)).addAreaEffect(ae4);
        map.getTile(new Coord(10,0)).addAreaEffect(ae2);

//        /** Test Interactive Item***/
//        EffectCommand cmd = effectCMDFactory.createDestroyObstacleCommand(obstacle1, map.getTile(new Coord(1, 2)));
//        InteractiveItem ii = new InventoryInteractiveItem(cmd, ((TakeableItem)testWeapon).getInvItemRep());
//        map.getTile(new Coord(3,3)).addMapItem(ii);
        //MapItem testOneShot = new OneShotTest();
        //map.getTile(new Coord(4,3)).addMapItem(testOneShot);


        Quest q = new BreakBoxQuest(map.getTile(new Coord(19, 3)), map.getTile(new Coord(19, 4)), map.getTile(new Coord(19, 5)));
        EffectCommand cmd2 = effectCMDFactory.createDestroyObstacleCommand(obstacle2, map.getTile(new Coord(27, 8)));
        InteractiveItem ii2 = new ActionInteractiveItem(cmd2, q);
        map.getTile(new Coord(24, 9)).addMapItem(ii2);

        return map;
    }

    public Map populateFromLoad(Map map, Loader loader) {

        for (ObjectWithCoord owc : loader.listToInstantiate) {
            System.out.println(owc.getC().getX()+ " " + owc.getC().getY());
            map.getTile(owc.getC()).addMapItem((MapItem)owc.getObjectToPlace());
        }


        return map;
    }

    private Map populateTestMap(Map map) {

        map.getTile(new Coord(5,5)).addMapItem(new Obstacle());
        map.getTile(new Coord(12,3)).addMapItem(new Obstacle());
        map.getTile(new Coord(2,3)).addMapItem(new OneShotTest());
        MapItem obstacle1 = new Obstacle();
        map.getTile(new Coord(1,2)).addMapItem(obstacle1);
        MapItem obstacle2 = new Obstacle();
        map.getTile(new Coord(27, 8)).addMapItem(obstacle2);


        /* Testing pick up item */

        //MapItem mapItem1 = new TakeableItem(new Hat("BluePartyHat"));
        MapItem testWeapon = new TakeableItem(new Sword("Dagger", new BaseStats(10,0,0,0,0)));
        MapItem testHat = new TakeableItem(new Hat("SpartanHat"));
        MapItem wand = new TakeableItem(new Sword("Wand", new BaseStats(0,0,10,0,0)));
        map.getTile(new Coord(3,2)).addMapItem(testWeapon);
        map.getTile(new Coord(3,4)).addMapItem(testHat);
        map.getTile(new Coord(1,3)).addMapItem(wand);

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
        EffectCommand cmd = effectCMDFactory.createDestroyObstacleCommand(obstacle1, map.getTile(new Coord(1, 2)));
        InteractiveItem ii = new InventoryInteractiveItem(cmd, ((TakeableItem)testWeapon).getInvItemRep());
        map.getTile(new Coord(3,3)).addMapItem(ii);
        //MapItem testOneShot = new OneShotTest();
        //map.getTile(new Coord(4,3)).addMapItem(testOneShot);


        Quest q = new BreakBoxQuest(map.getTile(new Coord(19, 3)), map.getTile(new Coord(19, 4)), map.getTile(new Coord(19, 5)));
        EffectCommand cmd2 = effectCMDFactory.createDestroyObstacleCommand(obstacle2, map.getTile(new Coord(27, 8)));
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

        ZoomedStaticCameraView below = new ZoomedStaticCameraView(0,7,5,7);

        cvm.addCameraView(below);

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



    private Map generateDemoMap() {
        Map map = new Map(new Coord(23,25));


        /*
        for (int i=0; i<23; i++) {
            for (int j=0; j<25; j++) {
                map.getTile(new Coord(i,j)).setTerrain(new Grass());
            }
        }*/


        //zone 1
        for(int i = 0; i < 8; i++){
            for(int j = 6; j < 18; j++){

                if(i == 0 || j == 6 || i == 7)
                    map.getTile(new Coord(i,j)).setTerrain(new Mountain());
                else
                    map.getTile(new Coord(i,j)).setTerrain(new Grass());
            }
        }
        map.getTile(new Coord(7,7)).setTerrain(new Grass());
        //map.getTile(new Coord(7,8)).setTerrain(new Grass());
        map.getTile(new Coord(7,14)).setTerrain(new Grass());
        map.getTile(new Coord(7,15)).setTerrain(new Grass());



        //zone 2
        for(int i = 0; i < 8; i++){
            for(int j = 18; j < 25; j++){
                if(i == 0 || i == 7 || j == 24)
                    map.getTile(new Coord(i,j)).setTerrain(new Mountain());
                else
                     map.getTile(new Coord(i,j)).setTerrain(new Grass());
            }
        }
        map.getTile(new Coord(7,20)).setTerrain(new Grass());
        map.getTile(new Coord(7,21)).setTerrain(new Grass());




        //zone 3
        for(int i = 8; i < 20; i++){
            for(int j = 0; j < 9; j++){
                if(i == 8 || i == 19 || j == 0 || j == 8)
                    map.getTile(new Coord(i,j)).setTerrain(new Mountain());
                else
                    map.getTile(new Coord(i,j)).setTerrain(new Grass());
            }
        }
        map.getTile(new Coord(8,7)).setTerrain(new Grass());
        map.getTile(new Coord(14,8)).setTerrain(new Grass());



        //zone 4
        for(int i = 8; i < 23; i++){
            for(int j = 9; j < 25; j++){
                if(i == 8 || i == 22 || j == 9 || j == 24)
                    map.getTile(new Coord(i,j)).setTerrain(new Mountain());
                else
                    map.getTile(new Coord(i,j)).setTerrain(new Grass());
            }
        }
        map.getTile(new Coord(8,14)).setTerrain(new Grass());
        map.getTile(new Coord(8,15)).setTerrain(new Grass());
        map.getTile(new Coord(14,9)).setTerrain(new Grass());
        map.getTile(new Coord(8,20)).setTerrain(new Grass());
        map.getTile(new Coord(8,21)).setTerrain(new Grass());



        return map;
    }


    private CameraViewManager generateDemoCV() {

        CameraViewManager cvm = new CameraViewManager(activeMap);
        //ZoomedStaticCameraView test = new ZoomedStaticCameraView(0,0,8,5);
        //cvm.addCameraView(test);

        ZoomedDynamicCameraView zone1 = new ZoomedDynamicCameraView(0,6,8,12);
        cvm.addCameraView(zone1);

        ZoomedStaticCameraView zone2 = new ZoomedStaticCameraView(0,18,8,7);
        cvm.addCameraView(zone2);

        ZoomedStaticCameraView zone3 = new ZoomedStaticCameraView(8,0,12,9);
        zone3.setMapViewObjectFactory(new DesertMapViewObjectFactory(zone3));
        cvm.addCameraView(zone3);

        ZoomedDynamicCameraView zone4 = new ZoomedDynamicCameraView(8,9,15,16);
        cvm.addCameraView(zone4);


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
                activeMap = generateMapBase();
                activeMap = populateTestMap(activeMap);
                activeCVM = generateTestCV();
                startingCoordinates = new Coord(2,2);
                return true;
            case "DEMO":
                activeMap = generateDemoMap();
                activeCVM = generateDemoCV();
                startingCoordinates = new Coord(2,8);
                return true;
            case "LOAD":
                activeMap = generateMapBase();
                activeMap = loadPopulate(activeMap);
                activeCVM = generateTestCV();

                startingCoordinates = new Coord(2,2);
                return true;
            default:
                System.out.println("Level: " + levelname + " not found");
                return false;
        }
    }
}
