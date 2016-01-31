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
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.View.AreaView.EntityObserver;
import com.vengeful.sloths.View.ViewEngine;

public class Main {

    public static void main(String[] args) {

        //create engine objects
        ViewEngine viewEngine = new ViewEngine();
        ModelEngine modelEngine = new ModelEngine();

        //set up engines
        viewEngine.setVisible(true);
        AreaView av = new AreaView();
        viewEngine.registerView(av);


        //make map factory and make a level to test with to create the map
        Map map = new Map(new Coord(10, 10));

        ActionCommandFactory avatarActionCommandFactory = new AvatarActionCommandFactory(map);

        EntityObserver eo = (EntityObserver)av.getPlayer();

        Avatar avatar = new Avatar("SlothMan", "Smasher", new EntityStats(), avatarActionCommandFactory, eo);
        map.getTile(avatar.getLocation()).addEntity(avatar);
        MainController controller = new MainController(avatar, viewEngine);
        

        //start both threads
        viewEngine.start();
        modelEngine.start();

    }
}
