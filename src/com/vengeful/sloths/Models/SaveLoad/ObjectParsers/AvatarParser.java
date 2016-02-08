package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Occupation.Occupation;
import com.vengeful.sloths.Models.Occupation.Smasher;
import com.vengeful.sloths.Models.Occupation.Sneak;
import com.vengeful.sloths.Models.Occupation.Summoner;
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
    }

    public Avatar Parse(){
        Avatar avatar = new Avatar();
        while(sc.hasNext()){
            String check = sc.nextLine();
            if(check.contains("}")){
                //we have reached end of avater definition
                //return avatar to loader
                l.avatar = avatar;
                return avatar;
            }
            else{
                String[] line = check.split(":");
                String varName = line[0];
                String varValue = line[1];
                if(varValue.equals("{")){
                    //looking to create a new object parser based on the varName
                    ObjectParser op = ops.ObjectParserFactory(varName);
                    Object o = op.Parse();

                    // Convert first char in var name to uppercase to find the correct setter
                    varName = varName.substring(0,1).toUpperCase() + varName.substring(1);

                    String methodName = "set"+varName;

                    try{
                        Method method = avatar.getClass().getMethod(methodName, o.getClass());
                        method.invoke(avatar, o);
                    }catch (Exception e){
                        //System.out.Println("Error with creating setter avatar method");
                    }
                }

                if (varName.equals("Occupation")) {
                    Occupation occupation = null;
                    switch (varValue) {
                        case "Sneak":
                            occupation = new Sneak();
                            break;
                        case "Smasher":
                            occupation = new Smasher();
                            break;
                        case "Summoner":
                            occupation = new Summoner();
                            break;
                    }
                    avatar.setOccupation(occupation);
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
                    String[] split = varValue.split(",");
                    int x = Integer.parseInt(split[0].substring(1));
                    int y = Integer.parseInt(split[1].substring(0,split[1].length()-1));
                    Coord c = new Coord(x,y);
                    avatar.setLocation(c);
                }
            }
        }
        return avatar;
    }
}
