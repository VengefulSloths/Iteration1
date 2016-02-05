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

    public StatsView(Stats stats){

        generateBackground();
        setLayout(new BorderLayout());
        this.add(new JLabel("Stats"), BorderLayout.NORTH);

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
