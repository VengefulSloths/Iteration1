package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.RepeatingAnimation;
import com.vengeful.sloths.View.AreaView.Animation.TimedAnimation;
import com.vengeful.sloths.View.ViewEngine;
import com.vengeful.sloths.View.ViewTime;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex on 2/7/2016.
 */
public class LoadingView extends MenuView{
    private AnimatedImage loadingImage;
    private boolean isFirstPaint = true;
    private long startTime;
    public LoadingView() {
        this.children = new ArrayList<>();

        this.loadingImage = new TimedAnimation("resources/Menu/Loading", 3, 1500);
        DefaultMenuComponent launchGame = new DefaultMenuComponent(
                "resources/Menu/Confirm",
                200,
                this.verticalOffset +(DefaultMenuComponent.HEIGTH + verticleSpacing)*menuCounter++);

        this.children.add(launchGame);
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isFirstPaint) {
            this.startTime = System.currentTimeMillis();
            isFirstPaint = false;
        }
        g.drawImage(loadingImage.getCurrentImage(startTime), 350, 400, this);
    }

}
