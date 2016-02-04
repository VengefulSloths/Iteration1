package com.vengeful.sloths.View.InventoryView;

import com.vengeful.sloths.View.View;

import javax.swing.*;

/**
 * Created by echristiansen on 1/30/2016.
 */
public abstract class InventoryView extends View {
    public abstract void setSelected(InventoryItemViewObject item);
    public abstract void setDeselected(InventoryItemViewObject item);
}
