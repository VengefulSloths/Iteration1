package com.vengeful.sloths.Models.Map.AreaEffects;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Effects.InstantDeathAECommand;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.*;

/**
 * Created by luluding on 2/5/16.
 */
public class InstantDeathAE extends AreaEffect {

    public InstantDeathAE(){

    }


    @Override
    public EffectCommand createEffectCommand(Entity affectedEntity, Tile tile) {
        if(affectedEntity instanceof Avatar){
            return new InstantDeathAECommand(affectedEntity);
        }else
            return null;
    }
}
