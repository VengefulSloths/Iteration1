package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by zach on 1/30/16.
 */
public class EntityCommandFactory extends ActionCommandFactory {

    public EntityCommandFactory(Map map) {
        super(map);
    }

    @Override
    public MovementCommand createMovementCommand(Coord dst) {
        // @TODO: Not implemented in this iteration
        return null;
    }

    @Override
    public DropCommand createDropCommand() {
        return null;
    }
}
