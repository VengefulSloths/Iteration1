package com.vengeful.sloths.View.ViewManager;

import com.vengeful.sloths.View.View;

import javax.swing.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
public abstract class ViewManager extends JPanel {

    public abstract void selectInventoryView();
    public abstract void selectEquipView();
    public abstract void selectAreaView();
}
