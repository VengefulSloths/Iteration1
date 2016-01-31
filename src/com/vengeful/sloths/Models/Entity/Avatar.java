package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.*;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.View.AreaView.Direction;

/**
 * Created by zach on 1/30/16.
 */
public class Avatar extends Entity {

    private Inventory inventory;
    private Equipped equipped;
    private ActionCommandFactory commandFactory;

    public Avatar(String occupationString, EntityStats entityStats, ActionCommandFactory commandFactory) {
        super(occupationString, entityStats);
        this.inventory = new Inventory();
        this.equipped = new Equipped();
        this.commandFactory = commandFactory;
    }

    public void move(Direction dir) {
        Coord dst = this.getLocation();
        switch (dir) {
            case N:
                dst.setY(dst.getY() - 1);
                break;
            case E:
                dst.setX(dst.getX() + 1);
                break;
            case S:
                dst.setY(dst.getY() + 1);
                break;
            case W:
                dst.setX(dst.getX() - 1);
                break;
            case NE:
                dst.setY(dst.getY() - 1);
                dst.setX(dst.getX() + 1);
                break;
            case NW:
                dst.setY(dst.getY() - 1);
                dst.setX(dst.getX() - 1);
                break;
            case SE:
                dst.setY(dst.getY() + 1);
                dst.setX(dst.getX() + 1);
                break;
            case SW:
                dst.setY(dst.getY() + 1);
                dst.setX(dst.getX() - 1);
                break;
            default:
                break;
        }

        this.commandFactory.createMovementCommand(dst);
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
