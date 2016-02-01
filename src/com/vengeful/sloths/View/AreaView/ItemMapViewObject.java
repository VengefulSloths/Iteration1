package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.ViewObservable;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 2/1/2016.
 */
public class ItemMapViewObject extends ViewObject {
    private Image itemImage;
    private AnimatedImage destructionAnimation;
    private boolean isDestroyed = false;

    public ItemMapViewObject(int x, int y, String itemImageName, String destructionAnimationName, int destructionAnimationCount, int destructionTimeMicro, CoordinateStrategy converter ) {
        this.x = x;
        this.y = y;
        this.converter = converter;
        ImageIcon ii = new ImageIcon(itemImageName);
        itemImage = ii.getImage();
        destructionAnimation = new BoundedAnimation(destructionAnimationName, destructionAnimationCount);
    }

    @Override
    void paintComponent(Graphics2D g) {
        if (!isDestroyed) {
            g.drawImage(itemImage, converter.convertX(this.x), converter.convertY(this.y), this);

        }
    }
}
