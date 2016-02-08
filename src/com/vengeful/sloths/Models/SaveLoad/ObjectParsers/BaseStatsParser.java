package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Models.Stats.BaseStats;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by zach on 2/7/16.
 */
public class BaseStatsParser extends ObjectParser {
    public BaseStatsParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        this.sc = sc;
        this.objectName = objectName;
        this.l  = l;
        this.ops = ops;
    }

    public BaseStats Parse() {
        BaseStats baseStats = new BaseStats();
        while(sc.hasNext()){
            String check = sc.nextLine();

            if(check.contains("}")){
                return baseStats;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                // Convert first char in var name to uppercase to find the correct setter
                varName = varName.substring(0,1).toUpperCase() + varName.substring(1);
                //System.out.Println("varName: "  + varName);
                //System.out.Println("varValue: "  + varValue);

                String methodName = "set" + varName;
                //System.out.Println("methodNamE: " + methodName);

                try {
                    int val = Integer.parseInt(varValue);
                    Method method = baseStats.getClass().getMethod(methodName, int.class);
                    method.invoke(baseStats, val);
                }catch (Exception e){
                    //System.out.Println("Error with creating setter BaseSets method");
                }


            }
        }

        return baseStats;
    }
}
