package com.vengeful.sloths.Models.Map.MapItems.InteractiveItem;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.SaveLoad.SaveManager;

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
        try{
        if(entity.getInventory().hasItem(requiredItem) || entity.getEquipped().getSword().equals(requiredItem) || entity.getEquipped().getHat().equals(requiredItem)) {
            command.execute();
        }
        }catch (NullPointerException e){
            //dont have any objects, sont execute command
        }
    }

    public void saveMe(SaveManager sm, int ws){
        sm.writeClassLine(ws, "ActionInteractiveItem");
        requiredItem.saveMeFromTakeable(sm ,ws);
        super.saveMe(sm ,ws);
    }
}
