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
        System.out.println("changing to inventory state");
        mainController.setInventoryState();
        return true;
    }

    @Override
    public boolean handleEKey() {
        System.out.println("chaning to equip, which is an inventory state?");
        mainController.setInventoryState();
        return true;
    }

    @Override
    public boolean handleESCKey() {
        System.out.println("switch to menu controller");
        mainController.setMenuState();
        return true;
    }

    @Override
    public boolean handle1Key() {
        //move SW
        System.out.println("move SW");
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
        //mainController.getAvatar().move(
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
