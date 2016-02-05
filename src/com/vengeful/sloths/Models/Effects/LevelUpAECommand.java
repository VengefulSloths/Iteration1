package com.vengeful.sloths.Models.Effects;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.TimeModel.TimeModel;

/**
 * Created by luluding on 2/5/16.
 */
public class LevelUpAECommand extends EffectCommand {

    public LevelUpAECommand(Entity entity){
        this.entity = entity;
        TimeModel.getInstance().registerAlertable(this, 0);
    }


    @Override
    public void execute() {

        System.out.println("MY LEVEL BEFORE: " + entity.getEntityStats().getLevel());

        if(entity instanceof Avatar){
            ((Avatar)entity).levelUp();
            System.out.println("LEVELING UP!!");
        }

        System.out.println("MY LEVEL AFTER: " + entity.getEntityStats().getLevel());
    }
}
