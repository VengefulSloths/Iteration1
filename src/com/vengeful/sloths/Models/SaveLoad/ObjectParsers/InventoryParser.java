package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.SaveLoad.Loader;

import java.lang.reflect.Method;
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
                if(varValue.equals("{")){
                    //looking to create a new object parser based on the varName
                    ObjectParser op = ops.ObjectParserFactory(varName);
                    Object o = op.Parse();

                    // Convert first char in var name to uppercase to find the correct setter
                    varName = varName.substring(0,1).toUpperCase() + varName.substring(1);

                    String methodName = "set"+varName;

                    if (o instanceof InventoryItem) {
                        methodName = "addItem";
                        try{
                            Method method = inv.getClass().getMethod(methodName, InventoryItem.class);
                            method.invoke(inv, o);
                        }catch (Exception e){
                            //System.out.Println("Error with creating setter avatar method");
                        }
                    }
                    try{
                        Method method = inv.getClass().getMethod(methodName, o.getClass());
                        method.invoke(inv, o);
                    }catch (Exception e){
                        //System.out.Println("Error with creating setter avatar method");
                    }
                }
                else{
                    // Convert first char in var name to uppercase to find the correct setter
//                    varName = varName.substring(0,1).toUpperCase() + varName.substring(1);
//                    String methodName = "set"+varName;
//                    int param = Integer.parseInt(varValue);
//                    try{
//                        Method method = inv.getClass().getMethod(methodName, int.class);
//                        method.invoke(inv, param);
//                    }catch (Exception e){
//                        //System.out.Println("Error with creating setter avatar method");
//                    }
                }
            }
        }
        return inv;
    }


}
