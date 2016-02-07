package com.vengeful.sloths.Models.SaveLoad;


import com.vengeful.sloths.Models.Entity.Avatar;

import java.io.File;
import java.util.Scanner;

/**
 * Created by icavitt on 2/6/2016.
 */
public class Loader {
    private File f;
    private Scanner sc;
    //containers that hold everything being loaded
    public Avatar avatar = null;

    public Loader()
    {
        f = new File("resources\\save\\save.txt");
        try{
            sc = new Scanner(f);
        }catch(Exception e){
            System.out.println("issue creating scanner for loading from save file");
        }
    }

    public void loadIntoContainers()
    {
        while(sc.hasNext())
        {
            String s = sc.nextLine();
            String[] line = s.split(":");
            String className = line[0];
            ObjectParser op = new ObjectParser(className, sc);
            op.beginParsing();
        }
    }


}
