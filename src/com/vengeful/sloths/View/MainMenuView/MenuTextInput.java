package com.vengeful.sloths.View.MainMenuView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Alex on 2/5/2016.
 */
public class MenuTextInput extends JComponent {
    private JTextField textField;
    private int x;
    private int y;
    public MenuTextInput(int x, int y) {
        this.textField = new JTextField(20);
        //this.textField.setBounds(x,y, 100, 100);
        add(textField);
        this.x = x;
        this.y = y;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        textField.paint(g);
    }

}
