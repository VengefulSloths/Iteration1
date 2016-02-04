package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.MainController;

/**
 * Created by John on 1/30/2016.
 */
public class MenuState extends MainControllerState {

    public MenuState(MainController m){
        super(m);
    }
    @Override
    public boolean handleIKey() {
        return false;
    }

    @Override
    public boolean handleEKey() {
        return false;
    }

    @Override
    public boolean handleESCKey() {
        mainController.setAvatarState();
        return true;    }

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

    @Override
    public boolean handleDKey() {
        return false;
    }

    public String toString() {
        return "MenuState";
    }

    public void handleRelease1Key(){
        mainController.getAvatar().setMoving(false);
    }
    public void handleRelease2Key(){}
    public void handleRelease3Key(){}
    public void handleRelease4Key(){}
    public void handleRelease6Key(){}
    public void handleRelease7Key(){}
    public void handleRelease8Key(){}
    public void handleRelease9Key(){}
    public void handleRelease5Key(){}
}
