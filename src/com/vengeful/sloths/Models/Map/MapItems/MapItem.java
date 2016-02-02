package com.vengeful.sloths.Models.Map.MapItems;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.ViewObservable;
import com.vengeful.sloths.View.AreaView.MapItemObserver;
import com.vengeful.sloths.View.AreaView.ModelObserver;

/**
 * Created by John on 1/30/2016.
 */
public abstract class MapItem implements ViewObservable{

    protected MapItemObserver observer;
    protected boolean destroy = false;
    protected String itemName;

    public abstract void interact(Entity entity);

    public boolean canMove(){
        return true;
    }

    public String getItemName(){
        return this.itemName;
    }


    @Override
    public void registerObserver(ModelObserver modelObserver) {
        this.observer = (MapItemObserver) observer;
    }

    @Override
    public void deregisterObserver(ModelObserver modelObserver) {
        this.observer = null;
    }
}
