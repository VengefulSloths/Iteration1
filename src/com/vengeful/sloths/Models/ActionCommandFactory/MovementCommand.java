package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by zach on 1/30/16.
 */
public abstract class MovementCommand {

    Map map;
    Coord dst;

    public MovementCommand(Map map, Coord dst) {
        this.map = map;
        this.dst = dst;
    }
}
