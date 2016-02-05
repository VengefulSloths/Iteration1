package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.Controller.ControllerStates.MenuState;
import com.vengeful.sloths.View.MainMenuView.MenuContainer;

/**
 * Created by alexs on 2/4/2016.
 */
public class MenuCommandFactory {
    private static MenuContainer MENU;

    public static void init(MenuContainer menuContainer) {
        MENU = menuContainer;
    }

    public MenuCommand createCharacterCreationCommand() {
        return new CharacterCreationCommand(MENU);
    }
}
