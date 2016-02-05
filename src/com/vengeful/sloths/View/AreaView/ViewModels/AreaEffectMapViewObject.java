package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;

import java.awt.*;

/**
 * Created by luluding on 2/5/16.
 */
public class AreaEffectMapViewObject extends ViewObject{

    private AnimatedImage itemImage;
    private AnimatedImage destructionAnimation;
    private boolean isDestroyed = false;
    private long startTime;
    private long destructionTime;

    public AreaEffectMapViewObject(int x, int y, String resourceLocation, CoordinateStrategy converter) {
        this.x = x;
        this.y = y;
        this.converter = converter;

        String resourceName = resourceLocation.substring(resourceLocation.lastIndexOf('/')+1);
        System.out.println("RESOURCE: " + resourceName);
        String itemImagePath = resourceLocation + "/" + resourceName;
        System.out.println("PATH: " + itemImagePath);
        itemImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(itemImagePath);
        System.out.println("itemImage should of been loaded");
        destructionAnimation = AnimatedImageFactory.instance().createTimedAnimatedImage(resourceLocation + "/Destroyed/" + resourceName + "_Broken");
        System.out.println("broken item image should of been loaded");
    }


    @Override
    public void paintComponent(Graphics2D g) {

        if (!isDestroyed) {
            g.drawImage(itemImage.getCurrentImage(0),
                    converter.convertX(this.x),
                    converter.convertY(this.y),
                    this);
        } else {
            g.drawImage(destructionAnimation.getCurrentImage(startTime),
                    converter.convertX(this.x),
                    converter.convertY(this.y),
                    this);
        }

    }
}