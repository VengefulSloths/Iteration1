package com.vengeful.sloths.GameLauncher;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Inventory.Equipped;
import com.vengeful.sloths.Models.Inventory.Inventory;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Hat;
import com.vengeful.sloths.Models.InventoryItems.EquippableItems.Sword;
import com.vengeful.sloths.Models.InventoryItems.InventoryItem;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Models.Map.MapItems.TakeableItem;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.TimeModel.TimeModel;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.LevelFactory;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.AreaView.Cameras.CameraViewManager;
import com.vengeful.sloths.View.EquipmentView.ListEquipmentView;
import com.vengeful.sloths.View.HUDView.HUDView;
import com.vengeful.sloths.View.InventoryView.ListInventoryView;
import com.vengeful.sloths.View.MainMenuView.MainMenuView;
import com.vengeful.sloths.View.MainMenuView.MenuView;
import com.vengeful.sloths.View.StatsView.StatsView;
import com.vengeful.sloths.View.ViewEngine;
import com.vengeful.sloths.View.ViewManager.DefaultViewManager;
import com.vengeful.sloths.View.ViewTime;

/**
 * Created by John on 2/6/2016.
 */
public abstract class LaunchGameTemplate {

    protected Map map;
    protected CameraViewManager cvm;
    protected Avatar avatar;
    protected DefaultViewManager vm;
    protected ModelEngine modelEngine;
    protected ViewEngine viewEngine;
    protected MainController controller;

    //order
    //createMap > createCharacter > createInventory > CreateEquippted > setLocation > createViews > setUpController
    public LaunchGameTemplate(){}

    public LaunchGameTemplate(ViewEngine ve, ModelEngine me, MainController cont){
        this.viewEngine = ve;
        this.controller = cont;
        this.modelEngine = me;
    }

    protected void createCharacter(){
        ActionCommandFactory avatarActionCommandFactory = new AvatarActionCommandFactory(map);
        this.avatar = new Avatar("SlothMan", "Smasher", new EntityStats(), avatarActionCommandFactory);
    }

    protected void createInventory(){
        Inventory inventory = new Inventory();
        avatar.setInventory(inventory);
    }
    protected void createEquipped(){
        Equipped equipped = new Equipped();
        avatar.setEquipped(equipped);
    }

    protected void createMap(){
        //Create the level
        LevelFactory levelFactory = new LevelFactory();
        //levelFactory.initilize("TEST");
        levelFactory.initilize("DEMO", null);
        this.map = levelFactory.getMap();

        //map.setRespawnPoint(new Coord(2,2));
        map.setRespawnPoint(new Coord(2,8));
        this.cvm = levelFactory.getCVM();
    }

    protected void setAvatarLocation(){
        map.getTile(avatar.getLocation()).addEntity(avatar);
    }

    protected void createViews(){
        AreaView av = new AreaView(cvm, avatar);
        ListInventoryView iv = new ListInventoryView(avatar.getInventory());
        ListEquipmentView ev = new ListEquipmentView(avatar.getEquipped());
        HUDView hv = new HUDView(avatar);
        StatsView sv = new StatsView(avatar.getEntityStats());
        sv.setHUDView(hv);
        this.vm = new DefaultViewManager(av, iv, ev, sv, hv);
        viewEngine.killOldView();
        viewEngine.setVisible(true);
        viewEngine.registerView(vm);
        avatar.getEntityStats().alertObservers();
    }

    protected void setUpController(){
        //MainController controller = new MainController(avatar, viewEngine, vm);
        controller.setViewManager(vm);
        controller.setAvatar(avatar);

        controller.setMap(map);
        controller.setAvatarState();
        modelEngine.setController(controller);
    }
    public void launch() {
       // this.viewEngine = new ViewEngine();
        //this.modelEngine = new ModelEngine();
        ViewTime.getInstance().clear();

        //function being called by launch
        createMap();
        createCharacter();
        createInventory();
        createEquipped();
        setAvatarLocation();
        createViews();
        setUpController();


        MenuView mainMenuView = new MainMenuView();

        //TODO: something about menu view

        //start both threads
       // viewEngine.start();
        //modelEngine.start();
    }

}
