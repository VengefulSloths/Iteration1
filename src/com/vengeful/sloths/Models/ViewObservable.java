package com.vengeful.sloths.Models;

import com.vengeful.sloths.View.AreaView.ModelObserver;

/**
 * Created by Alex on 2/1/2016.
 */
public interface ViewObservable {
    void registerObserver(ModelObserver modelObserver);
    void deregisterObserver(ModelObserver modelObserver);
}
