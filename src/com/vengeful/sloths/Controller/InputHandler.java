package com.vengeful.sloths.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by John on 1/30/2016.
 */
public class InputHandler implements KeyListener{

    private MainController mainController;

    public InputHandler(MainController mainController){
        this.mainController = mainController;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("got me fucked up");
        mainController.dispatchKey(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){

    }

}
