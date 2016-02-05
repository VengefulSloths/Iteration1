package com.vengeful.sloths.View.MainMenuView;


import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommandFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class MainMenuView extends MenuView{

    private void init() {
        Config config = Config.instance();
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
        this.setBackground(Color.GRAY);

        this.verticleSpacing = 32;
        this.verticalOffset = 320;

        children = new ArrayList<>();
        

        this.addMenuComponent("resources/Menu/NewGame");
        this.addMenuComponent("resources/Menu/LoadGame");
        this.addMenuComponent("resources/Menu/LoadGame");
        this.addMenuComponent("resources/Menu/LoadGame");

        MenuCommandFactory menuCommandFactory = new MenuCommandFactory();

        children.get(0).setAction(menuCommandFactory.createCharacterCreationCommand());
        children.get(0).setSelected(true);

    }


    public MainMenuView() {
        this.init();
    }

}
