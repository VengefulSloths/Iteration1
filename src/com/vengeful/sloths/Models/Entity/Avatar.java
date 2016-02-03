package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.*;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.EntityObserver;

/**
 * Created by zach on 1/30/16.
 */
public class Avatar extends Entity {

    // Superclass
    //  private Inventory inventory;
    private Equipped equipped;
    private ActionCommandFactory commandFactory;

    //passes in AvatarActionCommandFactory
    public Avatar(String name, String occupationString, EntityStats entityStats, ActionCommandFactory commandFactory) {
        super(name, occupationString, entityStats);

        this.equipped = new Equipped();
        this.commandFactory = commandFactory;
    }

    public void move(Direction dir) {
        if(!isMoving) {

            this.setFacingDirection(dir);

            isMoving = true;
            //System.out.print("Move command started!");
            //System.out.print("Current location: " + this.getLocation());
            Coord dst = new Coord(this.getLocation().getX(), this.getLocation().getY());
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
                    //isMoving = false;
                    break;
            }
            //System.out.println("Attempting to move to: " + dst
            this.commandFactory.createMovementCommand(this.getLocation(), dst, dir, this);
        }else{
            //System.out.println("<<<<<<<<<<<<<<<<<<movement rejected>>>>>>>>>>>>>>>>");
        }
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
        /* Drop:
            - get item from inventory (check if item exists)
            - get tile from map
            - create take-able item
            - drop on tile (add to tile)
            - delete item from inventory
         */

        System.out.println("BEFORE DROP: " + inventory.getItem(0) + inventory.getItem(1) + inventory.getItem(2));

        try{
            InventoryItem itemToDrop = inventory.getItem(itemIndex);
            this.commandFactory.createDropCommand(itemToDrop, this.getLocation(), this);

        }catch(Exception e){
            //whatever

        }

        System.out.println("AFTER DROP: " + inventory.getItem(0) + inventory.getItem(1) + inventory.getItem(2));


        return true;
    }

    public boolean pickup(){
        //Pick up item
        this.commandFactory.createPickUpCommand(this.getLocation(), this);
        return true;
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

    /* FOR TESTING ONLY, MOST LIKELY WILL BE REMOVED! */
    public boolean addItem(InventoryItem item) {
        inventory.addItem(item);
        return true;
    }

}
