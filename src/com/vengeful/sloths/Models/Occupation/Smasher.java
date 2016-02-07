package com.vengeful.sloths.Models.Occupation;

import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Models.Stats.BaseStats;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.Stats.Stats;

/**
 * Created by zach on 1/30/16.
 */
public class Smasher extends Occupation {

    public Smasher() {

    }

    @Override
    public void init(EntityStats entityStats) {
        entityStats.updateStats(new BaseStats(10,0,0,0,0));
        entityStats.alertObservers();
    }

    @Override
    public void levelUp(EntityStats eStats) {
        super.levelUp(eStats);

        eStats.updateStats(new BaseStats(2, 1, 1, 1, 0));
    }

    public void saveMe(SaveManager sm, int ws) {
        sm.writeClassLine(ws, "Smasher");
        sm.writeCloseBracket(ws);
    }
}
