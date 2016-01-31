package com.vengeful.sloths.Utility;

import javax.swing.ImageIcon;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex on 1/30/2016.
 */
public class BoundedAnimation extends AnimatedImage{

    private ArrayList<Image> images;

    //Animations are stored in the form FILEPREFIX_FRAMENUMBER
    public BoundedAnimation(String filePrefix, int frameCount) {
        images = new ArrayList<Image>();
        for (int i=0; i<frameCount; i++) {
            System.out.println(filePrefix + "_" +  i);
            ImageIcon ii = new ImageIcon(filePrefix + "_" +  i + ".png");
            images.add(ii.getImage());
        }
    }
    @Override
    public Image getCurrentImage(long startTime, long endTime) {
        long t = System.currentTimeMillis();
        if (startTime == t) return images.get(0);
        else if (t >= endTime) return images.get(images.size()-1);
        else {
            System.out.println("frame: " + (int)((float)(images.size()-1)/(float)(endTime - startTime)*(float)(t - startTime)));
            return images.get((int)((float)(images.size()-1)/(float)(endTime - startTime)*(float)(t - startTime)));
        }
    }
}
