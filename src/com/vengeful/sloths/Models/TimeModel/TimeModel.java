package com.vengeful.sloths.Models.TimeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by John on 1/30/2016.
 */
public class TimeModel {

    private ArrayList<TimedObject> alertables;

    public TimeModel(){
        alertables = new ArrayList<TimedObject>();
    }
    //decremenets timedobjects and calls alterables execute when ticks == 0
    public void tick(){
        for (TimedObject timedObject : alertables){
            if(timedObject.decrement()){
                timedObject.execute();
                alertables.remove(timedObject);
            }
        }
    }

    public void registerAlertable(Alertable alertable, int ticks){
        alertables.add(new TimedObject(alertable, ticks));
    }

}
