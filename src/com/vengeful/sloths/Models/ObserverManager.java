package com.vengeful.sloths.Models;

import com.vengeful.sloths.View.AreaView.ModelObserver;
import com.vengeful.sloths.View.AreaView.ProxyObserver;

import java.util.HashMap;

/**
 * Created by alexs on 1/31/2016.
 */
public class ObserverManager {
    private static ObserverManager instance;
    private HashMap<ModelObserver, ProxyObserver> observers;
    private ObserverManager() {
        observers = new HashMap<ModelObserver, ProxyObserver>();
    }
    static public ObserverManager instance() {
        if (instance == null) {
            instance = new ObserverManager();
        }
        return instance;
    }
    public void addProxyObserver(ProxyObserver proxyObserver) {
        observers.put(proxyObserver.getModelObserver(), proxyObserver);
    }
    public boolean flagForDelete(ModelObserver modelObserver) {
        if (observers.containsKey(modelObserver)) {
            observers.get(modelObserver).setDeleteFlag(true);
            return true;
        } else return false;
    }
}
