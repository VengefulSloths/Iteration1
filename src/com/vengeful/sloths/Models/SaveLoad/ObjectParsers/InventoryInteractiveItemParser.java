package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.ActionInteractiveItem;
import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.InventoryInteractiveItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Utility.Coord;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by icavitt on 2/7/2016.
 */
public class InventoryInteractiveItemParser extends ObjectParser {

    public InventoryInteractiveItemParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        this.objectName = objectName;
        this.sc = sc;
        this.l = l;
        this.ops = ops;
    }

    public ObjectWithCoord Parse() {
        InventoryInteractiveItem iti = new InventoryInteractiveItem();
        ObjectWithCoord owc = new ObjectWithCoord(iti);

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
                        iti.setRequiredItem((InventoryItem) o);
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
                    System.out.println("methodName: " + methodName);

                    try {
                        Method method = iti.getClass().getMethod(methodName, String.class);

                        method.invoke(iti, ""+varValue);
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Error with creating setter TakeableItem method");
                    }
                }
            }
        }

        return owc;
    }
}
