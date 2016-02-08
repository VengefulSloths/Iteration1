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
        ////System.out.Println("Input handled Mother Fucker");
        ////System.out.Println(System.currentTimeMillis() + "keypressed");

        // Only spin a inputRunnable Thread on AvatarState
        /*if (mainController.getState().toString() == "AvatarState") {
            if (thread == null) {
                //System.out.Println("blooop");
                thread = new Thread(new inputRunnable(e));
                thread.start();
            }
        } else {*/
            mainController.dispatchKey(e.getKeyCode());
        //}
    }
    @Override
    public void keyReleased(KeyEvent e){
       /*if(thread != null){
            //System.out.Println("beeeeep");
            thread.interrupt();
            thread = null;
        }*/
        mainController.dispatchReleaseKey(e.getKeyCode());
    }

    @Override
    public void keyTyped(KeyEvent e){
        //
    }

   /* class inputRunnable implements Runnable{
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
                //System.out.Println(e);
            }
        }

        public void stop(){
            isRunning = false;
        }
    }*/
}
