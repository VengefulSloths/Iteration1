package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Utility.Direction;

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
        mainController.getAvatar().move(Direction.SW);
        return true;
    }

    @Override
    public boolean handle2Key() {
        mainController.getAvatar().move(Direction.S);
        return true;
    }

    @Override
    public boolean handle3Key() {
        mainController.getAvatar().move(Direction.SE);
        return true;
    }

    @Override
    public boolean handle4Key() {
        mainController.getAvatar().move(Direction.W);
        return true;
    }

    @Override
    public boolean handle6Key() {
        mainController.getAvatar().move(Direction.E);
        return true;
    }

    @Override
    public boolean handle7Key() {
        mainController.getAvatar().move(Direction.NW);
        return true;
    }

    @Override
    public boolean handle8Key() {
        mainController.getAvatar().move(Direction.N);
        return true;
    }

    @Override
    public boolean handle9Key() {
        mainController.getAvatar().move(Direction.NE);
        return true;
    }

    @Override
    public boolean handle5Key() {
        return false;
    }

    public String toString(){
        return "AvatarState";
    }
}
