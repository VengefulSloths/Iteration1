package com.vengeful.sloths.View.StatsView;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.Observers.StatsObserver;
import com.vengeful.sloths.View.View;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

/**
 * Created by John on 2/3/2016.
 */
public class StatsView extends View implements StatsObserver {

    StatsViewObjectManager manager;
    private Stats stats;

    public StatsView(Stats stats){
        if(stats != null){stats.deregisterObserver(this);}

        generateBackground();
        setLayout(new BorderLayout());
        this.add(new JLabel("Stats"), BorderLayout.NORTH);

        this.manager = new StatsViewObjectManager(stats);
        stats.registerObserver(this);
        this.stats = stats;
    }

    @Override
    public void alertStatChanged(Stats stats) {
        manager.setStats(stats);
    }

    public void generateBackground() {
        setBackground(Color.ORANGE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int offset = Config.instance().INVENTORY_IMAGE_HEIGHT;
        int xOffset = 10;
        int i = 0;
        Iterator<StatsViewObject> iterator = manager.iterator();
        while(iterator.hasNext()){
            if(++i == 9){
                xOffset = Config.instance().getSidePanelWidth() /2;
                offset = Config.instance().INVENTORY_IMAGE_HEIGHT;
            }
            StatsViewObject current = iterator.next();
            current.paintComponent(g2d,xOffset,offset);
            offset+= Config.instance().INVENTORY_IMAGE_HEIGHT + 2;
        }
    }
}
