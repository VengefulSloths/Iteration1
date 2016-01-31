package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.View.AreaView.EntityObserver;
import com.vengeful.sloths.Utility.Direction;

/**
 * Created by zach on 1/30/16.
 */
public abstract class MovementCommand {

    Map map;
    Coord src;
    Coord dst;
    Entity entity;
    Direction direction;

    public MovementCommand(Map map, Coord src, Coord dst, Direction dir, Entity ent) {
        this.map = map;
        this.src = src;
        this.dst = dst;
        this.direction = dir;
        this.entity = ent;

        this.execute();
    }

    public abstract void execute();
}
