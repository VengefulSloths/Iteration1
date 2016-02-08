package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.Obstacle;
import com.vengeful.sloths.Models.Map.MapItems.OneShotTest;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Utility.Coord;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by icavitt on 2/7/2016.
 */
public class ObstacleAndOneShotParser extends ObjectParser{

    public ObstacleAndOneShotParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        this.objectName = objectName;
        this.sc = sc;
        this.l = l;
        this.ops = ops;
    }

    public ObjectWithCoord Parse(){
        MapItem o = null;
        Coord c = null;
        if(objectName.equals("Obstacle"))
        {
            o = new Obstacle();
        }else{
            o = new OneShotTest();
        }
        ObjectWithCoord owc = new ObjectWithCoord(o);
        while(sc.hasNext()){
            String check = sc.nextLine();
            if(check.contains("}")){
                //we have reached end of equippable item definition
                //eitem inventory or equipped
                return owc;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                if(varName.equals("Coord")){
                    int x = Character.getNumericValue(varValue.charAt(1));
                    int y = Character.getNumericValue(varValue.charAt(3));
                    c = new Coord(x,y);
                    owc.setCoord(c);
                }
                else{
                    varName = varName.substring(0,1).toUpperCase() + varName.substring(1);

                    String methodName = "set"+varName;
                    try{
                        Method method = o.getClass().getMethod(methodName, String.class);
                        method.invoke(o, varValue);
                    }catch (Exception e){
                        System.out.println("Error with creating setter avatar method");
                    }
                }
            }
        }
        return owc;
    }
}
