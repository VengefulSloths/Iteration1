package com.vengeful.sloths.Models.Stats;

import com.vengeful.sloths.Models.Entity.Entity;

/**
 * Created by zach on 1/30/16.
 */
public class EntityStats extends Stats {
    protected int livesLeft;
    protected int experience;
    protected int level;
    protected int life;
    protected int mana;
    protected int offensiveRating;
    protected int defensiveRating;
    protected int armorRating;

    public EntityStats() {
        super();
    }

    private void updateStats() {

    }
}
