package com.vengeful.sloths.GameLauncher;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Models.SaveLoad.Loader;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.LevelFactory;
import com.vengeful.sloths.View.MainMenuView.MainMenuView;
import com.vengeful.sloths.View.MainMenuView.MenuView;
import com.vengeful.sloths.View.ViewEngine;
import com.vengeful.sloths.View.ViewTime;

/**
 * Created by John on 2/6/2016.
 */
public class LaunchLoadGame extends LaunchGameTemplate {
    private String avatarName;
    private String avatarOccupation;
    private Loader loader;

    public LaunchLoadGame(ViewEngine ve, ModelEngine me, MainController controller){
        super(ve, me, controller);
        loader = new Loader();
        //System.out.Println(loader);
        this.avatar = loader.avatar;
    }

    @Override
    protected void createMap(){
        //Create the level
        LevelFactory levelFactory = new LevelFactory();
        levelFactory.initilize("LOAD", loader);
        this.map = levelFactory.getMap();
        this.cvm = levelFactory.getCVM();


        map.setRespawnPoint(new Coord(2,2));

    }

    @Override
    protected void createCharacter(){
        ActionCommandFactory avatarActionCommandFactory = new AvatarActionCommandFactory(this.map);

        this.avatarName = this.avatar.getName();
        this.avatarOccupation = this.avatar.getOccupation().toString();
        this.avatar.setCommandFactory(avatarActionCommandFactory);
        this.avatar.initEntityObserversList();
//        this.avatar = new Avatar(avatarName, avatarOccupation, new EntityStats(), avatarActionCommandFactory);
        //System.out.Println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //System.out.Println(this.avatar.getName());

        //System.out.Println(avatarOccupation);
        //System.out.Println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //System.out.Println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //System.out.Println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //System.out.Println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //System.out.Println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //System.out.Println(this.avatar.getInventory());

    }

    @Override
    public void launch() {
        // this.viewEngine = new ViewEngine();
        //this.modelEngine = new ModelEngine();
        ViewTime.getInstance().clear();

        //function being called by launch

        createMap();
        createCharacter();
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
