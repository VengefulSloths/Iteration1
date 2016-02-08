package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.View.MainMenuView.MenuContainer;

/**
 * Created by John on 2/6/2016.
 */
public class NameCommand extends MenuCommand {
    private MenuContainer menuContainer;
    public NameCommand(MenuContainer menuContainer) {
        this.menuContainer = menuContainer;
    }


    @Override
    public void execute() {
        //System.out.Println("should swap to name view");
        menuContainer.goToNameView();
    }
}
