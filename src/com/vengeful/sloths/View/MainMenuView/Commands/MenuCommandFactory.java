package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.Controller.ControllerStates.MenuState;
import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.GameLauncher.LaunchGameTemplate;
import com.vengeful.sloths.GameLauncher.LaunchNewGame;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.View.MainMenuView.CharacterCreationView;
import com.vengeful.sloths.View.MainMenuView.DefaultMenuComponent;
import com.vengeful.sloths.View.MainMenuView.MenuContainer;
import com.vengeful.sloths.View.ViewEngine;

import javax.swing.*;
import java.awt.*;

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

    public MenuCommand createNameCommand(){return new NameCommand(MENU);}

    public MenuCommand createFocusTextCommand(TextArea textField, DefaultMenuComponent hack) {
        return new FocusTextCommand(textField, hack);
    }


    public MenuCommand createlaunchGameCommand(ViewEngine ve, ModelEngine me, MainController cont, CharacterCreationView view){

        return new LaunchGameCommand(ve, me, cont, view, MENU);

    }
}
