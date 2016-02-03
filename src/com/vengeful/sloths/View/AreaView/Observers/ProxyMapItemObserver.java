package com.vengeful.sloths.View.AreaView.Observers;

import com.vengeful.sloths.Models.Map.MapItems.MapItem;

/**
 * Created by Alex on 2/1/2016.
 */
public class ProxyMapItemObserver extends ProxyObserver
        implements MapItemObserver{

    private MapItemObserver target;
    public ProxyMapItemObserver(MapItemObserver target, MapItem subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
        this.target = target;
    }
    @Override
    public ModelObserver getModelObserver() {
        return target;
    }

    @Override
    public void alertDestroyed() {
        target.alertDestroyed();
    }
}
