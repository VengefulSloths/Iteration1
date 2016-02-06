package com.vengeful.sloths.View.Observers;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.View.StatsView.StatsViewObject;

/**
 * Created by John on 2/3/2016.
 */
public interface StatsObserver extends ModelObserver {
    public void alertStatChanged(Stats stat);
}
