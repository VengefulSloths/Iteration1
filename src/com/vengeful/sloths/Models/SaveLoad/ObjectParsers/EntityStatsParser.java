package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;

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
        Parse();
    }

    public EntityStats Parse(){
        EntityStats entityStats = new EntityStats();
        while(sc.hasNext()){
            String check = sc.nextLine();
            if(check.equals("}")){

                return entityStats;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                if(varValue.equals("}")){
                    //looking to create a new object parser based on the varName
                    continue;
                }
                ObjectParser op = ops.ObjectParserFactory(varName);
                Object o = op.Parse();

                // Convert first char in var name to uppercase to find the correct setter
                varName = varName.substring(0,1).toUpperCase() + varName.substring(1);

                String methodName = "set"+varName;

                try {
                    Method method = entityStats.getClass().getMethod(methodName);
                    System.out.println("Trying to invoke method: " + method);
                    method.invoke(entityStats, o);
                }catch (Exception e){
                    System.out.println("Error with creating setter avatar method");
                }


            }
        }
        return entityStats;
    }
}
