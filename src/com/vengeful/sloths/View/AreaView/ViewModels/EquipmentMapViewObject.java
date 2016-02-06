package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;

import java.awt.*;

/**
 * Created by Alex on 2/5/2016.
 */
public class EquipmentMapViewObject extends ViewObject {

    private AnimatedImage walkingN;
    private AnimatedImage walkingNE;
    private AnimatedImage walkingE;
    private AnimatedImage walkingSE;
    private AnimatedImage walkingS;
    private AnimatedImage walkingSW;
    private AnimatedImage walkingW;
    private AnimatedImage walkingNW;

    private AnimatedImage current;

    public EquipmentMapViewObject(int x, int y, CoordinateStrategy converter) {}

    @Override
    public void paintComponent(Graphics2D g) {

    }
}
