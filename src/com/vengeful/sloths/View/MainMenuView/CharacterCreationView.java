package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.CharacterCreationCommand;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommandFactory;
import com.vengeful.sloths.View.ViewAlertable;
import com.vengeful.sloths.View.ViewTime;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class CharacterCreationView extends MenuView {


    private final String DECAL_PREFIX = "resources/man2/CharacterCreation/";

    private Image avatarImage;
    private Image occupationImage;

    private TextArea nameField;

    public CharacterCreationView() {
        Config config = Config.instance();


        this.setLayout(null);
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
        this.setBackground(Color.GRAY);

        this.nameField = new TextArea(5,20);
        this.nameField.setFont(new Font("Serif", Font.BOLD, 22));
        this.nameField.setBounds(100,100,150,50);
        
        this.add(nameField);

        this.verticleSpacing = 32;
        this.verticalOffset = 298;

        children = new ArrayList<>();

        MenuCommandFactory mcf = new MenuCommandFactory();

        DefaultMenuComponent changeName = new DefaultMenuComponent(
                "resources/Menu/ChangeName",
                200,
                this.verticalOffset +(DefaultMenuComponent.HEIGTH + verticleSpacing)*menuCounter++);
        changeName.setAction(mcf.createFocusTextCommand(this.nameField));
        children.add(changeName);

        MenuOption occupationSelector = new MenuOption(
                "resources/Menu",
                200,
                this.verticalOffset +(DefaultMenuComponent.HEIGTH + verticleSpacing)*menuCounter++);

        occupationSelector.addOption("Sneak");
        occupationSelector.addOption("Smasher");
        occupationSelector.addOption("Summoner");

        children.add(occupationSelector);

        children.add(new DefaultMenuComponent(
                "resources/Menu/Confirm",
                200,
                this.verticalOffset +(DefaultMenuComponent.HEIGTH + verticleSpacing)*menuCounter++));


        this.children.get(0).setSelected(true);

        ImageIcon avatarIcon = new ImageIcon("resources/man2/CharacterCreation/AvatarDefault.png");
        ImageIcon occupationIcon = new ImageIcon(DECAL_PREFIX + "SneakDecal.png");
        this.avatarImage = avatarIcon.getImage();
        this.occupationImage = occupationIcon.getImage();


    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(avatarImage, 700, 300, this);
        g.drawImage(occupationImage, 700, 300, this);

    }

    @Override
    public void cursorLeft() {
        if (selectedIndex == 1) {
            ((MenuOption)children.get(1)).left();
            this.occupationImage = (new ImageIcon(DECAL_PREFIX + ((MenuOption)children.get(1)).getCurrent() + "Decal.png")).getImage();

        }
    }

    @Override
    public void cursorRight() {
        if (selectedIndex == 1) {
            ((MenuOption)children.get(1)).right();
            this.occupationImage = (new ImageIcon(DECAL_PREFIX + ((MenuOption)children.get(1)).getCurrent() + "Decal.png")).getImage();

        }
    }
}
