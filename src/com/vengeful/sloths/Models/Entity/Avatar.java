package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.Occupation.Occupation;
import com.vengeful.sloths.Models.Occupation.Smasher;
import com.vengeful.sloths.Models.Stats.EntityStats;

/**
 * Created by zach on 1/30/16.
 */
public class Avatar extends Entity {


    public Avatar(String occupationString, EntityStats entityStats) {
        super(occupationString, entityStats);
    }

    public boolean equip(int itemIndex) {
        return false;
    }

    public boolean unequip(int itemIndex) {
        return false;
    }

    public boolean drop(int itemIndex) {
        return false;
    }

    public void levelUp() {
        // Let occupation know level is increased, then levelUp occ and base stats
        System.out.println("Stats were: " + entityStats.toString());

        occupation.levelUp(entityStats);


        System.out.println("Stats were: " + entityStats.toString());
    }

    public void gainXP(int xp) {
        // if currXp > threshold
        // levelUp();

    }

    public void gainHealth(int health) {

    }

    public void takeDamage(int damage) {


    }

    public void die() {

    }

    // @TODO: Don't have Item object yet
    //  public void updateStats(Item item) {}


}
