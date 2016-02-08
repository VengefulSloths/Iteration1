package com.vengeful.sloths.View.StatsView;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.HUDView.HUDView;
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
    private HUDView hv;

    public static final String title = "Stats";
    public static final String backgroundImageFileName = "resources/statsBackground.jpg";
    //public static final String backgroundImageFileName = "resources/inventoryBackground.jpg";



    public StatsView(Stats stats){
        if(stats != null){stats.deregisterObserver(this);}

        generateTitle(title);
        this.setBackgroundImageFileName(backgroundImageFileName);

        this.manager = new StatsViewObjectManager(stats);
        stats.registerObserver(this);
        this.stats = stats;
    }

    @Override
    public void alertStatChanged(Stats stats) {
        //manager.setStats(stats);
        hv.setStats(stats);
    }

    public void generateBackground() {
        setBackground(Color.ORANGE);
    }

    public void setHUDView(HUDView hv){
        this.hv = hv;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //int offset = Config.instance().INVENTORY_IMAGE_HEIGHT + 10;
        int offset = 28;

        int xOffset = 17;
        int i = 0;
        Iterator<StatsViewObject> iterator = manager.iterator();
        while(iterator.hasNext()){
            if(++i == 8){
                xOffset = (Config.instance().getSidePanelWidth()/2) ;
                //offset = Config.instance().INVENTORY_IMAGE_HEIGHT + 10;
                offset = 28;
            }
            StatsViewObject current = iterator.next();
            current.paintComponent(g2d,xOffset,offset);
            //offset+= Config.instance().INVENTORY_IMAGE_HEIGHT + 2;
            offset+= 20;

        }
    }
}
