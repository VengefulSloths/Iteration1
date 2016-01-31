package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by zach on 1/30/16.
 */
public class AvatarMovementCommand extends MovementCommand {

    public AvatarMovementCommand(Map map, Coord dst, Entity avatar) {
        super(map, dst, avatar);
    }

    @Override
    public void execute() {
        if (dst.getX() < 0 ||
                dst.getY() < 0) {
            // @TODO: OR IF GREATER THAN MAX COORDS
            System.out.println("ERROR: Attempted to move out of bounds");
            return;
        }

        // Tile t = map.getTile()
        // can Tile t take an entity?
        // Move calling entity onto the tile
    }
}