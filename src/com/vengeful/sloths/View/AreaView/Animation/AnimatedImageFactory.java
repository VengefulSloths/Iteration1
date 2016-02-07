package com.vengeful.sloths.View.AreaView.Animation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

/**
 * Created by Alex on 2/3/2016.
 */
public class AnimatedImageFactory {
    private static AnimatedImageFactory instance = null;
    private AnimatedImageFactory() {}
    public static AnimatedImageFactory instance() {
        if (instance == null) {
            instance = new AnimatedImageFactory();
        }
        return instance;
    }
    public AnimatedImage createSingleFrameAnimatedImage(String filename) {
        return new SingleFrameAnimation(filename);
    }
    public AnimatedImage createTimedAnimatedImage(String config) {
        try(BufferedReader br = new BufferedReader(new FileReader(config + ".txt"))) {
            int count = Integer.parseInt( br.readLine().substring(6));
            AnimatedImage ai = new TimedAnimation(config, count, 1000);
            return ai;

        } catch(Exception e) {
            return new SingleFrameAnimation("file_not_found.jpg");
        }

    }

    public AnimatedImage createRepeatingAnimatedImage(String config) {
        try(BufferedReader br = new BufferedReader(new FileReader(config + ".txt"))) {
            int count = Integer.parseInt( br.readLine().substring(6));
            AnimatedImage ai = new RepeatingAnimation(config, count, (long)(500 + 500 * Math.random()));
            return ai;

        } catch(Exception e) {
            return new SingleFrameAnimation("file_not_found.jpg");
        }

    }


}
