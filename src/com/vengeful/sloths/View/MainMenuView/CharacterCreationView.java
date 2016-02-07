package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.MainMenuView.Commands.CharacterCreationCommand;
import com.vengeful.sloths.View.MainMenuView.Commands.MenuCommandFactory;
import com.vengeful.sloths.View.ViewAlertable;
import com.vengeful.sloths.View.ViewTime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * Created by alexs on 2/4/2016.
 */
public class CharacterCreationView extends MenuView {

    private JFrame ve;

    private final String DECAL_PREFIX = "resources/man2/CharacterCreation/";

    private Image avatarImage;
    private Image occupationImage;
    private DefaultMenuComponent borderHack;
    private TextArea nameField;

    public CharacterCreationView(JFrame ve) {
        this.ve = ve;
        Config config = Config.instance();



        this.setLayout(null);
        this.setPreferredSize(new Dimension(config.getWindowWidth(), config.getWindowHeight()));
        this.setBackground(Color.GRAY);

        this.nameField = new TextArea("",1,20,TextArea.SCROLLBARS_NONE);
        this.nameField.setBackground(Color.DARK_GRAY);
        this.nameField.setFont(new Font("Serif", Font.BOLD, 36));
        this.nameField.setForeground(Color.WHITE);
        this.nameField.setBounds(208,225,240,50);
        this.nameField.setRows(1);

        this.verticleSpacing = 32;
        this.verticalOffset = 298;

        children = new ArrayList<>();

        MenuCommandFactory mcf = new MenuCommandFactory();


       borderHack = new DefaultMenuComponent("resources/Menu/ChangeName",
                200,
                218);

        DefaultMenuComponent changeName = new DefaultMenuComponent(
                "resources/Menu/ChangeName",
                200,
                this.verticalOffset +(DefaultMenuComponent.HEIGTH + verticleSpacing)*menuCounter++);
        changeName.setAction(mcf.createFocusTextCommand(this.nameField, borderHack));
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

        JPanel j = this;
        TextArea nameArea = this.nameField;
        KeyListener swagswaglikecaillou = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    ve.requestFocus();
                    String s = nameArea.getText();
//deleting the last character (newline)
                    s = s.substring(0, s.length() - 1);
//and setting that text to your TextArea
                    nameArea.setText(s);
                    borderHack.setSelected(false);
                }
            }
        };


        this.nameField.addKeyListener(swagswaglikecaillou);
        this.add(nameField);
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(avatarImage, 700, 300, this);
        g.drawImage(occupationImage, 700, 300, this);
        borderHack.paintComponent(g);

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
