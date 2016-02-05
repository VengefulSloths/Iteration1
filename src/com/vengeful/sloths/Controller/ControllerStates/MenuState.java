package com.vengeful.sloths.Controller.ControllerStates;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.View.MainMenuView.MainMenuView;
import com.vengeful.sloths.View.MainMenuView.MenuControllable;
import com.vengeful.sloths.View.MainMenuView.MenuView;

/**
 * Created by John on 1/30/2016.
 */
public class MenuState extends MainControllerState {

    private MenuControllable target;

    public MenuState(MainController m){
        super(m);
    }

    public void setTarget(MenuControllable target) {
        this.target = target;
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
        target.back();
        return true;    }

    @Override
    public boolean handle1Key() {
        return false;
    }

    @Override
    public boolean handle2Key() {
        target.cursorDown();
        return true;
    }

    @Override
    public boolean handle5Key() {
        target.select();
        return true;
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
        target.cursorUp();
        return true;
    }

    @Override
    public boolean handle9Key() {
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
