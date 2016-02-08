package com.vengeful.sloths.View.AreaView.Animation;

import com.vengeful.sloths.View.ViewTime;

import java.awt.*;

/**
 * Created by Alex on 2/6/2016.
 */
public class RepeatingAnimation extends TimedAnimation {
    private int index = 0;
    public RepeatingAnimation(String filePrefix, int frameCount, long duration) {
        super(filePrefix, frameCount, duration);
    }

    @Override
    public Image getCurrentImage(long startTime) {
        long t = ViewTime.getInstance().getCurrentTimeMilli() % duration;
        if (60*Math.random() < 1) {
            if (++index == images.size()) {
                index = 0;
            }

        }
        ////System.out.Println(index);
        return images.get(index);
    }
}
