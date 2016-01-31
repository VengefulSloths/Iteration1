package com.vengeful.sloths.Models.Entity;

import com.vengeful.sloths.Models.Occupation.Occupation;
import com.vengeful.sloths.Models.Occupation.Smasher;
import com.vengeful.sloths.Models.Occupation.Sneak;
import com.vengeful.sloths.Models.Occupation.Summoner;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by zach on 1/30/16.
 */
public abstract class Entity {
    private Coord location;
    protected Occupation occupation;
    protected EntityStats entityStats;


    public Entity(String occupationString, EntityStats entityStats) {
        this.entityStats = entityStats;
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

    public Coord getLocation() {
        return location;
    }

    public void setLocation(Coord coord) {
        location = coord;
    }




}
