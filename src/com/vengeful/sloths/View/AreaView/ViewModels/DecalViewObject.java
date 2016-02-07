package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;

import java.awt.*;

/**
 * Created by Alex on 2/6/2016.
 */
public class DecalViewObject extends ViewObject {
    private AnimatedImage decal;
    public DecalViewObject(int x, int y, String resourceName, CoordinateStrategy converter) {
        this.x = x;
        this.y = y;
        this.converter = converter;
        this.decal = AnimatedImageFactory.instance().createRepeatingAnimatedImage(resourceName);
    }

    @Override
    public void paintComponent(Graphics2D g) {
        g.drawImage(decal.getCurrentImage(0) , converter.convertX(x), converter.convertY(y), this);
    }

}
