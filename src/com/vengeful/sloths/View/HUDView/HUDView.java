package com.vengeful.sloths.View.HUDView;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.View.Observers.StatsObserver;
import com.vengeful.sloths.View.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by echristiansen on 2/5/2016.
 */
public class HUDView extends View implements StatsObserver {

    public static final String backgroundImageFileName = "resources/statsBackground.jpg";
    public static final String title = "Character Status";

    public HUDView() {
        generateTitle(title);
        this.setBackgroundImageFileName(backgroundImageFileName);
    }

    @Override
    public void alertStatChanged(Stats stat) {

    }


    public void generateTitle(String title) {
        titleLabel = new JLabel(title);
        Font font = new Font(titleLabel.getFont().getName(), Font.BOLD, 16);
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(font);
        this.add(titleLabel);

    }

}
