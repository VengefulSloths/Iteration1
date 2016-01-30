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

}
