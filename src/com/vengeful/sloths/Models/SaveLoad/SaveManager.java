package com.vengeful.sloths.Models.SaveLoad;

import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Utility.TileVisitor.SaveVisitor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ian on 2/3/2016.
 */
public class SaveManager {
    private File f;
    private ArrayList<Saveable> objectsToSave;
    private SaveVisitor sv;

    public void addSaveables(ArrayList<Saveable> ALS)
    {
        for(Saveable s: ALS){
            if(s != null){objectsToSave.add(s);}
        }
    }

    public SaveManager(){
        objectsToSave = new ArrayList<Saveable>();
        f = new File("../resources/save/save.txt");
    }

    public void setSaveVisitor(SaveVisitor sv)
    {
        this.sv = sv;
    }

    public void save(){
        sv.visitTiles();
        for(Saveable s: objectsToSave){
            s.saveMe();
        }
    }

    public void writeClassLine(int ws, String className)
    {
        BufferedWriter bw = null;
        try{
            f.delete();
            f.createNewFile();
            bw= new BufferedWriter(new FileWriter(f,true));
            int i = 0;
            while(i<=ws){
                bw.write("/t");
            }
            bw.write("\"" + className + "\"{");
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            //not doin nothin
        } finally {
            if(bw != null)try{
                bw.close();
            }catch (IOException e){
                //not doin nothin
            }
        }
    }

    public void writeVariableLine(int ws, String varName, String varValue, boolean notEnd){
        BufferedWriter bw = null;
        try{
            f.delete();
            f.createNewFile();
            bw= new BufferedWriter(new FileWriter(f,true));
            int i = 0;
            while(i<=ws){
                bw.write("/t");
            }
            bw.write("\"" + varName + "\": \"" + varValue +"\"");
            bw.newLine();
            bw.flush();
        }catch (IOException e){
            //not doin nothin
        } finally {
            if(bw != null)try{
                bw.close();
            }catch (IOException e){
                //not doin nothin
            }
        }
    }
}
