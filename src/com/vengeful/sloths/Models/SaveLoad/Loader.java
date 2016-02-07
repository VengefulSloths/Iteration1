package com.vengeful.sloths.Models.SaveLoad;


import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.SaveLoad.ObjectParsers.ObjectParser;
import com.vengeful.sloths.Models.SaveLoad.ObjectParsers.ObjectParserFactory;

import java.io.File;
import java.util.Scanner;

/**
 * Created by icavitt on 2/6/2016.
 */
public class Loader {
    private File f;
    private Scanner sc;
    ObjectParserFactory ops;
    //containers that hold everything being loaded
    public Avatar avatar = null;

    public Loader()
    {
        f = new File("resources" + File.separator + "save" + File.separator + "save.txt");
        try{
            sc = new Scanner(f);
        }catch(Exception e){
            System.out.println("issue creating scanner for loading from save file");
        }
        ops = new ObjectParserFactory(sc, this);
        loadIntoContainers();
    }

    public void loadIntoContainers()
    {
        while(sc.hasNext())
        {
            String s = sc.nextLine();
            String[] line = s.split(":");
            String className = line[0];
            ObjectParser op = ops.ObjectParserFactory(className);
            op.Parse();
        }
    }


}
