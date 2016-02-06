package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Models.Stats.BaseStats;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.LevelFactory;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.AreaView.Cameras.CameraViewManager;
import com.vengeful.sloths.View.EquipmentView.EquipmentView;
import com.vengeful.sloths.View.EquipmentView.ListEquipmentView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.StatsView.StatsView;
import com.vengeful.sloths.View.ViewEngine;
import com.vengeful.sloths.View.ViewManager.DefaultViewManager;

/**
 * Created by alexs on 2/4/2016.
 */
public class MainMenuDriver {
    public static void main(String[] args) {
        //create engine objects
        ViewEngine viewEngine = new ViewEngine();
        ModelEngine modelEngine = new ModelEngine();



        //Create the level
        LevelFactory levelFactory = new LevelFactory();
        levelFactory.initilize("TEST");
        Map map = levelFactory.getMap();
        CameraViewManager cvm = levelFactory.getCVM();



        //TODO: right now movement is not working via ticks!!!!!, we need to create alertables with a time of 0 for movement!

        //make map factory and make a level to TimeModel with to create the map

        ActionCommandFactory avatarActionCommandFactory = new AvatarActionCommandFactory(map);
        Avatar avatar = new Avatar("SlothMan", "Smasher", new EntityStats(), avatarActionCommandFactory);
        map.getTile(avatar.getLocation()).addEntity(avatar);




        AreaView av = new AreaView(cvm, avatar);


        // Create inventory, add it to avatar and ListInventoryView
        Inventory inventory = new Inventory();
        avatar.setInventory(inventory);
        ListInventoryView iv = new ListInventoryView(inventory);

        Equipped equipped = new Equipped();
        avatar.setEquipped(equipped);
        ListEquipmentView ev = new ListEquipmentView(equipped);



        //EquipmentView ev = new EquipmentView();
        StatsView sv = new StatsView(new BaseStats(5,5,5,5,5));

        DefaultViewManager vm = new DefaultViewManager(av, iv, ev, sv);




        //make controller
        MainController controller = new MainController(avatar, viewEngine, vm);

        MenuContainer menuContainer = new MenuContainer();
        controller.getMenuState().setTarget(menuContainer);

        modelEngine.setController(controller);
        controller.setMenuState();
        //set up engines
        viewEngine.setVisible(true);
        viewEngine.registerView(menuContainer);


        //start both threads
        viewEngine.start();
        modelEngine.start();

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        //menuContainer.goToCharacterCreation();
                        //avatar.addItem(new Sword("Excal"));
                        // your code here
                    }
                },
                2000
        );

    }

}
