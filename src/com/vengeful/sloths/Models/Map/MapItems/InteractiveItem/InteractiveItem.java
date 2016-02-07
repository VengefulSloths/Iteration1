package com.vengeful.sloths.Models.Map.MapItems.InteractiveItem;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Utility.Coord;

/**
 * Created by John on 1/30/2016.
 */
public abstract class InteractiveItem extends MapItem {

    //used to identify the corresponding image file
    protected String name;
    protected EffectCommand command;

    public InteractiveItem(){}


    public InteractiveItem(EffectCommand command){
        this.command = command;
    }


    public abstract void interact(Entity entity);



}