package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Map.MapItems.InteractiveItem.ActionInteractiveItem;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Utility.Coord;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by zach on 2/7/16.
 */
public class ActionInteractiveItemParser extends ObjectParser {

    public ActionInteractiveItemParser(String objectName, Scanner sc, Loader l, ObjectParserFactory ops){
        super(objectName, sc,  l, ops);
    }

    @Override
    public ObjectWithCoord Parse() {
        ActionInteractiveItem aii = new ActionInteractiveItem();
        Coord c = null;
        ObjectWithCoord owc = new ObjectWithCoord(aii);
        while(sc.hasNext()){

            String check = sc.nextLine();
            if(check.equals("}")){
                return owc;
            } else {
                String[] line = check.split(":");
                String varName = line[0].substring(0,1).toUpperCase() + line[0].substring(1);
                String varValue = line[1];

                if(varName.equals("Coord")){
                    String[] split = varValue.split(",");
                    int x = Integer.parseInt(split[0].substring(1));
                    int y = Integer.parseInt(split[1].substring(0,split[1].length()-1));
                    c = new Coord(x,y);
                    owc.setCoord(c);
                } else {
                    String methodName = "set" + varName;

                    try {
                        Method method = aii.getClass().getMethod(methodName, String.class);
                        method.invoke(aii, varValue);
                    } catch (Exception e) {
                        System.out.println("Error with creating setter ActionInteractiveItem method");
                    }
                }
            }
        }
        return owc;
    }
}
