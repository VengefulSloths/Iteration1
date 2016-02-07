package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.InventoryItems.EquippableItems.EquippableItems;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Models.Stats.BaseStats;
import com.vengeful.sloths.Models.Stats.Stats;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by icavitt on 2/7/2016.
 */
public class EquippableItemParser extends ObjectParser {
    private TakeableItem item;

    public EquippableItemParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        super(objectName, sc, l, ops);
    }

    public EquippableItemParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops, TakeableItem item){
        super(objectName, sc, l, ops);
        this.item = item;
    }

    @Override
    public EquippableItems Parse() {
        EquippableItems eitem = null;
        if(objectName.equals("Hat")){
            eitem = new Hat();
        }else if( objectName.equals("Sword")) {
            eitem = new Sword();
        }
        while(sc.hasNext()){
            String check = sc.nextLine();
            if(check.contains("}")){
                //we have reached end of equippable item definition
                //eitem inventory or equipped
                return eitem;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                if(varValue.equals("{")){
                    //looking to create a new object parser based on the varName
                    ObjectParser op = ops.ObjectParserFactory(varName);
                    Object o = op.Parse();
                    if(varName.equals("BaseStats")){
                        eitem.setItemStats((BaseStats) o);
                    }else if(varName.equals("TakeableItem")){
                        eitem.setTakeableItem((TakeableItem)o);
                    }
                }
                else{
                    varName = varName.substring(0,1).toUpperCase() + varName.substring(1);

                    String methodName = "set"+varName;
                    try{
                        Method method = eitem.getClass().getMethod(methodName, String.class);
                        method.invoke(eitem, varValue);
                    }catch (Exception e){
                        System.out.println("Error with creating setter avatar method");
                    }
                }
            }
        }
        System.out.println("error equippable item didnt get fully read");
        return eitem;
    }
}
