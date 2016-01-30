package com.vengeful.sloths.Controller;

import com.vengeful.sloths.Controller.ControllerStates.AvatarState;
import com.vengeful.sloths.Controller.ControllerStates.InventoryState;
import com.vengeful.sloths.Controller.ControllerStates.MainControllerState;
import com.vengeful.sloths.Controller.ControllerStates.MenuState;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.TimeModel.TimeController;

import java.awt.event.KeyEvent;

/**
 * Created by John on 1/30/2016.
 */
public class MainController {

    private Avatar player;
    private MainControllerState state;
    private InputHandler inputHandler;
    private Screen screen;

    private AvatarState avatarState;
    private InventoryState inventoryState;
    private MenuState menuState;

    public MainController(Avatar player){

        this.player = player;

        avatarState = new AvatarState(this);
        inventoryState = new InventoryState(this);
        menuState = new MenuState(this);

        inputHandler = new InputHandler(this);

        Screen screen = new Screen();
        screen.setVisible(true);
        screen.addKeyListener(inputHandler);
        screen.start();
        this.state = avatarState;
    }

    public boolean dispatchKey(int key){

        switch(key){
            case KeyEvent.VK_I :
                state.handleIKey();
                break;
            case KeyEvent.VK_E :
                state.handleEKey();
                break;
            case KeyEvent.VK_ESCAPE :
                state.handleESCKey();
                break;
            case KeyEvent.VK_1 :
                state.handle1Key();
                break;
            case KeyEvent.VK_2 :
                state.handle2Key();
                break;
            case KeyEvent.VK_3 :
                state.handle3Key();
                break;
            case KeyEvent.VK_4 :
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

            default: System.out.println("key not supported (WTF ARE U EVEN DOIN U SCRUB???)");
        }

        return true;
    }

    public void setAvatarState(){
        this.state = this.avatarState;
    }

    public void setInventoryState(){
        this.state = this.inventoryState;
    }

    public void setMenuState(){
        this.state = menuState;
    }



}
