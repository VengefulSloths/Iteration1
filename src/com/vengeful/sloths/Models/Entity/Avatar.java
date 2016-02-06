package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarMovementCommand;
import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.*;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.Direction;

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
           this.commandFactory.createMovementCommand(this.getLocation(), dst, dir, this, entityStats.getMovement());

        }else{
            //System.out.println("<<<<<<<<<<<<<<<<<<movement rejected>>>>>>>>>>>>>>>>");
        }
    }

    public boolean equip(InventoryItem item) {

        try {


            if(item instanceof Hat){

                Hat hat = this.equipped.getHat();
                if(hat != null) {
                    System.out.println("Swapping equipped hat");
                    this.getInventory().addItem(hat);
                }

                this.equipped.setHat((Hat)item);



            }else if(item instanceof Sword){

                Sword sword = this.equipped.getSword();
                if(sword != null)
                    this.getInventory().addItem(sword);


                this.equipped.setSword((Sword)item);
            }

            System.out.println("Equipped: " + item);
            this.inventory.removeItem(item);


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

    public boolean drop(InventoryItem item) {

        //System.out.println("BEFORE DROP: ");
        //for (int i = 0; i < inventory.getSize(); i++) {
        //    System.out.print(inventory.getItem(i).getItemName()+"\t ");
        //}
        //System.out.println();
        try{
//            InventoryItem itemToDrop = inventory.getItem(itemIndex);
            this.commandFactory.createDropCommand(item, this.getLocation(), this);

        }catch(Exception e){
            //whatever

        }

        //System.out.println("AFTER DROP: ");
        //for (int i = 0; i < inventory.getSize(); i++) {
        //    System.out.print(inventory.getItem(i).getItemName()+"\t ");
        //}

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

        if(entityStats.getCurrentHealth() <= 0){
            if(entityStats.getLivesLeft() == 0)
                this.die();
            else{
                entityStats.updateLivesLeft(-1);
                entityStats.setCurrentHealth(entityStats.getLife()); //set currentHP to maxHP
            }
        }
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

    public void saveMe(){
        super.saveMe();
        equipped.saveMe();
    }
}
