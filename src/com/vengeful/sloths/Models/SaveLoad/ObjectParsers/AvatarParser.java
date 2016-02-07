package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by icavitt on 2/7/2016.
 */
public class AvatarParser extends ObjectParser{

    public AvatarParser(String objectName, Scanner sc, Loader l,ObjectParserFactory ops){
        this.sc = sc;
        this.objectName = objectName;
        this.l  = l;
        this.ops = ops;
        Parse();
    }

    public Avatar Parse(){
        Avatar avatar = new Avatar();
        while(sc.hasNext()){
            String check = sc.nextLine();
            if(check.equals("}")){
                //we have reached end of avater definition
                //return avatar to loader
                l.avatar = avatar;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                if(varValue.equals("{")){
                    //looking to create a new object parser based on the varName
                    ObjectParser op = ops.ObjectParserFactory(varName);
                    Object o = op.Parse();
                    String methodName = "set"+varName;
                    try{
                        Method method = avatar.getClass().getMethod(methodName);
                        method.invoke(avatar, varName);
                    }catch (Exception e){
                        System.out.println("Error with creating setter avatar method");
                    }
                }
                if(varName.equals("name"))
                {
                    avatar.setName(varValue);
                }
                else if(varName.equals("Direction")){
                    if(varValue.equals("N")){
                        avatar.setFacingDirection(Direction.N);
                    }else if(varValue.equals("NE")){
                        avatar.setFacingDirection(Direction.NE);
                    }else if(varValue.equals("NW")){
                        avatar.setFacingDirection(Direction.NW);
                    }else if(varValue.equals("E")){
                        avatar.setFacingDirection(Direction.E);
                    }else if(varValue.equals("W")){
                        avatar.setFacingDirection(Direction.W);
                    }else if(varValue.equals("S")){
                        avatar.setFacingDirection(Direction.S);
                    }else if(varValue.equals("SE")){
                        avatar.setFacingDirection(Direction.SE);
                    }else if(varValue.equals("SW")){
                        avatar.setFacingDirection(Direction.SW);
                    }
                }
                else if(varName.equals("Coord")){

                    int x = Character.getNumericValue(varValue.charAt(1));
                    int y = Character.getNumericValue(varValue.charAt(3));
                    Coord c = new Coord(x,y);
                    avatar.setLocation(c);

                }
            }
        }
        return avatar;
    }
}
