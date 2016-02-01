package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.Occupation.Occupation;
import com.vengeful.sloths.Models.Occupation.Smasher;
import com.vengeful.sloths.Models.Occupation.Sneak;
import com.vengeful.sloths.Models.Occupation.Summoner;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.View.AreaView.EntityObserver;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Entity {

    private Coord location;

    protected String name;
    protected Occupation occupation;
    protected EntityStats entityStats;

    private ArrayList<EntityObserver> entityObservers;


    public Entity(String name, String occupationString, EntityStats entityStats) {
        this.name = name;
        this.entityObservers = new ArrayList<>();
        this.entityStats = entityStats;

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
        //TODO: Fix this hack
        for (EntityObserver eo: entityObservers) {
            if (eo == null) {
                entityObservers.remove(eo);
            }
        }
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

    public void registerObserver(EntityObserver entityObserver) {
        this.entityObservers.add(entityObserver);
    }



}
