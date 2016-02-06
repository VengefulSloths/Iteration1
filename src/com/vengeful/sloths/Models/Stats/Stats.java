package com.vengeful.sloths.Models.Stats;

import com.vengeful.sloths.Models.ViewObservable;
import com.vengeful.sloths.View.Observers.ModelObserver;
import com.vengeful.sloths.View.Observers.StatsObserver;
import com.vengeful.sloths.Models.SaveLoad.Saveable;
import java.util.ArrayList;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Stats implements ViewObservable, Saveable{
    protected int strength;
    protected int agility;
    protected int intellect;
    protected int hardiness;
    protected int movement;
    protected ArrayList<StatsObserver> statsObservers;

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
        this.movement = 24;
        this.statsObservers = new ArrayList<>();
    }

    public Stats(int strength, int agility, int intellect, int hardiness, int movement) {
        this.strength = strength;
        this.agility = agility;
        this.intellect = intellect;
        this.hardiness = hardiness;
        this.movement = movement;
        this.statsObservers = new ArrayList<>();
    }

    public void updateStats(int strength, int agility, int intellect, int hardiness, int movement) {
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

    @Override
    public void registerObserver(ModelObserver modelObserver) {
        this.statsObservers.add((StatsObserver) modelObserver);
    }

    @Override
    public void deregisterObserver(ModelObserver modelObserver) {
        this.statsObservers.remove((StatsObserver) modelObserver);
    }

    public void saveMe() {
        System.out.println("Saving: " + this.toString());
    }

    public void alertObservers(){
        for(StatsObserver observer: statsObservers){
            observer.alertStatChanged(this);
        }

    }
}
