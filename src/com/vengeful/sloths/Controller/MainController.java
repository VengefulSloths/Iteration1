package com.vengeful.sloths.Controller;

import com.vengeful.sloths.Controller.ControllerStates.MainControllerState;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by John on 1/30/2016.
 */
public class MainController {

    private MainControllerState state;
    private InputHandler inputHandler;

    public MainController(){
        inputHandler = new InputHandler();
        
    }

    public boolean dispatchKey(int key){

        switch(key){
            case KeyEvent.VK_I :
                System.out.println("Opening the Inventory");

        }

        return true;
    }



}
