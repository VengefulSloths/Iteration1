package com.vengeful.sloths.Models.Stats;

import com.vengeful.sloths.Models.SaveLoad.SaveManager;

/**
 * Created by zach on 1/30/16.
 */
public class BaseStats extends Stats {

    public BaseStats() {
        super();
    }

    public BaseStats(int str, int agil, int intel, int hardi, int move) {
        super(str, agil, intel, hardi, move);
    }

    public void saveMe(SaveManager sm, int ws){
        sm.writeClassLine(ws,"BaseStats");
        super.saveMe(sm,ws);
        //sm.writeCloseBracket(ws);
    }

}
