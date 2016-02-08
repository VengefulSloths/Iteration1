package com.vengeful.sloths.View.AreaView.Animation;

import com.vengeful.sloths.View.ViewTime;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex on 2/3/2016.
 */
public class TimedAnimation extends AnimatedImage {
    protected ArrayList<Image> images;

    //Animations are stored in the form FILEPREFIX_FRAMENUMBER
    public TimedAnimation(String filePrefix, int frameCount, long duration) {
        this.duration = duration;
        images = new ArrayList<>();
        for (int i=1; i<frameCount+1; i++) {
            //System.out.Println(filePrefix + "_" +  i);
            ImageIcon ii = new ImageIcon(filePrefix + "_" +  i + ".png");
            images.add(ii.getImage());
        }
    }

    @Override
    public Image getCurrentImage(long startTime) {
        long t = ViewTime.getInstance().getCurrentTimeMilli();
        long endTime = startTime + duration;
        if (startTime == t) return images.get(0);
        else if (t >= endTime) return images.get(images.size()-1);
        else {
            return images.get((int)((float)(images.size()-1)/(float)(endTime - startTime)*(float)(t - startTime)));
        }
    }
}
