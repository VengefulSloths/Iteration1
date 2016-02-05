package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.ControllerStates.MainControllerState;
import com.vengeful.sloths.Controller.MainController;

/**
 * Created by qianwen on 2/5/16.
 */
public class EquipmentState extends MainControllerState{

    public EquipmentState(MainController m){
        super(m);
    }


    @Override
    public boolean handleIKey() {
        return false;
    }

    @Override
    public boolean handleEKey() {
        mainController.setAvatarState();
        return true;
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

    @Override
    public boolean handleDKey() {
        return false;
    }

    @Override
    public void handleRelease1Key() {

    }

    @Override
    public void handleRelease2Key() {

    }

    @Override
    public void handleRelease3Key() {

    }

    @Override
    public void handleRelease4Key() {

    }

    @Override
    public void handleRelease6Key() {

    }

    @Override
    public void handleRelease7Key() {

    }

    @Override
    public void handleRelease8Key() {

    }

    @Override
    public void handleRelease9Key() {

    }

    @Override
    public void handleRelease5Key() {

    }
}
