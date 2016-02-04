package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.Animation.BoundedAnimation;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.Observers.MapItemObserver;
import com.vengeful.sloths.View.Sound.SoundEffect;
import com.vengeful.sloths.View.ViewTime;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 2/1/2016.
 */
public class ItemMapViewObject extends ViewObject
        implements MapItemObserver {
    private AnimatedImage itemImage;
    private AnimatedImage destructionAnimation;
    private boolean isDestroyed = false;
    private long startTime;
    private long destructionTime;
    private SoundEffect destroyedSound;

    public ItemMapViewObject(int x, int y, String resourceLocation, String destroyedSoundPath, CoordinateStrategy converter ) {
        this.x = x;
        this.y = y;
        this.converter = converter;
        this.destroyedSound = new SoundEffect(destroyedSoundPath);
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
    public void alertDestroyed() {
        this.startTime = ViewTime.getInstance().getCurrentTimeMilli();
        this.isDestroyed = true;
        destroyedSound.play();
        System.out.println("I am alerted! (MapItem)");
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
