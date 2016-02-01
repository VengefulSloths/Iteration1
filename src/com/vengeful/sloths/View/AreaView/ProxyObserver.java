package com.vengeful.sloths.View.AreaView;

/**
 * Created by alexs on 1/31/2016.
 */
public abstract class ProxyObserver {
    protected boolean deleteFlag;
    public abstract ModelObserver getModelObserver();
    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
    public boolean getDeleteFlag() {
        return this.deleteFlag;
    }
}
