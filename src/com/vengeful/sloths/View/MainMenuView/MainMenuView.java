package com.vengeful.sloths.View.MainMenuView;


import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommandFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class MainMenuView extends MenuView{

    BufferedImage logo;
    BufferedImage bg;

    private void init() {
        Config config = Config.instance();
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));

        //this.setBackground(Color.GRAY);


        this.verticleSpacing = 32;
        this.verticalOffset = 320;

        children = new ArrayList<>();
        try {
            bg = ImageIO.read(new File("resources/Menu/grey_wallpaper.png"));
            logo = ImageIO.read(new File("resources/Menu/game_logo.png"));
        }catch (Exception e){}


        this.addMenuComponent("resources/Menu/NewGame");
        this.addMenuComponent("resources/Menu/LoadGame");


        MenuCommandFactory menuCommandFactory = new MenuCommandFactory();

        children.get(0).setAction(menuCommandFactory.createCharacterCreationCommand());
        children.get(0).setSelected(true);
        children.get(1).setAction(menuCommandFactory.createLaunchLoadedGameCommand());

    }

    public void addMenuComponent(String textPath) {
        children.add(new DefaultMenuComponent(
                textPath,
                Config.instance().getWindowWidth()/2-DefaultMenuComponent.WIDTH/2,50+
                this.verticalOffset +(DefaultMenuComponent.HEIGTH + verticleSpacing)*menuCounter++));
    }

    public MainMenuView() {
        this.init();
    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        g.drawImage(logo,350,50, null);


    }

}
