package com.vengeful.sloths.Utility;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.View.MainMenuView.MainMenuView;
import com.vengeful.sloths.View.MainMenuView.MenuContainer;
import com.vengeful.sloths.View.MainMenuView.MenuView;
import com.vengeful.sloths.View.ViewEngine;

/**
 * Created by John on 2/7/2016.
 */
public class ScreenSwitcher {

    private ViewEngine viewEngine;
    private ModelEngine modelEngine;
    private MainController controller;

    private static ScreenSwitcher ourInstance = new ScreenSwitcher();

    public static ScreenSwitcher getInstance() {
        return ourInstance;
    }

    private ScreenSwitcher() {
        viewEngine = new ViewEngine();
        modelEngine = new ModelEngine();
        controller = new MainController(viewEngine);
    }

    public ViewEngine getViewEngine(){
        return this.viewEngine;
    }
    public ModelEngine getModelEngine(){
        return this.modelEngine;
    }
    public MainController getController(){
        return this.controller;
    }

    public void goToMenu(){
        MenuView mainMenuView = new MainMenuView();

        //make controller
        //MainController controller = new MainController( viewEngine);

        MenuContainer menuContainer = new MenuContainer(viewEngine, modelEngine, controller);
        controller.getMenuState().setTarget(menuContainer);

        modelEngine.setController(controller);
        controller.setMenuState();
        //set up engines
        viewEngine.setVisible(true);
        try {
            viewEngine.killOldView();
        }catch (Exception e){}
        viewEngine.registerView(menuContainer);
    }

}
