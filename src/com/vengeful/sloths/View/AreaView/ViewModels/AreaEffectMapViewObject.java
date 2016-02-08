package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.Observers.AreaEffectObserver;
import com.vengeful.sloths.View.ViewTime;

import java.awt.*;

/**
 * Created by luluding on 2/5/16.
 */
public class AreaEffectMapViewObject extends ViewObject implements AreaEffectObserver{

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
        //System.out.Println("RESOURCE: " + resourceName);
        String itemImagePath = resourceLocation + "/" + resourceName;
        //System.out.Println("PATH: " + itemImagePath);
        itemImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(itemImagePath);
        //System.out.Println("itemImage should of been loaded");
        destructionAnimation = AnimatedImageFactory.instance().createTimedAnimatedImage(resourceLocation + "/Destroyed/" + resourceName + "_Broken");
        //System.out.Println("broken item image should of been loaded");
    }


    @Override
    public void alertDestroyed() {
        this.startTime = ViewTime.getInstance().getCurrentTimeMilli();
        this.isDestroyed = true;
        //destroyedSound.play();
        //System.out.Println("I am alerted! (AreaEffect)");
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
