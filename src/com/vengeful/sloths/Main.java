package com.vengeful.sloths;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.Map.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world TEST");

        //make map factory and make a level to test with to create the map
        Map map = new Map();

        ActionCommandFactory avatarActionCommandFactory = new AvatarActionCommandFactory(map);

        Avatar avatar = new Avatar("SlothMan", "Smasher", new EntityStats(), avatarActionCommandFactory);



        MainController controller = new MainController(avatar);

    }
}
