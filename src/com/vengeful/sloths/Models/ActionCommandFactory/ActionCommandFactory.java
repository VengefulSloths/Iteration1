package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.Map;

/**
 * Created by zach on 1/30/16.
 */
public abstract class ActionCommandFactory {

    Map map;

    // movement command
    // drop command

    public ActionCommandFactory(Map map) {
        this.map = map;
    }

    public abstract MovementCommand createMovementCommand(Coord dst, Entity entity);
    public abstract DropCommand createDropCommand();
}