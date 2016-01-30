package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.MainController;

/**
 * Created by John on 1/30/2016.
 */
public class AvatarState extends MainControllerState{

    public AvatarState(MainController mainController) {
        super(mainController);
    }

    @Override
    public boolean handleIKey() {
        System.out.println("HANDLING THE I KEY !!!!!11!!1!1!!!ONE!!!111!");
        return false;
    }

    @Override
    public boolean handleEKey() {
        return false;
    }

    @Override
    public boolean handleESCKey() {
        return false;
    }

    @Override
    public boolean handle1Key() {
        return false;
    }

    @Override
    public boolean handle2Key() {
        return false;
    }

    @Override
    public boolean handle3Key() {
        return false;
    }

    @Override
    public boolean handle4Key() {
        return false;
    }

    @Override
    public boolean handle6Key() {
        return false;
    }

    @Override
    public boolean handle7Key() {
        return false;
    }

    @Override
    public boolean handle8Key() {
        return false;
    }

    @Override
    public boolean handle9Key() {
        return false;
    }

    @Override
    public boolean handle5Key() {
        return false;
    }
}
