package com.vengeful.sloths.View.StatsView;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.View.Observers.StatsObserver;
import com.vengeful.sloths.View.View;

import java.awt.*;

/**
 * Created by John on 2/3/2016.
 */
public class StatsView extends View implements StatsObserver {

    StatsViewObjectManager manager;

    public StatsView(Stats stats){
        this.manager = new StatsViewObjectManager();
        stats.registerObserver(this);
    }

    @Override
    public void alertStatChanged(StatsViewObject stat) {
        //update this bish ya hear
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
