package com.vengeful.sloths.Models.Map.AreaEffects;

import com.vengeful.sloths.Models.Effects.EffectCommand;
import com.vengeful.sloths.Models.Entity.Entity;

/**
 * Created by John on 1/30/2016.
 */
public abstract class AreaEffect {

    //protected String name;

    //Flag for whether to destory the AE after use
    protected boolean destory;

    public AreaEffect(){
        this.destory = false;
    }

    public abstract EffectCommand createEffectCommand(Entity affectedEntity);


    public boolean isDestory(){
        return this.destory;
    }


}
