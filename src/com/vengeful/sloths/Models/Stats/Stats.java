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

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getHardiness() {
        return hardiness;
    }

    public int getMovement() {
        return movement;
    }

    public Stats() {
        this.strength = 5;
        this.agility = 5;
        this.intellect = 5;
        this.hardiness = 5;
        this.movement = 1;
    }

    public Stats(int strength, int agility, int intellect, int hardiness, int movement) {
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.hardiness = hardiness;
        this.movement = movement;
    }

    public void increaseStats(int strength, int agility, int intellect, int hardiness, int movement) {
        this.strength += strength;
        this.agility += agility;
        this.intellect += intellect;
        this.hardiness += hardiness;
        this.movement += movement;
    }

    public void setStats(int str, int agil, int intel, int hardi, int move){
        this.strength = str;
        this.agility = agil;
        this.intellect = intel;
        this.hardiness = hardi;
        this.movement = move;
    }

}
