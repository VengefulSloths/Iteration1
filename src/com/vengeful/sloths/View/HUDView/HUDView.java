package com.vengeful.sloths.View.HUDView;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.View.Observers.StatsObserver;
import com.vengeful.sloths.View.View;

/**
 * Created by echristiansen on 2/5/2016.
 */
public class HUDView extends View implements StatsObserver {

    public static final String backgroundImageFileName = "resources/statsBackground.jpg";
    public static final String title = "Stats";

    public HUDView() {
        this.setBackgroundImageFileName(backgroundImageFileName);
    }

    @Override
    public void alertStatChanged(Stats stat) {

    }
}
