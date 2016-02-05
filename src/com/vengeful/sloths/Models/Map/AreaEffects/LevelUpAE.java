package com.vengeful.sloths.Models.Map.AreaEffects;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Effects.LevelUpAECommand;
import com.vengeful.sloths.Models.Effects.TakeDamageAECommand;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Stats.EntityStats;

/**
 * Created by qianwen on 2/3/16.
 */
public class LevelUpAE extends AreaEffect{


    public LevelUpAE(){
        this.destory = true; //show be destroyed as soon as activated once
    }

    //This AE can only take effect on Avatar
    @Override
    public EffectCommand createEffectCommand(Entity affectedEntity) {
        if(affectedEntity instanceof Avatar)
            return new LevelUpAECommand(affectedEntity);
        else
            return null;
    }
}
