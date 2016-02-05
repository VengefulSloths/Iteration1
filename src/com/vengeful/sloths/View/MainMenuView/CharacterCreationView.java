package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.CharacterCreationCommand;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class CharacterCreationView extends MenuView {
    public CharacterCreationView() {
        Config config = Config.instance();
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
        this.setBackground(Color.GRAY);

        this.verticleSpacing = 100;
        this.verticalOffset = 0;

        children = new ArrayList<>();


        this.addMenuComponent("resources/Menu/LoadGame");
        this.addMenuComponent("resources/Menu/NewGame");

    }
}
