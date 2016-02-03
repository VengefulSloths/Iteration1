package com.vengeful.sloths;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.LevelFactory;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.AreaView.Cameras.CameraViewManager;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.ViewEngine;
import com.vengeful.sloths.View.ViewManager.DefaultViewManager;
import com.vengeful.sloths.Models.Stats.*;

public class Main {

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
        //MainController controller = new MainController(avatar, viewEngine);


        AreaView av = new AreaView(cvm, avatar);


        // Create inventory, add it to avatar and ListInventoryView
        Inventory inventory = new Inventory();
        avatar.setInventory(inventory);


        /**** Take-able and InventoryItems need to be paired up when created */
        MapItem mi1 = new TakeableItem(new Hat("BlueHat", new BaseStats()));
        MapItem mi2 = new TakeableItem(new Hat("BlueHat", new BaseStats()));

        //avatar.addItem(new Hat("BlueHat"));
        //avatar.addItem(new Hat("BlueHat"));
        avatar.addItem(((TakeableItem)mi1).getInvItemRep());
        avatar.addItem(((TakeableItem)mi2).getInvItemRep());
        //TODO: a new factory for creating takable item + inventory item?



        ListInventoryView iv = new ListInventoryView(inventory);
        DefaultViewManager vm = new DefaultViewManager(av, iv);

        MainController controller = new MainController(avatar, viewEngine);


        //set up engines
        viewEngine.setVisible(true);
        viewEngine.registerView(vm);


        //start both threads
        viewEngine.start();
        modelEngine.start();

        new java.util.Timer().schedule(
                new java.util.TimerTask() {
                    @Override
                    public void run() {
                        avatar.addItem(new Sword("Excal"));
                        // your code here
                    }
                },
                2000
        );

    }
}
