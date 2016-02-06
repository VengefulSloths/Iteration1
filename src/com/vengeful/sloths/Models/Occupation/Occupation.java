package com.vengeful.sloths.Models.Occupation;

import com.vengeful.sloths.Models.SaveLoad.Saveable;
import com.vengeful.sloths.Models.Stats.EntityStats;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Occupation implements Saveable {

    public Occupation() {

    }

    public abstract void init(EntityStats entityStats);

    public void levelUp(EntityStats eStats) {
        eStats.levelUp();
    }

    public void Saveme(){
        return;
    }

}
