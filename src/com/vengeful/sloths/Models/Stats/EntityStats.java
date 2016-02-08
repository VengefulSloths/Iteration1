package com.vengeful.sloths.Models.Stats;

import com.vengeful.sloths.Models.SaveLoad.SaveManager;

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

    protected int maxLives;
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
    protected int currentMana;


    public EntityStats() {
        super();

        this.maxLives=3;
        // Set defaults
        this.experience = 0;
        this.level = 1;
        this.livesLeft = maxLives;
        this.life = 11;
        this.mana = 11;

        this.currentHealth = life;
        this.currentMana = mana;

        updateStats();
    }

    private void updateStats() {
        //livesLeft
        //experience
        //int oldLife = life;
        life = calculateLife();
        //this.setCurrentHealth( currentHealth + (life - oldLife));
        mana = calculateMana();
        offensiveRating = calculateOffensiveRating();
        defensiveRating = calculateDefensiveRating();
        armorRating = calculateArmorRating();

    }

    private int calculateLife() {
        double factor = hardiness / 5.0;
        double levelFactor = level / 5.0;
        return 10 + ((int)(1 * factor)) + ((int)(1 * levelFactor));
    }

    private int calculateMana() {
        double factor = intellect / 5.0;
        double levelFactor = level / 5.0;
        return 10 + ((int)(1 * factor)) + ((int)(1 * levelFactor));
    }

    private int calculateOffensiveRating() {
        double factor = strength / 5.0;
        double levelFactor = level / 5.0;
        // FACTOR IN EQUIPPED ARMOR!
        return 1 + ((int)(1 * factor)) + ((int)(1 * levelFactor));
    }

    private int calculateDefensiveRating() {
        double factor = agility / 5.0;
        double levelFactor = level / 5.0;
        return 1 + ((int)(1 * factor)) + ((int)(1 * levelFactor));
    }

    private int calculateArmorRating() {
        double factor = hardiness / 5.0;
        //System.out.Println("this is hardiness" + hardiness);
        double levelFactor = level / 5.0;
        // FACTOR IN EQUIPPED ARMOR!
        return 1 + ((int)(1 * factor)) + ((int)(1 * levelFactor));
    }

    public void levelUp() {
        level++;
    }

    public void updateStats(BaseStats stats) {
        super.updateStats(stats.getStrength(), stats.getAgility(), stats.getIntellect(), stats.getHardiness(), stats.getMovement());
        updateStats();
    }
    public void revertStats(BaseStats stats) {
        super.revertStats(stats.getStrength(), stats.getAgility(), stats.getIntellect(), stats.getHardiness(), stats.getMovement());
        updateStats();
    }

    public void updateXP(int xp){
        this.experience += xp;
    }

    public int getXP(){
        return this.experience;
    }

    public int getRequiredLevelXP(){
        return (int)(10.1 * Math.pow(1.1, (double)this.level));
    }

    public void setCurrentHealth(int health){
        if((this.currentHealth + health) > this.life) {
            this.currentHealth = this.life;
        }
        else
            this.currentHealth += health;
    }

    public void setCurrentHealthFromLoad(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }

    public int getLevel(){
        return this.level;
    }

    public int getMaxLives() {
        return maxLives;
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

    public int getMana() {
        return mana;
    }

    public int getOffensiveRating() {
        return offensiveRating;
    }

    public int getDefensiveRating() {
        return defensiveRating;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public int getExperience() {
        return experience;
    }

    public int getCurrentMana(){return currentMana;}

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setOffensiveRating(int offensiveRating) {
        this.offensiveRating = offensiveRating;
    }

    public void setDefensiveRating(int defensiveRating) {
        this.defensiveRating = defensiveRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }

    public String toString() {
        return this.strength + " " + this.agility + " " + this.intellect + " " + this.hardiness + " " + this.movement;
    }

    public void saveMe(SaveManager sm, int ws){
        sm.writeClassLine(ws, "EntityStats");
        sm.writeVariableLine(ws, "livesLeft", ""+livesLeft ,false);
        sm.writeVariableLine(ws, "experience", ""+experience ,false);
        sm.writeVariableLine(ws, "level", ""+level ,false);
        sm.writeVariableLine(ws, "life", ""+life ,false);
        sm.writeVariableLine(ws, "mana", ""+mana ,false);
        sm.writeVariableLine(ws, "offensiveRating", ""+offensiveRating ,false);
        sm.writeVariableLine(ws, "defensiveRating", ""+defensiveRating ,false);
        sm.writeVariableLine(ws, "armorRating", ""+armorRating ,false);
        sm.writeVariableLine(ws, "currentHealth", ""+currentHealth ,false);
        super.saveMe(sm,ws);
    }

}
