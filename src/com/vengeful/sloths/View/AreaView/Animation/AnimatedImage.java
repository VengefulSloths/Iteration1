package com.vengeful.sloths.View.AreaView.Animation;

import java.awt.*;

/**
 * Created by Alex on 1/30/2016.
 */
abstract public class AnimatedImage {
    protected long duration;
    public abstract Image getCurrentImage(long startTime);
    public void setDuration(long duration) {
        this.duration = duration;
    }
}
