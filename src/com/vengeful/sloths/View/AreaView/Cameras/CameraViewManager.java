package com.vengeful.sloths.View.AreaView.Cameras;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.View.Observers.ProxyEntityObserver;
import com.vengeful.sloths.Models.Entity.*;

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
    public CameraView getCameraView(int x, int y, Entity player) {
        for (CameraView cv: cameraViewList) {
            if (x >= cv.getX() &&
                x< cv.getX() + cv.getWidth() &&
                y >= cv.getY() &&
                y< cv.getY() + cv.getHeight()) {
                //set up proxy observer
                //register the proxy with player
                //add the proxy to manager
                //Make sure CameraView is not registered twice

                //Registers current CameraView to listen to Entity
                ProxyEntityObserver peo = new ProxyEntityObserver(cv, player);
                ObserverManager.instance().addProxyObserver(peo);

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
