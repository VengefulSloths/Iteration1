package com.vengeful.sloths.Models.Entity;

/**
 * Created by zach on 1/30/16.
 */
public class Avatar extends Entity {

    public Avatar() {
        super();
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

    }

    public void gainXP(int xp) {

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
