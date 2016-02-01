package com.vengeful.sloths.Utility;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.Obstacle;
import com.vengeful.sloths.Models.Map.Terrains.Mountain;
import com.vengeful.sloths.Models.Map.Terrains.Water;
import com.vengeful.sloths.View.AreaView.CameraView;
import com.vengeful.sloths.View.AreaView.CameraViewManager;
import com.vengeful.sloths.View.AreaView.StaticCameraView;

/**
 * Created by alexs on 1/31/2016.
 */
public class LevelFactory {
    private Map activeMap;
    private CameraViewManager activeCVM;
    private Coord startingCoordinates;

    private Map generateTestMap() {
        Map map = new Map(new Coord(15,7));
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
        return map;
    }
    private CameraViewManager generateTestCV() {
        CameraViewManager cvm = new CameraViewManager(activeMap);
        cvm.addCameraView(new StaticCameraView(0,0,5,7));
        cvm.addCameraView(new StaticCameraView(5,0,10,7));
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
