package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.View.MainMenuView.Commands.DummyCommand;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alexs on 2/5/2016.
 */
public class MenuIcon extends DefaultMenuComponent {
    public static int HEIGHT = 64;
    public static int WIDTH = 64;
    public MenuIcon(String textPath, int x, int y) {
        super(textPath,x,y);
//        this.x = x;
//        this.y = y;
//
        ImageIcon menuItemUnselected = new ImageIcon("resources/Menu/MenuItemSmall.png");
        ImageIcon menuItemSelected = new ImageIcon("resources/Menu/MenuItemSmall_Selected.png");
//
//        this.textUnselected = textUnselected.getImage();
//        this.textSelected = textSelected.getImage();
        this.menuImageSelected = menuItemSelected.getImage();
        this.menuImageUnselected = menuItemUnselected.getImage();
//
//        action = new DummyCommand();
//
//        this.setPreferredSize(new Dimension(320,64));
//        this.menuImageUnselected = (new ImageIcon("resources/Menu/MenuItemSmall.png")).getImage();
//        this.menuImageUnselected = (new ImageIcon("resources/Menu/MenuItemSmall_Selected.png")).getImage();

    }
}
