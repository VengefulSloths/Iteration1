package com.vengeful.sloths.View.MainMenuView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexs on 2/4/2016.
 */
public class MenuComponent extends JComponent{
    static final int WIDTH = 256;
    static final int HEIGTH = 64;

    private Image menuImageUnselected;
    private Image menuImageSelected;

    private Image textUnselected;
    private Image textSelected;
    private int y;
    private int x;

    private boolean selected = false;

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    public boolean getsSelected() {
        return selected;
    }

    static void init() {

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

        this.setPreferredSize(new Dimension(200,50));
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
