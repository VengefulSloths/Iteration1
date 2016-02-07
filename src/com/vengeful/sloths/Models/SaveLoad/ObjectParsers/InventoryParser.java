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
                //we have reached end of Inventory definition
                //inventory to object that called it
                return inv;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0].substring(0,1).toUpperCase() + line[0].substring(1);
                String varValue = line[1];
            }
        }
        return inv;
    }


}
