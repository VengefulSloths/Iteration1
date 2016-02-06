package com.vengeful.sloths.Models.Inventory;


import com.vengeful.sloths.Models.InventoryItems.EquippableItems.*;
import com.vengeful.sloths.Models.SaveLoad.Saveable;

/**
 * Created by qianwen on 1/30/16.
 */
public class Equipped implements Saveable {
    
    private Hat hat = null;
    private Sword sword = null;

    public Equipped(){

    }

    public Hat getHat(){
        return this.hat;
    }

    public void setHat(Hat h){
        this.hat = h;
    }

    public Sword getSword(){
        return this.sword;
    }

    public void setSword(Sword s){
        this.sword = s;
    }

    @Override
    public void saveMe() {
        System.out.println("save:" + this.toString());
        if(hat != null){hat.saveMe();}
        if(sword != null){sword.saveMe();}
    }
}
