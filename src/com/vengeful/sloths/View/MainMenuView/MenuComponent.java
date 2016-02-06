package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.View.MainMenuView.Commands.DummyCommand;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommand;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexs on 2/4/2016.
 */
public abstract class MenuComponent extends JComponent{
    protected Image menuImageUnselected;
    protected Image menuImageSelected;

    protected Image textUnselected;
    protected Image textSelected;
    protected int y;
    protected int x;

    protected boolean selected = false;

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public boolean getsSelected() {
        return selected;
    }

    protected MenuCommand action;

    public void doAction() {
        action.execute();
    }

    public void setAction(MenuCommand action) {
        this.action = action;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }


    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
