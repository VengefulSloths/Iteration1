package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Map.Tile;
import com.vengeful.sloths.View.Observers.EntityObserver;
import java.util.Iterator;

/**
 * Created by luluding on 2/1/16.
 */
public class AvatarDropCommand extends DropCommand{

    public AvatarDropCommand(Map map, InventoryItem itemToDrop, Coord dropLoc, Entity entity){
        super(map, itemToDrop, dropLoc, entity);

        /*
        System.out.println("Before dropping");
        System.out.println("Is there anything on my tile?" + "(" + dropLocation.getX() + ", " + dropLocation.getY() + ")" + " : " + map.getTile(dropLocation).getMapItem(0));
        System.out.println("Is that hat in my inventory?: " + entity.getInventory().getItem(0));
        */


    }

    @Override
    public void execute() {

        //System.out.println("BEFORE DROP: " + entity.getInventory().getItem(0) + entity.getInventory().getItem(1) + entity.getInventory().getItem(2));

        Tile tile = map.getTile(dropLocation);
        tile.addMapItem(itemToDrop.getMapItemRep());
        entity.getInventory().removeItem(itemToDrop);

        //System.out.println("I am DONE dropping!!!");
        //System.out.println("dropped " + itemToDrop.getItemName());

        //System.out.println("AFTER DROP: " + entity.getInventory().getItem(0) + entity.getInventory().getItem(1) + entity.getInventory().getItem(2));


        Iterator<EntityObserver> iter = this.entity.entityObserverIterator();
        while (iter.hasNext()) {
            EntityObserver eo = iter.next();
            //System.out.println("EntityObservers: " + eo);
            //System.out.println("NULL?" + itemToDrop.getMapItemRep());
            eo.alertDrop(dropLocation.getX(), dropLocation.getY(), itemToDrop.getMapItemRep());
        }

    }
}
