package com.vengeful.sloths.View.Observers;

import com.vengeful.sloths.Models.ViewObservable;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.Models.Map.MapItems.*;

/**
 * Created by alexs on 1/31/2016.
 */
public class ProxyEntityObserver extends ProxyObserver
        implements EntityObserver{

    private EntityObserver target;
    public ProxyEntityObserver(EntityObserver entityObserver, ViewObservable subject) {
        this.subject = subject;
        this.subject.registerObserver(this);
        this.target = entityObserver;
    }

    @Override
    public ModelObserver getModelObserver() {
        return target;
    }
    @Override
    public void alertDirectionChange(Direction d) {
        if (!deleteFlag) {
            target.alertDirectionChange(d);
        }
    }

    @Override
    public void alertMove(int x, int y, long animationTime) {
        if (!deleteFlag) {
            target.alertMove(x,y,animationTime);
        }
    }

    @Override
    public void alertDrop(int x, int y, MapItem itemToDrop) {
        System.out.println("WHO IS MY TARGET?: " + target);

        if (!deleteFlag) {
            target.alertDrop(x,y,itemToDrop);
        }
    }
}
