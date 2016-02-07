package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.GameLauncher.LaunchGameTemplate;
import com.vengeful.sloths.GameLauncher.LaunchNewGame;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.View.MainMenuView.MenuContainer;
import com.vengeful.sloths.View.ViewEngine;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by John on 2/6/2016.
 */
public class LaunchGameCommand extends MenuCommand {

    private ViewEngine ve;
    private MainController cont;
    private ModelEngine me;
    private MenuContainer mc;

    public LaunchGameCommand(ViewEngine ve, ModelEngine me, MainController cont, MenuContainer mc){
        this.ve = ve;
        this.cont = cont;
        this.me = me;
        this.mc = mc;
    }
    @Override
    public void execute() {
        System.out.println("launching");

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                LaunchGameTemplate launcher = new LaunchNewGame(ve, me, cont);
                ve.killOldView();
                //cont.setAvatarState();
                launcher.launch();
            }
        }, 0);


    }
}
