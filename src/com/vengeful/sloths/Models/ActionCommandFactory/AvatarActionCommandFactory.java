package com.vengeful.sloths.Models.ActionCommandFactory;


import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Map.Map;

/**
 * Created by zach on 1/30/16.
 */
public class AvatarActionCommandFactory extends ActionCommandFactory {

    public AvatarActionCommandFactory(Map map) {
        super(map);
    }
    @Override
    public MovementCommand createMovementCommand(Coord dst) {
        MovementCommand mc = new AvatarMovementCommand(map, dst);
        return mc;
    }

    @Override
    public DropCommand createDropCommand() {
        return null;
    }
}
