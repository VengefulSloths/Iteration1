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
    private ArrayList<MapSaveable> objectsToSave;
    private SaveVisitor sv;

    public void addSaveables(ArrayList<MapSaveable> ALS)
    {
        for(MapSaveable s: ALS){
            if(s != null){objectsToSave.add(s);}
        }
    }

    public SaveManager(){
        objectsToSave = new ArrayList<MapSaveable>();
        f = new File("resources\\save\\save.txt");
    }

    public void setSaveVisitor(SaveVisitor sv)
    {
        this.sv = sv;
    }

    public void save(){
        try{
            f.delete();
            f.createNewFile();
            //writeClassLine(0, "HELLO");
            //writeVariableLine(1, "salutations", "hello", true);
        } catch(IOException e){
            System.out.println("save failed: ");
            System.out.print(e);
            return;
        }
        sv.visitTiles();
        for(MapSaveable s: objectsToSave){
            s.saveMe(this,0);
        }
    }

    public void writeClassLine(int ws, String className)
    {
        BufferedWriter bw = null;
        try{
            bw= new BufferedWriter(new FileWriter(f,true));
            int i = 0;
            while(i<=ws){
                bw.write(" ");
                ++i;
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

    public void writeVariableLine(int ws, String varName, String varValue, boolean last){
        ++ws;
        BufferedWriter bw = null;
        try{
            bw= new BufferedWriter(new FileWriter(f,true));
            int i = 0;
            while(i <= ws){
                bw.write(" ");
                ++i;
            }
            bw.write("\"" + varName + "\": \"" + varValue +"\"");
            if(!last){
                bw.write(",");
            }
            bw.newLine();
            if(last) {
                ws = ws-1;
                i = 0;
                while(i <= ws){
                    bw.write(" ");
                    ++i;
                }
                bw.write("}");
                bw.newLine();
            }
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

    public void writeCloseBracket(int ws)
    {
        BufferedWriter bw = null;
        try{
            bw= new BufferedWriter(new FileWriter(f,true));
            int i = 0;
            while(i<=ws){
                bw.write(" ");
                ++i;
            }
            bw.write("}");
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
