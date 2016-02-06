package com.vengeful.sloths.Models.Occupation;

import com.vengeful.sloths.Models.Stats.EntityStats;

/**
 * Created by zach on 1/30/16.
 */
public class Sneak extends Occupation {

    public Sneak() {

    }

    @Override
    public void init(EntityStats entityStats) {
        entityStats.updateStats(0, 10, 0, 0, 0);
    }

    @Override
    public void levelUp(EntityStats eStats) {
        super.levelUp(eStats);

        eStats.updateStats(1, 2, 1, 1, 0);
    }
    public void saveMe() {
        return;
    }
}
