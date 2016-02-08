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
    private AnimatedImage activatedItemImage;
    private AnimatedImage destructionAnimation;
    private boolean isDestroyed = false;
    private long startTime;
    private long destructionTime;
    private SoundEffect destroyedSound;
    private boolean isActivated = false;

    public ItemMapViewObject(int x, int y, String resourceLocation, String destroyedSoundPath, CoordinateStrategy converter ) {
        this.x = x;
        this.y = y;
        this.converter = converter;
        this.destroyedSound = new SoundEffect(destroyedSoundPath);
        String resourceName = resourceLocation.substring(resourceLocation.lastIndexOf('/')+1);
        String itemImagePath = resourceLocation + "/" + resourceName;
        itemImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(itemImagePath);
        activatedItemImage = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(itemImagePath + "_Activated");
        destructionAnimation = AnimatedImageFactory.instance().createTimedAnimatedImage(resourceLocation + "/Destroyed/" + resourceName + "_Broken");

    }

    @Override
    public void alertDestroyed() {
        this.startTime = ViewTime.getInstance().getCurrentTimeMilli();
        this.isDestroyed = true;
        destroyedSound.play();
        //System.out.Println("I am alerted! (MapItem)");
    }

    @Override
    public void alertActivated() {
        this.isActivated = true;
        (new SoundEffect("resources/Audio/click.wav")).play();
        //System.out.Println("I AM ACTIVATED!");
    }

    @Override
    public void alertDeactivated() {
        this.isActivated = false;
    }

    @Override
    public void paintComponent(Graphics2D g) {
        if (!isDestroyed && !this.isActivated) {
            g.drawImage(itemImage.getCurrentImage(0),
                    converter.convertX(this.x),
                    converter.convertY(this.y),
                    this);
        }else if(this.isActivated){
            g.drawImage(activatedItemImage.getCurrentImage(0),
                    converter.convertX(this.x),
                    converter.convertY(this.y),
                    this);
        }else {
            g.drawImage(destructionAnimation.getCurrentImage(startTime),
                    converter.convertX(this.x),
                    converter.convertY(this.y),
                    this);
        }
    }
}
