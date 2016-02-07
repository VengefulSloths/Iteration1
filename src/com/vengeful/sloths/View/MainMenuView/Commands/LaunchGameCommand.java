package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.GameLauncher.LaunchGameTemplate;
import com.vengeful.sloths.GameLauncher.LaunchNewGame;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.View.ViewEngine;

/**
 * Created by John on 2/6/2016.
 */
public class LaunchGameCommand extends MenuCommand {

    private ViewEngine ve;
    private MainController cont;
    private ModelEngine me;

    public LaunchGameCommand(ViewEngine ve, ModelEngine me, MainController cont){
        this.ve = ve;
        this.cont = cont;
        this.me = me;
    }
    @Override
    public void execute() {
        System.out.println("launching");
        ve.killOldView();
        LaunchGameTemplate launcher = new LaunchNewGame(ve, me, cont);
        //cont.setAvatarState();
        launcher.launch();
    }
}
