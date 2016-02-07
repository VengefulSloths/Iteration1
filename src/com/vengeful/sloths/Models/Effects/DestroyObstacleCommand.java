package com.vengeful.sloths.Models.Effects;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;

/**
 * Created by luluding on 2/6/16.
 */
public class DestroyObstacleCommand extends EffectCommand{
    MapItem obstacle;

    public DestroyObstacleCommand(MapItem obstacle){
        this.obstacle = obstacle;
    }

    @Override
    public void execute() {

        this.obstacle.destroy();
        //flag destory?
        //or tile.remove? -> iterator issue?

    }
}
