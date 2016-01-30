package com.vengeful.sloths.Controller;

import com.vengeful.sloths.Controller.ControllerStates.AvatarState;
import com.vengeful.sloths.Controller.ControllerStates.MainControllerState;

import java.awt.event.KeyEvent;

/**
 * Created by John on 1/30/2016.
 */
public class MainController {

    private MainControllerState state;
    private InputHandler inputHandler;
    private Screen screen;

    public MainController(){
        inputHandler = new InputHandler(this);

        Screen screen = new Screen();
        screen.setVisible(true);
        screen.addKeyListener(inputHandler);
        screen.start();
        this.state = new AvatarState(this);
    }

    public boolean dispatchKey(int key){

        switch(key){
            case KeyEvent.VK_I :
                System.out.println("Opening the Inventory");
                state.handleIKey();
                break;
            default: System.out.println("key not supported (WTF ARE U EVEN DOIN U SCRUB???)");
        }

        return true;
    }



}
