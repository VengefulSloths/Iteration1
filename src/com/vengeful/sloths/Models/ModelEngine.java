package com.vengeful.sloths.Models;

import com.vengeful.sloths.Models.TimeModel.TimeController;

/**
 * Created by John on 1/30/2016.
 */
public class ModelEngine implements Runnable {

    private TimeController timeController;

    public ModelEngine(){
        timeController = new TimeController();

    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Model Tick");
            timeController.tick();

        }
    }

    public void start() {
        new Thread(this).start();
    }
}
