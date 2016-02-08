package com.vengeful.sloths.Models.Occupation;

import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Models.Stats.BaseStats;
import com.vengeful.sloths.Models.Stats.EntityStats;

/**
 * Created by zach on 1/30/16.
 */
public class Summoner extends Occupation {

    public Summoner() {

    }

    @Override
    public void init(EntityStats entityStats) {
        entityStats.updateStats(new BaseStats( 0, 0, 10, 0, 0));
    }

    @Override
    public void levelUp(EntityStats eStats) {
        super.levelUp(eStats);

        eStats.updateStats(new BaseStats(1, 1, 2, 1, 0));
    }
    public void saveMe(SaveManager sm, int ws) {
        super.saveMe(sm, ws);
        sm.writeVarValue("Summoner");
    }
}
