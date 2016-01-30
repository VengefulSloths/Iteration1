package com.vengeful.sloths.Models.Stats;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Stats {
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int hardiness;
    protected int movement;

    public Stats() {
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
        this.hardiness = 5;
        this.movement = 1;
    }

    public void increaseStats(int strength, int agility, int intellect, int hardiness, int movement) {
        this.strength += strength;
        this.agility += agility;
        this.intellect += intellect;
        this.hardiness += hardiness;
        this.movement += movement;
    }

}
