package com.vengeful.sloths.Models.Map.MapItems;

import com.vengeful.sloths.Models.Entity.Entity;

/**
 * Created by Ian on 2/1/2016.
 */
public class OneShotTest extends OneShotItem {
    public void interact(Entity entity){
        System.out.println("you've activated me");
        this.destroy = true;
    }

}
