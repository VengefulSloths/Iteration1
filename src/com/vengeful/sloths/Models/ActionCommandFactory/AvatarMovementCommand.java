package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Utility.Direction;

/**
 * Created by zach on 1/30/16.
 */
public class AvatarMovementCommand extends MovementCommand {

    public AvatarMovementCommand(Map map, Coord src, Coord dst, Direction dir, Entity avatar) {
        super(map, src, dst, dir, avatar);

        System.out.println("AvatarMovementCommand created!");
        System.out.println("Map: ");
        System.out.println(map);
        System.out.println("Source: ");
        System.out.println(src);
        System.out.println("Destination: ");
        System.out.println(dst);
        System.out.println("Avatar: ");
        System.out.println(avatar.getName());
        System.out.println("DIRECTION IS: " + dir);

    }

    @Override
    public void execute() {
        if (dst.getX() < 0 ||
                dst.getY() < 0) {
            // @TODO: OR IF GREATER THAN MAX COORDS
            System.out.println("ERROR: Attempted to move out of bounds");
            return;
        }

        Tile sourceTile = map.getTile(this.src);
        Tile destTile = map.getTile(this.dst);

        System.out.println(" source BEFORE: " + sourceTile.getEntity());
        System.out.println(" dest BEFORE : " +destTile.getEntity());

        if (destTile.canMove()) {
            sourceTile.removeEntity();
            destTile.addEntity(entity);
            entity.setLocation(dst);

            this.entity.entityObserver.alertDirectionChange(this.direction);
            this.entity.entityObserver.alertMove(this.dst.getX(), this.dst.getY(), 200);

        }
        System.out.println(" source AFTER: " + sourceTile.getEntity());
        System.out.println(" dest AFTER: " +destTile.getEntity());

        // Tile t = map.getTile()
        // can Tile t take an entity?
        // Move calling entity onto the tile
    }


}