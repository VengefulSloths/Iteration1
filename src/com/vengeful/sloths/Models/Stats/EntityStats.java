package com.vengeful.sloths.Models.Stats;

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
    protected int life; //life = maxHP
    protected int mana;
    protected int offensiveRating;
    protected int defensiveRating;
    protected int armorRating;

    protected int[] requiredLevelXP = {0, 10, 20, 40, 80, 160, 320, 640, 1280, 2560};
    protected int currentHealth;


    public EntityStats() {
        super();

        // Set defaults
        this.experience = 1;
        this.level = 1;
        this.livesLeft = 1;
        this.life = 10;

        this.currentHealth = life;

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

    private int calculateLife() {
        double factor = hardiness / 50.0;
        double levelFactor = level / 50.0;
        return life + ((int)(life * factor)) + ((int)(life * levelFactor));
    }

    private int calculateMana() {
        double factor = intellect / 50.0;
        double levelFactor = level / 50.0;
        return mana + ((int)(mana * factor)) + ((int)(mana * levelFactor));
    }

    private int calculateOffensiveRating() {
        double factor = strength / 50.0;
        double levelFactor = level / 50.0;
        // FACTOR IN EQUIPPED ARMOR!
        return offensiveRating + ((int)(offensiveRating * factor)) + ((int)(offensiveRating * levelFactor));
    }

    private int calculateDefensiveRating() {
        double factor = agility / 50.0;
        double levelFactor = level / 50.0;
        return defensiveRating + ((int)(defensiveRating * factor)) + ((int)(defensiveRating * levelFactor));
    }

    private int calculateArmorRating() {
        double factor = hardiness / 50.0;
        double levelFactor = level / 50.0;
        // FACTOR IN EQUIPPED ARMOR!
        return armorRating + ((int)(armorRating * factor)) + ((int)(armorRating * levelFactor));
    }

    public void levelUp() {
        level++;
    }

    public void updateStats(int strength, int agility, int intellect, int hardiness, int movement) {
        super.updateStats(strength, agility, intellect, hardiness, movement);

        updateStats();
    }

    public void updateXP(int xp){
        this.experience += xp;
    }

    public int getXP(){
        return this.experience;
    }

    public int getRequiredLevelXP(){
        return requiredLevelXP[this.level];
    }

    public void setCurrentHealth(int health){
        if((this.currentHealth + health) > this.life)
            this.currentHealth = this.life;
        else
            this.currentHealth += health;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public int getLevel(){
        return this.level;
    }

    public int getLivesLeft(){
        return this.livesLeft;
    }

    public void updateLivesLeft(int livesLeft){
        this.livesLeft += livesLeft;
    }

    public int getLife(){
        return this.life;
    }


    public String toString() {
        return this.strength + " " + this.agility + " " + this.intellect + " " + this.hardiness + " " + this.movement;
    }
}
