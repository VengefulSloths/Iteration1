package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommandFactory;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexs on 2/4/2016.
 */
public class MenuContainer extends JPanel implements MenuControllable{
    private MainMenuView mainMenuView;
    private CharacterCreationView characterCreationView;
    private NameView nameView;
    private JFrame ve;


    private MenuView currentMenuView;
    public MenuContainer(JFrame ve) {

        this.ve = ve;
        MenuCommandFactory.init(this);
        setLayout(new CardLayout());

        this.mainMenuView = new MainMenuView();
        this.characterCreationView = new CharacterCreationView(ve);
        this.nameView = new NameView(ve);
        add(this.mainMenuView, "Main Menu");
        add(this.characterCreationView, "Character Creation");
        add(this.nameView, "Name Your Character");

        this.currentMenuView = this.mainMenuView;
        setPreferredSize(new Dimension(Config.instance().getWindowWidth(), Config.instance().getWindowHeight()));
    }



    public MenuView getMainMenuView() {
        return mainMenuView;
    }

    public CharacterCreationView getCharacterCreationView() {
        return characterCreationView;
    }

    public void goToMainMenu() {
        ((CardLayout) this.getLayout()).show(this, "Main Menu");
        this.currentMenuView = mainMenuView;
    }
    public void goToCharacterCreation() {
        ((CardLayout) this.getLayout()).show(this, "Character Creation");
        this.currentMenuView = characterCreationView;
    }

    public void goToNameView(){
        ((CardLayout) this.getLayout()).show(this, "Name Your Character");
        this.currentMenuView = nameView;
    }

    @Override
    public void select() {
        currentMenuView.select();
    }

    @Override
    public void cursorUp() {
        currentMenuView.cursorUp();
    }

    @Override
    public void cursorDown() {
        currentMenuView.cursorDown();
    }

    @Override
    public void cursorLeft() {
        currentMenuView.cursorLeft();
    }

    @Override
    public void cursorRight() {
        currentMenuView.cursorRight();
    }

    @Override
    public void back() {
        goToMainMenu();
    }


}
