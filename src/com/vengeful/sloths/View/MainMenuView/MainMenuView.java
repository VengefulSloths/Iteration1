package com.vengeful.sloths.View.MainMenuView;


import com.vengeful.sloths.Utility.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class MainMenuView extends JPanel{
    ArrayList<MenuComponent> children;
    private final int verticleSpacing = 32;
    private final int verticalOffset = 320;
    private int menuItemCount = 0;
    private void init() {
        Config config = Config.instance();
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
        this.setBackground(Color.GRAY);

        children = new ArrayList<>();
        
        int menuCounter = 0;
        children.add(new MenuComponent(
                "resources/Menu/NewGame",
                config.getAreaViewWidth()/2-MenuComponent.WIDTH/2,
                this.verticalOffset +(MenuComponent.HEIGTH + verticleSpacing)*menuCounter++));
        children.add(new MenuComponent(
                "resources/Menu/LoadGame",
                config.getAreaViewWidth()/2-MenuComponent.WIDTH/2,
                this.verticalOffset +(MenuComponent.HEIGTH + verticleSpacing)*menuCounter++));
        children.get(1).setSelected(true);

    }


    public void addMenuComponent() {

    }
    public MainMenuView() {
        this.init();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MenuComponent menuComponent:
             children) {
            menuComponent.paintComponent(g);

        }
    }
}
