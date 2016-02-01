package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.EntityObserver;

import java.util.Iterator;

/**
 * Created by zach on 1/30/16.
 */
public class AvatarMovementCommand extends MovementCommand {

    public AvatarMovementCommand(Map map, Coord src, Coord dst, Direction dir, Entity avatar) {
        super(map, src, dst, dir, avatar);

//

    }

    @Override
    public void execute() {
        //System.out.println(System.currentTimeMillis() + "executing movement command");
        Tile sourceTile = map.getTile(this.src);

        try {
            Tile destTile = map.getTile(this.dst);

            //System.out.println(" source BEFORE: " + sourceTile.getEntity());
            //System.out.println(destTile.getEntity());
            if (destTile.canMove()) {
                sourceTile.removeEntity();
                destTile.addEntity(entity);
                entity.setLocation(dst);

                Iterator<EntityObserver> iter = this.entity.entityObserverIterator();
                while (iter.hasNext()) {
                    EntityObserver eo = iter.next();
                    eo.alertMove(this.dst.getX(), this.dst.getY(), 200);
                }


            }
        } catch (Exception e) {

        } finally {
            Iterator<EntityObserver> iter = this.entity.entityObserverIterator();
            while (iter.hasNext()) {
                EntityObserver eo = iter.next();
                eo.alertDirectionChange(this.direction);
            }
        }

        // Tile t = map.getTile()
        // can Tile t take an entity?
        // Move calling entity onto the tile
        entity.setMoving(false);
    }


}