package com.vengeful.sloths.Models.ActionCommandFactory;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Models.Map.Tile;

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


        //System.out.println("I am dropping!!!");

        //The logic for droppping goes here

        //System.out.println("MY LOCATION IS:" + dropLocation);
        Tile tile = map.getTile(dropLocation);
        //System.out.println("MY TILE IS:" + tile);
        tile.addMapItem(itemToDrop.getMapItemRep());
        entity.getInventory().removeItem(itemToDrop);

        System.out.println("I am DONE dropping!!!");
        System.out.println("dropped " + itemToDrop.getItemName());




        /*
        System.out.println("After dropping");
        System.out.println("Is it dropped on my tile?" + "(" + dropLocation.getX() + ", " + dropLocation.getY() + ")" + " : " + map.getTile(dropLocation).getMapItem(0));
        System.out.println("Is that hat still in my inventory?: " + entity.getInventory().getItem(0));
        */
    }
}
