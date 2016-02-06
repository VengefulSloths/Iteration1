package com.vengeful.sloths.Models.Map.AreaEffects;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Effects.LevelUpAECommand;
import com.vengeful.sloths.Models.Effects.TakeDamageAECommand;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.Map.*;
import com.vengeful.sloths.View.Observers.ModelObserver;

/**
 * Created by qianwen on 2/3/16.
 */
public class LevelUpAE extends AreaEffect{

    public LevelUpAE(){
        
    }

    //This AE can only take effect on Avatar
    @Override
    public EffectCommand createEffectCommand(Entity affectedEntity, Tile tile) {
        if(affectedEntity instanceof Avatar) {
            this.destory = true; //show be destroyed as soon as activated once
            return new LevelUpAECommand(affectedEntity, tile, this);
        }
        else
            return null;
    }

}
