package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Map.Map;

import java.util.ArrayList;

/**
 * Created by alexs on 1/31/2016.
 */
public class CameraViewManager {
    private ArrayList<CameraView> cameraViewList;
    private Map map;
    public CameraViewManager(Map map) {
        cameraViewList = new ArrayList<CameraView>();
        this.map = map;
    }
    public CameraView getCameraView(int x, int y) {
        for (CameraView cv: cameraViewList) {
            if (x >= cv.getX() &&
                x< cv.getX() + cv.getWidth() &&
                x >= cv.getX() &&
                x< cv.getX() + cv.getWidth()) {
                return cv;
            }
        }
        System.out.println("COULD NOT FIND CAMERA VIEW FOR: " + x + ", " + y);
        return null;
    };
    public boolean addCameraView(CameraView cv) {
        cv.setMap(map);
        cameraViewList.add(cv);
        return true;
    }
}
