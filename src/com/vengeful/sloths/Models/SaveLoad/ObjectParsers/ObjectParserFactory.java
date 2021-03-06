package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;


import com.vengeful.sloths.Models.SaveLoad.Loader;

import java.util.Scanner;

/**
 * Created by icavitt on 2/7/2016.
 */
public class ObjectParserFactory {
    private Scanner sc;
    private Loader l;

    public ObjectParserFactory(Scanner sc, Loader l){
        this.sc = sc;
        this.l = l;
    }

    public ObjectParser ObjectParserFactory(String className)
    {
        if(className.equals("Avatar")) {
            return new AvatarParser(className, sc, l, this);
        } else if(className.equals("Inventory")) {
            return new InventoryParser(className, sc, l, this);
        } else if(className.equals("EntityStats")) {
            return new EntityStatsParser(className, sc, l, this);
        } else if(className.equals("Sword")||className.equals("Hat")) {
            return new EquippableItemParser(className, sc, l, this);
        } else if(className.equals("BaseStats")) {
            return new BaseStatsParser(className, sc, l, this);
        } else if(className.equals("Equipped")){
            return new EquippedParser(className, sc, l, this);
        } else if (className.equals("TakeableItem")) {
            return new TakeableItemParser(className, sc, l, this);
        }else if(className.equals("Obstacle")||className.equals("OneShotTest")) {
            return new ObstacleAndOneShotParser(className,sc,l,this);
        }else if(className.equals("InventoryInteractiveItem")){
            return new InventoryInteractiveItemParser(className, sc, l, this);
        } else if (className.equals("ActionInteractiveItem")) {
            return new ActionInteractiveItemParser(className, sc, l ,this);
        }
        return null;
    }
}
