package com.vengeful.sloths.View;

import com.vengeful.sloths.View.InventoryView.ViewObjectManager;

import javax.swing.*;

/**
 * Created by John on 2/3/2016.
 */
public abstract class View extends JPanel {

    //have width and height here?
    protected int viewWidth;
    protected int viewHeight;
    protected int offset;

    public ViewObjectManager manager;

    public int getViewWidth() {
        return viewWidth;
    }
    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }
    public int getViewHeight() {
        return viewHeight;
    }
    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
        //System.out.println("SET THE VIEW HEIGHT. IT IS: " + viewHeight);
    }

    public View(){

    }

    public View(int viewWidth, int viewHeight) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }






}

