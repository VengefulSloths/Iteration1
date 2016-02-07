package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.GameLauncher.LaunchGameTemplate;
import com.vengeful.sloths.GameLauncher.LaunchNewGame;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.View.MainMenuView.CharacterCreationView;
import com.vengeful.sloths.View.ViewEngine;

/**
 * Created by John on 2/6/2016.
 */
public class LaunchGameCommand extends MenuCommand {

    private ViewEngine ve;
    private MainController cont;
    private ModelEngine me;
    private String name;
    private String job;
    private CharacterCreationView cv;

    public LaunchGameCommand(ViewEngine ve, ModelEngine me, MainController cont, CharacterCreationView view){
        this.ve = ve;
        this.cont = cont;
        this.me = me;
        this.cv = view;
    }
    @Override
    public void execute() {
        System.out.println("launching");
        ve.killOldView();
        String name = cv.avatarName;
        String job = cv.avatarOccupation;
        LaunchGameTemplate launcher = new LaunchNewGame(ve, me, cont, name, job);
        //cont.setAvatarState();
        launcher.launch();
    }
}
