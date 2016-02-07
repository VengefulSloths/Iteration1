package com.vengeful.sloths.Models.Map;

import com.vengeful.sloths.Models.SaveLoad.SaveManager;
import com.vengeful.sloths.Models.SaveLoad.Saveable;

/**
 * Created by John on 1/30/2016.
 */
public class Decal implements Saveable{

    @Override
    public void saveMe(SaveManager sm, int ws) {
        sm.writeClassLine(ws, "Decal");
        sm.writeCloseBracket(ws);
    }
}
