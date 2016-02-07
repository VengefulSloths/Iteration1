package com.vengeful.sloths.Models.Map.MapItems.InteractiveItem;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.SaveLoad.SaveManager;

/**
 * Created by luluding on 2/6/16.
 */
public class InventoryInteractiveItem extends InteractiveItem{

    private InventoryItem requiredItem;

    public InventoryInteractiveItem(EffectCommand command, InventoryItem requiredItem){
        super(command);
        this.requiredItem = requiredItem;
    }

    @Override
    public void interact(Entity entity) {
        this.observer.alertActivated();
        if(entity.getInventory().hasItem(requiredItem)){
            command.execute();
        }
    }

    public void saveMe(SaveManager sm, int ws){
        sm.writeClassLine(ws, "ActionInteractiveItem");
        requiredItem.saveMeFromTakeable(sm ,ws);
        super.saveMe(sm ,ws);
    }
}
