package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;


import com.vengeful.sloths.Models.SaveLoad.Loader;

import java.util.Scanner;

/**
 * Created by icavitt on 2/7/2016.
 */
public class ObjectParserFactory {
    private Scanner sc;
    private Loader l;

    public ObjectParserFactory(Scanner sc, Loader l){
        this.sc = sc;
        this.l = l;
    }

    public ObjectParser ObjectParserFactory(String className)
    {
        if(className.equals("Avatar")){
            return new AvatarParser(className, sc, l, this);
        }
        return null;
    }

}
