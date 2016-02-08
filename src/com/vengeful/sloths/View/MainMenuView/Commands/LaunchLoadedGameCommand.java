package com.vengeful.sloths.View.MainMenuView.Commands;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.GameLauncher.LaunchGameTemplate;
import com.vengeful.sloths.GameLauncher.LaunchLoadGame;
import com.vengeful.sloths.GameLauncher.LaunchNewGame;
import com.vengeful.sloths.Models.ModelEngine;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.Utility.ScreenSwitcher;
import com.vengeful.sloths.View.MainMenuView.CharacterCreationView;
import com.vengeful.sloths.View.MainMenuView.MenuContainer;
import com.vengeful.sloths.View.ViewEngine;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zach on 2/7/16.
 */
public class LaunchLoadedGameCommand extends MenuCommand {

    private ViewEngine ve;
    private MainController cont;
    private ModelEngine me;
    private String name;
    private String job;
    private CharacterCreationView cv;
    private MenuContainer mc;

    public LaunchLoadedGameCommand(){
        this.ve = ScreenSwitcher.getInstance().getViewEngine();
        this.cont = ScreenSwitcher.getInstance().getController();
        this.me = ScreenSwitcher.getInstance().getModelEngine();


    }
    @Override
    public void execute() {



        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println("launching");
                ve.killOldView();
                ve.registerView(getLoadPanel());
                LaunchGameTemplate launcher = new LaunchLoadGame(ve, me, cont);
                launcher.launch();
            }
        }, 0);



    }
    private JPanel getLoadPanel(){
        JPanel loadPanel = new JPanel();
        loadPanel.setLayout(null);
        JLabel label = new JLabel("Loading...");
        loadPanel.setPreferredSize(new Dimension(Config.getWindowWidth(),Config.getWindowHeight()));
        label.setFont(new Font("Serif", Font.BOLD, 100));
        label.setForeground(Color.WHITE);
        label.setBounds(350,0,Config.getWindowWidth(),Config.getWindowHeight());
        loadPanel.setBackground(Color.BLACK);
        loadPanel.add(label);

        return loadPanel;
    }
}
