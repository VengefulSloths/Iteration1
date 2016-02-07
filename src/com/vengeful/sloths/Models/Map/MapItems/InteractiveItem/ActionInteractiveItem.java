package com.vengeful.sloths.Models.Map.MapItems.InteractiveItem;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.Quest.*;

/**
 * Created by luluding on 2/6/16.
 */
public class ActionInteractiveItem extends InteractiveItem{

    Quest quest;

    public ActionInteractiveItem(EffectCommand command, Quest quest){
        super(command);
        this.quest = quest;
    }


    @Override
    public void interact(Entity entity) {
        this.observer.alertActivated();
        System.out.println("IS QUEST FINISHED: " + quest.finished());

        if(quest.finished()){
            this.command.execute();
        }


    }
}