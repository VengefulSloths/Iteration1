package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Models.Stats.EntityStats;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by zach on 2/7/16.
 */

public class EntityStatsParser extends ObjectParser {
    public EntityStatsParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        this.sc = sc;
        this.objectName = objectName;
        this.l  = l;
        this.ops = ops;
    }

    public EntityStats Parse() {
        EntityStats entityStats = new EntityStats();
        while(sc.hasNext()){
            String check = sc.nextLine();
            System.out.println("howyd"+check);

            if(check.contains("}")){
                System.out.println("at end of entitystats");
                return entityStats;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                // Convert first char in var name to uppercase to find the correct setter
                varName = varName.substring(0,1).toUpperCase() + varName.substring(1);

                String methodName = "set"+varName;

                try {
                    Method method = null;
                    if (methodName.equals("setCurrentHealth")) {
                        method = entityStats.getClass().getMethod("setCurrentHealthFromLoad", int.class);
                    } else {
                        method = entityStats.getClass().getMethod(methodName, int.class);
                    }

                    method.invoke(entityStats, Integer.parseInt(varValue));
                }catch (Exception e){
                    System.out.println("Error with creating setter entitystats method");
                }


            }
        }
        System.out.println("hey");
        return entityStats;
    }
}
