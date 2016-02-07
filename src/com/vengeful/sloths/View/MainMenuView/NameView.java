package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommandFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by John on 2/6/2016.
 */
public class NameView extends MenuView {

    private JFrame ve;

    private void init() {
        Config config = Config.instance();
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
        this.setBackground(Color.GRAY);

        this.verticleSpacing = 32;
        this.verticalOffset = 320;

        children = new ArrayList<>();


        this.addMenuComponent("resources/Menu/NewGame");


        MenuCommandFactory menuCommandFactory = new MenuCommandFactory();

        //children.get(0).setAction(menuCommandFactory.createCharacterCreationCommand());
        //children.get(0).setSelected(true);

        //setLocation(400, 400);
        JTextField nameField= new JTextField(12);
        nameField.setBackground(Color.DARK_GRAY);
        nameField.setSize(100,50);
        nameField.setBounds(110,100,100,100);
        nameField.setPreferredSize(new Dimension(100, 100));

        this.setLayout(new GridLayout());
        this.add(nameField);

        nameField.setSize(100,50);
        nameField.setBounds(110,100,100,100);

        setSize(300, 170);
        setVisible(true);
    }





    public void addMenuComponent(String textPath) {
        children.add(new DefaultMenuComponent(
                textPath,
                Config.instance().getWindowWidth()/2-DefaultMenuComponent.WIDTH/2,
                this.verticalOffset +(DefaultMenuComponent.HEIGTH + verticleSpacing)*menuCounter++));
    }

    public NameView(JFrame ve){
        this.ve = ve;
        this.init();}
}
