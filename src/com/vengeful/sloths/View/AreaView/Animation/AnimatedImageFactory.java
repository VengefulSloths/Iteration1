package com.vengeful.sloths.View.AreaView.Animation;

import java.io.BufferedReader;
import java.io.FileReader;

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
    public AnimatedImage createAnimatedImage(String config) {
        try(BufferedReader br = new BufferedReader(new FileReader(config + ".txt"))) {
            String countString = br.readLine().substring(6);
            System.out.println(countString);
            int count = Integer.parseInt(countString);
            System.out.println(count);

        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
