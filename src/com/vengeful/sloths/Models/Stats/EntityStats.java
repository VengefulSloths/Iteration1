package com.vengeful.sloths.Models.Stats;

import com.vengeful.sloths.Models.Entity.Entity;

/**
 * Created by zach on 1/30/16.
 */
public class EntityStats extends Stats {

    // Base stats:
    //  int strength;
    //  int agility;
    //  int intellect;
    //  int hardiness;
    //  int movement;

    protected int livesLeft;
    protected int experience;
    protected int level;
    // HP stat
    protected int life;
    protected int mana;
    protected int offensiveRating;
    protected int defensiveRating;
    protected int armorRating;

    public EntityStats() {
        super();

        // Set defaults
        this.experience = 1;
        this.level = 1;

        this.livesLeft = 1;

        this.life = 10;

        updateStats();
    }

    private void updateStats() {
        //livesLeft
        //experience

        life = calculateLife();
        mana = calculateMana();
        offensiveRating = calculateOffensiveRating();
        defensiveRating = calculateDefensiveRating();
        armorRating = calculateArmorRating();

    }

    public int calculateLife() {
        double factor = hardiness / 50.0;
        double levelFactor = level / 50.0;
        return life + ((int)(life * factor)) + ((int)(life * levelFactor));
    }

    public int calculateMana() {
        double factor = intellect / 50.0;
        double levelFactor = level / 50.0;
        return mana + ((int)(mana * factor)) + ((int)(mana * levelFactor));
    }

    public int calculateOffensiveRating() {
        double factor = strength / 50.0;
        double levelFactor = level / 50.0;
        // FACTOR IN EQUIPPED ARMOR!
        return offensiveRating + ((int)(offensiveRating * factor)) + ((int)(offensiveRating * levelFactor));
    }

    public int calculateDefensiveRating() {
        double factor = agility / 50.0;
        double levelFactor = level / 50.0;
        return defensiveRating + ((int)(defensiveRating * factor)) + ((int)(defensiveRating * levelFactor));
    }

    public int calculateArmorRating() {
        double factor = hardiness / 50.0;
        double levelFactor = level / 50.0;
        // FACTOR IN EQUIPPED ARMOR!
        return armorRating + ((int)(armorRating * factor)) + ((int)(armorRating * levelFactor));
    }

    public void levelUp() {
        level++;
    }

    public void increaseStats(int strength, int agility, int intellect, int hardiness, int movement) {
        super.increaseStats(strength, agility, intellect, hardiness, movement);

        updateStats();
    }

    public String toString() {
        return this.strength + " " + this.agility + " " + this.intellect + " " + this.hardiness + " " + this.movement;
    }
}
