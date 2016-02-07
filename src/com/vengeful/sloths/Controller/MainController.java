package com.vengeful.sloths.Controller;

import com.vengeful.sloths.Controller.ControllerStates.*;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.TimeModel.TimeController;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.EquipmentView.ListEquipmentView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.MainMenuView.MenuView;
import com.vengeful.sloths.View.ViewEngine;
import com.vengeful.sloths.View.ViewManager.DefaultViewManager;
import com.vengeful.sloths.View.ViewManager.ViewManager;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * Created by John on 1/30/2016.
 */
public class MainController {

    private Avatar player;
    private Inventory inventory;
    private MainControllerState state;
    private InputHandler inputHandler;
    private Screen screen;
    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }


    //These two may need to come together soon
    private ViewManager viewManager;

    private AvatarState avatarState;
    private InventoryState inventoryState;
    private MenuState menuState;
    private EquipmentState equipmentState;


    //Setting the menu view through the constructor is probably not final
    public MainController( JFrame jframe){

        System.out.println("in the maincontroller");

        //avatarState = new AvatarState(this);
        //inventoryState = new InventoryState(this);
        menuState = new MenuState(this);
        //equipmentState = new EquipmentState(this);

        inputHandler = new InputHandler(this);
        jframe.addKeyListener(inputHandler);

        //this.setAvatarState();
    }
    public MainController(Avatar player, JFrame jframe, ViewManager vm){

        this.player = player;
        System.out.println("in the maincontroller");

        this.inventory = player.getInventory();
        this.viewManager = vm;
        avatarState = new AvatarState(this);
        inventoryState = new InventoryState(this);
        menuState = new MenuState(this);
        equipmentState = new EquipmentState(this);

        inputHandler = new InputHandler(this);
        jframe.addKeyListener(inputHandler);

        this.setAvatarState();
    }

    public DefaultViewManager getDefaultViewManager() {
        return (DefaultViewManager)this.viewManager;
    }

    public MainControllerState getState() {
        return this.state;
    }

    public void continuousFunction(){state.continuousFunction();}

    public boolean dispatchKey(int key){
        //System.out.println(state.getClass());
        switch(key){
            case KeyEvent.VK_I :
                state.handleIKey();
                break;
            case KeyEvent.VK_E :
                state.handleEKey();
                break;
            case KeyEvent.VK_D :
                state.handleDKey();
                state.handle6Key(); //for wasd movement support
                break;
            case KeyEvent.VK_ESCAPE :
                state.handleESCKey();
                break;
            case KeyEvent.VK_1 :
                state.handle1Key();
                break;
            case KeyEvent.VK_2 :
            case KeyEvent.VK_S:
                state.handle2Key();
                break;
            case KeyEvent.VK_3 :
                state.handle3Key();
                break;
            case KeyEvent.VK_4 :
            case KeyEvent.VK_A:
                state.handle4Key();
                break;
            case KeyEvent.VK_5 :
                state.handle5Key();
                break;
            case KeyEvent.VK_6 :
                state.handle6Key();
                break;
            case KeyEvent.VK_7 :
                state.handle7Key();
                break;
            case KeyEvent.VK_8 :
                state.handle8Key();
                break;
            case KeyEvent.VK_9 :
                state.handle9Key();
                break;
            case KeyEvent.VK_NUMPAD1 :
                state.handle1Key();
                break;
            case KeyEvent.VK_NUMPAD2 :
                state.handle2Key();
                break;
            case KeyEvent.VK_NUMPAD3 :
                state.handle3Key();
                break;
            case KeyEvent.VK_NUMPAD4 :
                state.handle4Key();
                break;
            case KeyEvent.VK_NUMPAD5 :
                state.handle5Key();
                break;
            case KeyEvent.VK_NUMPAD6 :
                state.handle6Key();
                break;
            case KeyEvent.VK_NUMPAD7 :
                state.handle7Key();
                break;
            case KeyEvent.VK_NUMPAD8 :
            case KeyEvent.VK_W:
                state.handle8Key();
                break;
            case KeyEvent.VK_NUMPAD9 :
                state.handle9Key();
                break;
            default: //System.out.println("key not supported (WTF ARE U EVEN DOIN U SCRUB???)");
        }

        return true;
    }

    public void dispatchReleaseKey(int key)
    {
        switch(key){
            case KeyEvent.VK_1 :
            case KeyEvent.VK_NUMPAD1 :
                state.handleRelease1Key();
                break;
            case KeyEvent.VK_2 :
            case KeyEvent.VK_NUMPAD2:
            case KeyEvent.VK_S:
                state.handleRelease2Key();
                break;
            case KeyEvent.VK_3 :
            case KeyEvent.VK_NUMPAD3:
                state.handleRelease3Key();
                break;
            case KeyEvent.VK_4 :
            case KeyEvent.VK_NUMPAD4:
            case KeyEvent.VK_A:
                state.handleRelease4Key();
                break;
            case KeyEvent.VK_5 :
            case KeyEvent.VK_NUMPAD5:
                state.handleRelease5Key();
                break;
            case KeyEvent.VK_6 :
            case KeyEvent.VK_NUMPAD6:
            case KeyEvent.VK_D:
                state.handleRelease6Key();
                break;
            case KeyEvent.VK_7 :
            case KeyEvent.VK_NUMPAD7:
                state.handleRelease7Key();
                break;
            case KeyEvent.VK_8 :
            case KeyEvent.VK_NUMPAD8:
            case KeyEvent.VK_W:
                state.handleRelease8Key();
                break;
            case KeyEvent.VK_9 :
            case KeyEvent.VK_NUMPAD9:
                state.handleRelease9Key();
                break;
            default: //System.out.println("key not supported (WTF ARE U EVEN DOIN U SCRUB???)");
        }

    }

    public void setAvatarState(){
        viewManager.selectAreaView();
        this.state = this.avatarState;
    }

    public void setInventoryState(){
        int itemListSize = ((ListInventoryView) this.inventoryState.getInventoryView()).manager.getItemListSize();
        if(itemListSize != 0)
            ((ListInventoryView)this.inventoryState.getInventoryView()).setSelected(((ListInventoryView)this.inventoryState.getInventoryView()).manager.getFromItemList(this.inventoryState.getInventoryIndex()));

        viewManager.selectInventoryView();
        this.state = this.inventoryState;
    }

    public void setEquipmentState(){

        int itemListSize = ((ListEquipmentView) this.equipmentState.getEquipmentView()).manager.getItemListSize();
        if(itemListSize != 0)
            ((ListEquipmentView)this.equipmentState.getEquipmentView()).setSelected(((ListEquipmentView)this.equipmentState.getEquipmentView()).manager.getFromItemList(this.equipmentState.getEquipmentIndex()));


        viewManager.selectEquipView();
        this.state = this.equipmentState;
    }


    public void setAvatar(Avatar avatar){
        this.player = avatar;
        this.inventory = this.player.getInventory();
        avatarState = new AvatarState(this);
        inventoryState = new InventoryState(this);
        equipmentState = new EquipmentState(this);
    }
    public void setViewManager(ViewManager vm){
        this.viewManager = vm;
    }
    //Yes this is hacky, I will work on it
    public MenuState getMenuState() {
        return this.menuState;
    }

    public void setMenuState() {
        this.state = this.menuState;
    }

    public Avatar getAvatar(){
        return this.player;
    }

    public Inventory getInventory() { return this.inventory; }





}
