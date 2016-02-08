package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public abstract class MenuView extends JPanel implements MenuControllable{
    protected ArrayList<MenuComponent> children;
    protected int selectedIndex=0;
    protected int verticalOffset;
    protected int verticleSpacing;
    protected int menuCounter = 0;
    protected BufferedImage bg =  null;

    public MenuView(){
        try {
            bg = ImageIO.read(new File("resources/Menu/grey_wallpaper.png"));
        }catch (Exception e){}
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(bg,0,0,Config.getWindowWidth()+50,Config.getWindowHeight()+50,null);
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
