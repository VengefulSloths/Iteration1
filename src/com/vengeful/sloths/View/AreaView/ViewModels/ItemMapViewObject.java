package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.BoundedAnimation;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.AreaView.Observers.MapItemObserver;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 2/1/2016.
 */
public class ItemMapViewObject extends ViewObject
        implements MapItemObserver {
    private Image itemImage;
    private AnimatedImage destructionAnimation;
    private boolean isDestroyed = false;
    private long startTime;
    private long destructionTime;

    public ItemMapViewObject(int x, int y, String itemImageName, String destructionAnimationName, int destructionAnimationCount, long destructionTimeMicro, CoordinateStrategy converter ) {
        this.x = x;
        this.y = y;
        this.converter = converter;
        this.destructionTime = destructionTimeMicro;
        ImageIcon ii = new ImageIcon(itemImageName);
        itemImage = ii.getImage();
        destructionAnimation = new BoundedAnimation(destructionAnimationName, destructionAnimationCount);
    }

    @Override
    public void alertDestroyed() {
        this.startTime = System.currentTimeMillis();
        this.isDestroyed = true;
        System.out.println("I am alerted! (MapItem)");
    }

    @Override
    public void paintComponent(Graphics2D g) {
        if (!isDestroyed) {
            g.drawImage(itemImage,
                    converter.convertX(this.x),
                    converter.convertY(this.y),
                    this);
        } else {
            g.drawImage(destructionAnimation.getCurrentImage(startTime, startTime + destructionTime),
                    converter.convertX(this.x),
                    converter.convertY(this.y),
                    this);
        }
    }
}
