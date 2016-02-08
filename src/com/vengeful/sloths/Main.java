package com.vengeful.sloths;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.GameLauncher.LaunchGameTemplate;
import com.vengeful.sloths.GameLauncher.LaunchNewGame;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.LevelFactory;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.AreaView.Cameras.CameraViewManager;
import com.vengeful.sloths.View.EquipmentView.EquipmentView;
import com.vengeful.sloths.View.EquipmentView.ListEquipmentView;
import com.vengeful.sloths.View.HUDView.HUDView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.MainMenuView.MainMenuView;
import com.vengeful.sloths.View.MainMenuView.MenuContainer;
import com.vengeful.sloths.View.MainMenuView.MenuView;
import com.vengeful.sloths.View.StatsView.StatsView;
import com.vengeful.sloths.View.ViewEngine;
import com.vengeful.sloths.View.ViewManager.DefaultViewManager;

public class Main {

    public static void main(String[] args) {

        //create engine objects
        ViewEngine viewEngine = new ViewEngine();
        ModelEngine modelEngine = new ModelEngine();


        MenuView mainMenuView = new MainMenuView();

        //make controller
        MainController controller = new MainController( viewEngine);

        MenuContainer menuContainer = new MenuContainer(viewEngine, modelEngine, controller);
        controller.getMenuState().setTarget(menuContainer);

        modelEngine.setController(controller);
        controller.setMenuState();
        //set up engines
        viewEngine.setVisible(true);
        viewEngine.registerView(menuContainer);
        //beginning test

//        Loader l = new Loader();
  //      Object o = l.avatar;
    //    System.out.println(o.toString());


        Loader l = new Loader();
        Object o = l.avatar;
        System.out.println(((Entity) o).getInventory().toString());


        System.out.println(((Entity) o).getOccupation());
        //start both threads
        viewEngine.start();
        modelEngine.start();
    }
}
