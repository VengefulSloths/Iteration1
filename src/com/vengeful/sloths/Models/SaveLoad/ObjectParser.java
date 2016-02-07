package com.vengeful.sloths.Models.SaveLoad;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by icavitt on 2/6/2016.
 */
public class ObjectParser {
    private Scanner sc;
    String objectName;

    public ObjectParser(String objectName, Scanner sc){
        this.sc = sc;
        this.objectName = objectName;
    }

    public Object beginParsing()
    {
        if(objectName.equals("Avatar")){
            return createAndParseAvatar();
        }
        else if(objectName.equals("null for now")){
            //do stuff
        }
        else{
            System.out.println("Object Parser cant identify the object");
            return null;
        }
        return null;
    }

   public Avatar createAndParseAvatar(){
       Avatar avatar = new Avatar();
        while(sc.hasNext()){
            String check = sc.nextLine();
            if(check.equals("}")){
                //do the return logic
            }
            else{
                String[] line = sc.nextLine().split(":");
                String varName = line[0];
                String varValue = line[1];
                if(varName.equals("name"))
                {
                    avatar.setName(varValue);
                }
                if(varName.equals("Direction")){
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
                if(varName.equals("Coord")){
                    Scanner s = new Scanner(varValue);
                    int x = s.nextInt();
                    int y = s.nextInt();
                    Coord c = new Coord(x,y);
                    avatar.setLocation(c);
                }
            }
        }
       return avatar;
    }
}
