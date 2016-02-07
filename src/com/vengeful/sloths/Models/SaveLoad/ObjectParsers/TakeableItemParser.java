package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.SaveLoad.Loader;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by zach on 2/7/16.
 */
public class TakeableItemParser extends ObjectParser {

    InventoryItem inventoryItemRep;

    public TakeableItemParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops, InventoryItem inventoryItemRep){
        super(objectName, sc, l, ops);

        this.inventoryItemRep = inventoryItemRep;
    }

    public TakeableItem Parse() {
        TakeableItem takeableItem = new TakeableItem(inventoryItemRep);
        while(sc.hasNext()){
            String check = sc.nextLine();

            if(check.contains("}")){
                return takeableItem;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                // Convert first char in var name to uppercase to find the correct setter
                varName = varName.substring(0,1).toUpperCase() + varName.substring(1);
                System.out.println("varName: "  + varName);
                System.out.println("varValue: "  + varValue);

                String methodName = "set"+varName;
                System.out.println("methodNamE: " + methodName);

                try {
                    Method method = takeableItem.getClass().getMethod(methodName, String.class);
                    method.invoke(takeableItem, varValue);
                }catch (Exception e){
                    System.out.println("Error with creating setter TakeableItem method");
                }


            }
        }

        return takeableItem;
    }
}
