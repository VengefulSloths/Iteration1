package com.vengeful.sloths.GameLauncher;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.ActionCommandFactory.ActionCommandFactory;
import com.vengeful.sloths.Models.ActionCommandFactory.AvatarActionCommandFactory;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.View.ViewEngine;

/**
 * Created by John on 2/6/2016.
 */
public class LaunchNewGame extends LaunchGameTemplate {
    private String avatarName;
    private String avatarOccupation;

    public LaunchNewGame(ViewEngine ve, ModelEngine me, MainController controller){
        super(ve, me, controller);
    }
    public LaunchNewGame(ViewEngine ve, ModelEngine me, MainController controller, String avatarName, String avatarOccupation){
        super(ve, me, controller);
        this.avatarName = avatarName;
        this.avatarOccupation = avatarOccupation;
    }

    @Override
    protected void createCharacter(){
        ActionCommandFactory avatarActionCommandFactory = new AvatarActionCommandFactory(map);
        this.avatar = new Avatar(avatarName, avatarOccupation, new EntityStats(), avatarActionCommandFactory);
        //System.out.Println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        //System.out.Println(this.avatar.getName());
        //System.out.Println(avatarOccupation);
    }


}
