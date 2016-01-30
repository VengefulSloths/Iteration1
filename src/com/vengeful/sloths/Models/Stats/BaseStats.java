package com.vengeful.sloths.Models.Stats;

/**
 * Created by zach on 1/30/16.
 */
public class BaseStats extends Stats {

    public BaseStats() {

        super();
    }

    public void setStats(int str, int agil, int intel, int hardi, int move){
        this.strength = str;
        this.agility = agil;
        this.intellect = intel;
        this.hardiness = hardi;
        this.movement = move;
    }
}
