package com.vengeful.sloths.Models.Map.AreaEffects;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Effects.HealDamageAECommand;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Map.*;

/**
 * Created by luluding on 2/5/16.
 */
public class HealDamageAE extends AreaEffect{
    int health;

    public HealDamageAE(){
        this.health = 1;
    }

    public HealDamageAE(int heal){
        this.health = heal;
    }

    //This AE can only take effect on Avatar
    @Override
    public EffectCommand createEffectCommand(Entity affectedEntity) {
        if(affectedEntity instanceof Avatar)
            return new HealDamageAECommand(affectedEntity, this.health, affectedEntity.getLocation());
        else
            return null;
    }
}
