package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class MenuView extends JPanel implements MenuControllable{
    protected ArrayList<MenuComponent> children;
    protected int selectedIndex=0;
    protected int verticalOffset;
    protected int verticleSpacing;
    protected int menuCounter = 0;


    public void addMenuComponent(String textPath) {
        children.add(new MenuComponent(
                textPath,
                Config.instance().getWindowWidth()/2-MenuComponent.WIDTH/2,
                this.verticalOffset +(MenuComponent.HEIGTH + verticleSpacing)*menuCounter++));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (MenuComponent menuComponent:
                children) {
            menuComponent.paintComponent(g);

        }
    }

    public void select() {
        children.get(selectedIndex).doAction();
    }
    public void cursorUp() {
        children.get(selectedIndex).setSelected(false);
        selectedIndex--;
        if (selectedIndex == -1) {
            selectedIndex++;
        }
        children.get(selectedIndex).setSelected(true);
    }
    public void cursorDown() {
        children.get(selectedIndex).setSelected(false);
        selectedIndex++;
        if (selectedIndex == menuCounter) {
            selectedIndex--;
        }
        children.get(selectedIndex).setSelected(true);
    }
    public void cursorLeft() {

    }
    public void cursorRight() {

    }

    @Override
    public void back() {

    }
}
