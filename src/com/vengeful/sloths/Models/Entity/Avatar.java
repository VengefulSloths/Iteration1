package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarMovementCommand;
import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.*;
import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.Observers.EntityObserver;

import java.util.Iterator;

/**
 * Created by zach on 1/30/16.
 */
public class Avatar extends Entity {

    // Superclass
    //  private Inventory inventory;
    //private Equipped equipped;
    private ActionCommandFactory commandFactory;

    //passes in AvatarActionCommandFactory
    public Avatar(String name, String occupationString, EntityStats entityStats, ActionCommandFactory commandFactory) {
        super(name, occupationString, entityStats);

        this.equipped = new Equipped();
        this.commandFactory = commandFactory;
    }

    public Equipped getEquipped() {
        return equipped;
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
           this.commandFactory.createMovementCommand(this.getLocation(), dst, dir, this, entityStats.getMovement());

        }else{
            //System.out.println("<<<<<<<<<<<<<<<<<<movement rejected>>>>>>>>>>>>>>>>");
        }
    }

    public boolean equip(InventoryItem item) {


        if(!(item instanceof EquippableItems))
            return false;

        InventoryItem checkEquipped = this.equipped.alreadyEquipped((EquippableItems)item);

        if(checkEquipped != null){
            System.out.println("Swapping equipped item");
            this.unequip(checkEquipped);
        }

        this.equipped.addEquipped((EquippableItems)item);
        this.inventory.removeItem(item);

        return true;
    }

    public boolean unequip(InventoryItem item) {

        if(!(item instanceof EquippableItems)){
            return false;
        }

        this.equipped.removeEquipped((EquippableItems) item);

        this.inventory.addItem(item);
        return true;
    }

    public boolean drop(InventoryItem item) {

        try{
//            InventoryItem itemToDrop = inventory.getItem(itemIndex);
            this.commandFactory.createDropCommand(item, this.getLocation(), this);

        }catch(Exception e){
            //whatever
        }

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
        entityStats.alertObservers();
    }

    public void gainXP(int xp) {
        entityStats.updateXP(xp);

        if(entityStats.getXP() >= entityStats.getRequiredLevelXP()){
            this.levelUp();
        }
        entityStats.alertObservers();
    }

    public void gainHealth(int health) {
        entityStats.setCurrentHealth(health);
        entityStats.alertObservers();
    }

    public void takeDamage(int damage) {
        entityStats.setCurrentHealth(-damage);

        if(entityStats.getCurrentHealth() <= 0){
            if(entityStats.getLivesLeft() == 0)
                this.die();
            else{
                entityStats.updateLivesLeft(-1);
                entityStats.setCurrentHealth(entityStats.getLife()); //set currentHP to maxHP
            }
        }
        entityStats.alertObservers();
    }

    public void die() {
        System.out.println("Entity is Dead D:");

        //Bring up game menu here??
    }

    // @TODO: Don't have Item object yet
    //  public void updateStats(Item item) {}

    /* FOR TESTING ONLY, MOST LIKELY WILL BE REMOVED! */
    public boolean addItem(InventoryItem item) {
        inventory.addItem(item);
        return true;
    }

    public void saveMe(SaveManager sv, int ws){
        //super.saveMe();
        sv.writeClassLine(ws, "Avatar");
        entityStats.saveMe(sv, ws+1);
        inventory.saveMe(sv, ws+1);
        occupation.saveMe(sv, ws+1);
        equipped.saveMe(sv, ws+1);
        sv.writeVariableLine(ws, "name", name, false);
        sv.writeVariableLine(ws,"Direction", facingDirection.toString(), false);
    }
}
