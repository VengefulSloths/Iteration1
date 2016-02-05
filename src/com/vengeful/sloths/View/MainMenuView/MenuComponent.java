package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.View.MainMenuView.Commands.DummyCommand;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommand;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexs on 2/4/2016.
 */
public class MenuComponent extends JComponent{
    static final int WIDTH = 256;
    static final int HEIGTH = 64;

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

    public void setText(String textPath) {
        ImageIcon textUnselected = new ImageIcon(textPath + ".png");
        ImageIcon textSelected = new ImageIcon(textPath + "_Selected.png");
        this.textUnselected = textUnselected.getImage();
        this.textSelected = textSelected.getImage();
    }

    public MenuComponent(String textPath, int x, int y) {
        this.x = x;
        this.y = y;

        ImageIcon menuItemUnselected = new ImageIcon("resources/Menu/MenuItem.png");
        ImageIcon menuItemSelected = new ImageIcon("resources/Menu/MenuItem_Selected.png");
        ImageIcon textUnselected = new ImageIcon(textPath + ".png");
        ImageIcon textSelected = new ImageIcon(textPath + "_Selected.png");

        this.textUnselected = textUnselected.getImage();
        this.textSelected = textSelected.getImage();
        this.menuImageSelected = menuItemSelected.getImage();
        this.menuImageUnselected = menuItemUnselected.getImage();

        action = new DummyCommand();

        this.setPreferredSize(new Dimension(320,64));
    }

    public void setAction(MenuCommand action) {
        this.action = action;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (!selected) {
            g2d.drawImage(menuImageUnselected, x, y, this);
            g2d.drawImage(textUnselected, x, y, this);
        } else {
            g2d.drawImage(menuImageSelected, x, y, this);
            g2d.drawImage(textSelected, x, y, this);
        }


    }
}
