package com.vengeful.sloths.Models.Map.MapItems;

import com.vengeful.sloths.Models.Entity.Entity;

/**
 * Created by John on 1/30/2016.
 */
public class Obstacle extends MapItem{

    @Override
    public boolean canMove(){
        return false;
    }

    public void interact(Entity entity){
        //maybe alert user he cannot move here
    }

}
