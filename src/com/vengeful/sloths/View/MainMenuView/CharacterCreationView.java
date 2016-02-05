package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.CharacterCreationCommand;
import com.vengeful.sloths.View.ViewAlertable;
import com.vengeful.sloths.View.ViewTime;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class CharacterCreationView extends MenuView implements ViewAlertable{

    public long leftEndTime = 0;
    public long rightEndTime = 0;

    public int currentOccupation = 0;

    private final long SELECT_TIME = 300;

    private Image avatarImage;

    private MenuIcon leftIcon;
    private MenuIcon rightIcon;

    public CharacterCreationView() {
        Config config = Config.instance();
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
        this.setBackground(Color.GRAY);

        this.verticleSpacing = 32;
        this.verticalOffset = 298;

        children = new ArrayList<>();



        this.addMenuComponent("resources/Menu/ChangeName");
        this.addMenuComponent("resources/Menu/Smasher");
        this.addMenuComponent("resources/Menu/Confirm");
        this.children.get(0).setSelected(true);

        ImageIcon avatarIcon = new ImageIcon("resources/man2/AvatarDefault.png");
        this.avatarImage = avatarIcon.getImage();

        leftIcon = new MenuIcon(
                "resources/Menu/ArrowLeft",
                Config.instance().getWindowWidth()/2 - MenuComponent.WIDTH/2 - MenuIcon.WIDTH - verticleSpacing,
                verticalOffset + verticleSpacing + MenuComponent.HEIGTH);

        rightIcon = new MenuIcon(
                "resources/Menu/ArrowRight",
                Config.instance().getWindowWidth()/2 + MenuComponent.WIDTH/2 + verticleSpacing,
                verticalOffset + verticleSpacing + MenuComponent.HEIGTH);

        ViewTime.getInstance().alert(300, this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        leftIcon.paintComponent(g);
        rightIcon.paintComponent(g);

    }

    private void changeOccupation(int index) {
        switch (index) {
            case -1:
                currentOccupation = 2;
                children.get(1).setText("resources/Menu/Summoner");
                break;
            case 0:
                children.get(1).setText("resources/Menu/Smasher");
                break;
            case 1:
                children.get(1).setText("resources/Menu/Sneak");
                break;
            case 2:
                children.get(1).setText("resources/Menu/Summoner");
                break;
            case 3:
                currentOccupation = 0;
                children.get(1).setText("resources/Menu/Smasher");
                break;
            default:
                currentOccupation = 0;
                children.get(1).setText("resources/Menu/Smasher");

        }
    }

    @Override
    public void activate() {
        System.out.println("ACTIVATED");
        if (rightEndTime < ViewTime.getInstance().getCurrentTimeMilli()) {
            rightIcon.setSelected(false);
        }
        if (leftEndTime < ViewTime.getInstance().getCurrentTimeMilli()) {
            leftIcon.setSelected(false);
        }
        ViewTime.getInstance().alert(300, this);
    }

    @Override
    public void cursorLeft() {
        if (selectedIndex == 1) {
            leftIcon.setSelected(true);
            leftEndTime = ViewTime.getInstance().getCurrentTimeMilli() + SELECT_TIME;
            changeOccupation(--currentOccupation);

        }
    }

    @Override
    public void cursorRight() {
        if (selectedIndex == 1) {
            rightIcon.setSelected(true);
            rightEndTime = ViewTime.getInstance().getCurrentTimeMilli() + SELECT_TIME;
            changeOccupation(++currentOccupation);
        }
    }
}
