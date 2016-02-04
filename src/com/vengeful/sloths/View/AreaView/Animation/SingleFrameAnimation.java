package com.vengeful.sloths.View.AreaView.Animation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 2/3/2016.
 */
public class SingleFrameAnimation extends AnimatedImage{
    private Image image;
    public SingleFrameAnimation(String filename) {
        System.out.println(filename);
        ImageIcon ii = new ImageIcon(filename + ".png");
        this.image = ii.getImage();
    }
    @Override
    public Image getCurrentImage(long startTime) {
        return image;
    }
}
