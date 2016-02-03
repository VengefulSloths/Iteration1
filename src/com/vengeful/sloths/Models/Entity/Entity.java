package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.Inventory.Inventory;

import com.vengeful.sloths.Models.Occupation.Occupation;
import com.vengeful.sloths.Models.Occupation.Smasher;
import com.vengeful.sloths.Models.Occupation.Sneak;
import com.vengeful.sloths.Models.Occupation.Summoner;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.ViewObservable;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.Observers.EntityObserver;
import com.vengeful.sloths.View.AreaView.Observers.ModelObserver;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Entity implements ViewObservable{

    private Coord location;

    protected boolean isMoving = false;

    protected String name;
    protected Occupation occupation;
    protected EntityStats entityStats;
    protected Inventory inventory;
    protected Direction facingDirection;

    protected ArrayList<EntityObserver> entityObservers;

    public void setInventory(Inventory inv) {
        this.inventory = inv;
    }

    public Entity(String name, String occupationString, EntityStats entityStats) {
        this.name = name;
        this.entityObservers = new ArrayList<>();
        this.entityStats = entityStats;
//        this.inventory = new Inventory();

        // Default facing South
        this.facingDirection = Direction.S;

        // @TODO: NOT ALL ENTITIES SHOULD TO SPAWN AT 2,2!
        this.location = new Coord(2,2);

        switch (occupationString) {
            case "Smasher":
                this.occupation = new Smasher();
                break;
            case "Sneak":
                this.occupation = new Sneak();
                break;
            case "Summoner":
                this.occupation = new Summoner();
                break;
            default:
                this.occupation = new Smasher();
        }

        this.occupation.init(entityStats);

    }

    public Iterator<EntityObserver> entityObserverIterator() {
        return entityObservers.iterator();
    }

    public Coord getLocation() {
        return location;
    }

    public void setLocation(Coord coord) {
        location = coord;
    }

    public String getName() {
        return this.name;
    }

    public void registerObserver(ModelObserver modelObserver) {
        this.entityObservers.add((EntityObserver) modelObserver);
    }

    public void deregisterObserver(ModelObserver modelObserver) { this.entityObservers.remove(modelObserver);}


    public Inventory getInventory(){
        return this.inventory;
    }


    public boolean isMoving() {
        return isMoving;
    }

    public void setFacingDirection(Direction d) {
        this.facingDirection = d;
    }

    public Direction getFacingDirection() {
        return this.facingDirection;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

}
