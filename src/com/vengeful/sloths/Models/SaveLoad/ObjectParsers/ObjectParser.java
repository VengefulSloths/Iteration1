package com.vengeful.sloths.Models.SaveLoad.ObjectParsers;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;

import java.util.Scanner;

/**
 * Created by icavitt on 2/6/2016.
 */
public abstract class ObjectParser {
    protected Scanner sc;
    protected String objectName;
    protected Loader l;
    protected ObjectParserFactory ops;


    public ObjectParser(String objectName, Scanner sc, Loader l,ObjectParserFactory ops){
        this.objectName = objectName;
        this.sc = sc;
        this.l  = l;
        this.ops = ops;
    }

    public ObjectParser(){

    };

    public abstract Object Parse();


}
