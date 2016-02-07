package com.vengeful.sloths.Models.Map.MapItems.InteractiveItem;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;

/**
 * Created by qianwen on 2/6/16.
 */
public class InventoryInteractiveItem extends InteractiveItem{

    private InventoryItem requiredItem;

    public InventoryInteractiveItem(EffectCommand command, InventoryItem requiredItem){
        super(command);
        this.requiredItem = requiredItem;
    }

    @Override
    public void interact(Entity entity) {
        System.out.println("INTERACTIVEITEM OBSERVER" + this.observer);

        this.observer.alertActivated();
        if(entity.getInventory().hasItem(requiredItem)){
            command.execute();
        }
    }
}
