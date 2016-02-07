package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.SaveLoad.Loader;

import java.util.Scanner;

/**
 * Created by icavitt on 2/7/2016.
 */
public class InventoryParser extends ObjectParser {

    public InventoryParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        super(objectName, sc,  l, ops);
    }

    @Override
    public Inventory Parse() {
        Inventory inv = new Inventory();
        while(sc.hasNext()){

            String check = sc.nextLine();
            if(check.equals("}")){
                //we have reached end of avater definition
                //return avatar to loader
                return inv;
            }
        }
        return inv;
    }


}
