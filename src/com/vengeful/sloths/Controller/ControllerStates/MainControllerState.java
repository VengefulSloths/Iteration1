package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.MainController;

/**
 * Created by John on 1/30/2016.
 */
public abstract class MainControllerState {


    protected MainController mainController;

    public MainControllerState(MainController m) {
        this.mainController = m;
    }
    //add TimeController

    public void continuousFunction(){};

    public abstract boolean handleIKey();
    public abstract boolean handleEKey();
    public abstract boolean handleESCKey();
    public abstract boolean handle1Key();
    public abstract boolean handle2Key();
    public abstract boolean handle3Key();
    public abstract boolean handle4Key();
    public abstract boolean handle6Key();
    public abstract boolean handle7Key();
    public abstract boolean handle8Key();
    public abstract boolean handle9Key();
    public abstract boolean handle5Key();
    public abstract boolean handleDKey();


    public abstract void handleRelease1Key();
    public abstract void handleRelease2Key();
    public abstract void handleRelease3Key();
    public abstract void handleRelease4Key();
    public abstract void handleRelease6Key();
    public abstract void handleRelease7Key();
    public abstract void handleRelease8Key();
    public abstract void handleRelease9Key();
    public abstract void handleRelease5Key();
}
