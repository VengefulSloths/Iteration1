package com.vengeful.sloths.View.StatsView;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.View.Observers.StatsObserver;
import com.vengeful.sloths.View.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by John on 2/3/2016.
 */
public class StatsView extends View implements StatsObserver {

    StatsViewObjectManager manager;
    public static final String title = "Stats";
    public static final String backgroundImageFileName = "resources/inventoryBackground.jpg";

    public StatsView(Stats stats){

        generateTitle(title);
        this.setBackgroundImageFileName(backgroundImageFileName);

        this.manager = new StatsViewObjectManager();
        stats.registerObserver(this);
    }

    @Override
    public void alertStatChanged(StatsViewObject stat) {
        //update this bish ya hear
    }

    public void generateBackground() {
        setBackground(Color.ORANGE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
