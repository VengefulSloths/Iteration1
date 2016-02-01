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

    //inputRunnable inputThread = null;
    Thread thread = null;

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Input handled Mother Fucker");
        //System.out.println(System.currentTimeMillis() + "keypressed");
        if(thread == null){
            System.out.println("blooop");
            thread = new Thread(new inputRunnable(e));
            thread.start();
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        if(thread != null){
            System.out.println("beeeeep");
            thread.interrupt();
            thread = null;
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        //
    }

    class inputRunnable implements Runnable{
        private KeyEvent e;
        private boolean isRunning = true;
        public inputRunnable(KeyEvent e){
            this.e = e;
        }
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    mainController.dispatchKey(e.getKeyCode());
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }

        public void stop(){
            isRunning = false;
        }
    }
}
