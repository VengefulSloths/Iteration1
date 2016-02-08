package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.Controller.ControllerStates.MenuState;
import com.vengeful.sloths.View.MainMenuView.MenuContainer;

/**
 * Created by alexs on 2/4/2016.
 */
public class CharacterCreationCommand extends MenuCommand{
    private MenuContainer menuContainer;
    public CharacterCreationCommand(MenuContainer menuContainer) {
        this.menuContainer = menuContainer;
    }


    @Override
    public void execute() {
        //System.out.Println("should swap to cc");
        menuContainer.goToCharacterCreation();
    }
}
