package com.vengeful.sloths;

import com.sun.glass.ui.View;
import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.Utility.LevelFactory;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.AreaView.CameraViewManager;
import com.vengeful.sloths.View.AreaView.EntityObserver;
import com.vengeful.sloths.View.ViewEngine;

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
        MainController controller = new MainController(avatar, viewEngine);

        //set up engines
        viewEngine.setVisible(true);
        AreaView av = new AreaView(cvm, avatar);
        viewEngine.registerView(av);

        //start both threads
        viewEngine.start();
        modelEngine.start();

    }
}
