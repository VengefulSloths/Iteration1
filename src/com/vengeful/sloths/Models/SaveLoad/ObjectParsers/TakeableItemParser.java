package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Utility.Coord;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by zach on 2/7/16.
 */
public class TakeableItemParser extends ObjectParser {

    InventoryItem inventoryItemRep;


    public TakeableItemParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        super(objectName, sc, l, ops);
    }

    public TakeableItemParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops, InventoryItem inventoryItemRep){
        super(objectName, sc, l, ops);

        this.inventoryItemRep = inventoryItemRep;
    }

    public ObjectWithCoord Parse() {
        TakeableItem takeableItem = new TakeableItem();
        ObjectWithCoord owc = new ObjectWithCoord(takeableItem);

        while(sc.hasNext()){
            String check = sc.nextLine();

            if(check.contains("}")){
                return owc;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];

                if(varValue.equals("{")) {
                    //looking to create a new object parser based on the varName
                    ObjectParser op = ops.ObjectParserFactory(varName);
                    Object o = op.Parse();

                    try {
                        takeableItem.setInvItemRep((InventoryItem) o);
                    } catch (Exception e) {
                        System.out.println("Error setting takeableItem's inventory item rep");
                    }
                } else if(varName.equals("Coord")){
                    String[] split = varValue.split(",");
                    int x = Integer.parseInt(split[0].substring(1));
                    int y = Integer.parseInt(split[1].substring(0,split[1].length()-1));
                    Coord c = new Coord(x,y);
                    owc.setCoord(c);
                } else {
                    varName = varName.substring(0, 1).toUpperCase() + varName.substring(1);
                    System.out.println("varName: " + varName);
                    System.out.println("varValue: " + varValue);

                    String methodName = "set" + varName;
                    System.out.println("methodNamE: " + methodName);

                    try {
                        Method method = takeableItem.getClass().getMethod(methodName, String.class);

                        method.invoke(takeableItem, varValue);
                    } catch (Exception e) {
                        System.out.println("Error with creating setter TakeableItem method");
                    }
                }
            }
        }

        return owc;
    }

    public TakeableItem insideParse() {
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
