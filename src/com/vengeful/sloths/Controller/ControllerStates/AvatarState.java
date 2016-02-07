package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Utility.Direction;

/**
 * Created by John on 1/30/2016.
 */
public class AvatarState extends MainControllerState{
    private boolean movingState = false;
    private Direction directionState;

    public void setMovingState(boolean b)
    {
        movingState = b;
    }
    public void setDirectionState(Direction directionState) {
        this.directionState = directionState;
    }

    public AvatarState(MainController mainController) {
        super(mainController);
        directionState = mainController.getAvatar().getFacingDirection();
    }

    @Override
    public void continuousFunction()
    {
        if(movingState)
        {
            mainController.getAvatar().move(directionState);
        }
        else
        {
            //do nothing or add other cases later
        }
    }

    @Override
    public boolean handleIKey() {
        System.out.println("changing to inventory state");
        mainController.setInventoryState();
        return true;
    }

    @Override
    public boolean handleEKey() {
        System.out.println("changing to equip");
        mainController.setEquipmentState();
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
       // mainController.getAvatar().move(Direction.SW);
        setDirectionState(Direction.SW);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle2Key() {
        //mainController.getAvatar().move(Direction.S);
        setDirectionState(Direction.S);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle3Key() {
        //mainController.getAvatar().move(Direction.SE);
        setDirectionState(Direction.SE);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle4Key() {
        //mainController.getAvatar().move(Direction.W);
        setDirectionState(Direction.W);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle6Key() {
        //mainController.getAvatar().move(Direction.E);
        setDirectionState(Direction.E);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle7Key() {
        //mainController.getAvatar().move(Direction.NW);
        setDirectionState(Direction.NW);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle8Key() {
       // mainController.getAvatar().move(Direction.N);
        setDirectionState(Direction.N);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle9Key() {
        //mainController.getAvatar().move(Direction.NE);
        setDirectionState(Direction.NE);
        setMovingState(true);
        return true;
    }

    @Override
    public boolean handle5Key() {

        return false;
    }

    @Override
    public boolean handleDKey() {
        return false;
    }

    public void handleRelease1Key(){
        if(directionState == Direction.SW)
        {
            setMovingState(false);
        }
    }
    public void handleRelease2Key(){
        if(directionState == Direction.S)
        {
            setMovingState(false);
        }
    }
    public void handleRelease3Key(){
        if(directionState == Direction.SE)
        {
            setMovingState(false);
        }
    }
    public void handleRelease4Key(){
        if(directionState == Direction.W)
        {
            setMovingState(false);
        }
    }
    public void handleRelease6Key(){
        if(directionState == Direction.E)
        {
            setMovingState(false);
        }
    }
    public void handleRelease7Key(){
        if(directionState == Direction.NW)
        {
            setMovingState(false);
        }
    }
    public void handleRelease8Key(){
        if(directionState == Direction.N)
        {
            setMovingState(false);
        }
    }
    public void handleRelease9Key(){
        if(directionState == Direction.NE)
        {
            setMovingState(false);
        }
    }
    public void handleRelease5Key(){}

    public String toString(){
        return "AvatarState";
    }
}
