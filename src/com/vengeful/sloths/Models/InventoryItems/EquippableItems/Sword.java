package com.vengeful.sloths.Models.InventoryItems.EquippableItems;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Models.Stats.BaseStats;

/**
 * Created by qianwen on 1/30/16.
 */
public class Sword extends EquippableItems {

    //public Sword(String swordName, BaseStats b) {
    //    super(swordName, b);
    //}

    public Sword(String swordName){
        super(swordName);
        //this.itemStats.setStats(10,0,0,0,0); //currently causes error
        this.itemStats.setStats(10,0,0,0,0);


    }
    public void saveMe(SaveManager sv, int ws){
        sv.writeClassLine(ws, "Sword");
        super.saveMe(sv, ws);
        sv.writeCloseBracket(ws);
    }
    public void saveMeFromTakeable(SaveManager sm, int ws) {
        sm.writeClassLine(ws, "Sword");
        super.saveMeFromTakeable(sm, ws);
    }
}
