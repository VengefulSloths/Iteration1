package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.*;
import com.vengeful.sloths.Models.Occupation.Occupation;
import com.vengeful.sloths.Models.Occupation.Smasher;
import com.vengeful.sloths.Models.Stats.EntityStats;

/**
 * Created by zach on 1/30/16.
 */
public class Avatar extends Entity {

    private Inventory inventory;
    private Equipped equipped;

    public Avatar(String occupationString, EntityStats entityStats) {
        super(occupationString, entityStats);
        this.inventory = new Inventory();
        this.equipped = new Equipped();
    }

    public boolean equip(int itemIndex) {

        try {
            InventoryItem i = this.inventory.getItem(itemIndex);
            if(i instanceof Hat){
                this.equipped.setHat((Hat)i);
            }else if(i instanceof Sword){
                this.equipped.setSword((Sword)i);
            }

            this.inventory.removeItem(i);

        } catch(Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public boolean unequip(InventoryItem item) {
        if(item instanceof Hat){
            this.equipped.setHat(null);
        }else if(item instanceof Sword){
            this.equipped.setSword(null);
        }else
            return false;

        this.inventory.addItem(item);
        return true;
    }

    public boolean drop(int itemIndex) {
        //Get Tile from map
        //Try to drop on tile
            //Need to create Takeable item
        return false;
    }

    public void levelUp() {
        // Let occupation know level is increased, then levelUp occ and base stats
        occupation.levelUp(entityStats);
    }

    public void gainXP(int xp) {
        entityStats.updateXP(xp);

        if(entityStats.getXP() >= entityStats.getRequiredLevelXP()){
            this.levelUp();
        }
    }

    public void gainHealth(int health) {
        entityStats.setCurrentHealth(health);
    }

    public void takeDamage(int damage) {
        entityStats.setCurrentHealth(-damage);

        if(entityStats.getCurrentHealth() <= 0)
            this.die();

    }

    public void die() {

    }

    // @TODO: Don't have Item object yet
    //  public void updateStats(Item item) {}


}
