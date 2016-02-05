package com.vengeful.sloths.Models.Map.AreaEffects;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Effects.*;

/**
 * Created by qianwen on 2/3/16.
 */
public class TakeDamageAE extends AreaEffect{
    private int damage;


    public TakeDamageAE(){
        this.damage = 1;
    }

    public TakeDamageAE(int damage){
        this.damage = damage;
    }

    //This AE can only take effect on Avatar
    @Override
    public EffectCommand createEffectCommand(Entity affectedEntity) {
        if(affectedEntity instanceof Avatar)
            return new TakeDamageAECommand(affectedEntity, this.damage, affectedEntity.getLocation());
        else
            return null;
    }
}
