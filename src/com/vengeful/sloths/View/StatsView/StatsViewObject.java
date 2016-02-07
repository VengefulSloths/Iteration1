package com.vengeful.sloths.View.StatsView;

import com.vengeful.sloths.Utility.Config;

import javax.swing.*;
import java.awt.*;

/**
 * Created by John on 2/3/2016.
 */
public class StatsViewObject extends JComponent {

    private Image statIcon;
    private String statName;
    private int horizontalOffset;
    private double value;

    public StatsViewObject(String statName, int value){
        this.statName = statName;
        this.value = value;
    }

    public void paintComponent(Graphics2D g, int x, int y) {
        //g.drawImage(itemImage, x,y, this);
        g.drawImage(statIcon, x, y, 18, 18, this);
        g.setColor(Color.DARK_GRAY);
        g.drawString(statName + ": " + value, x+ horizontalOffset, y + 13); //want to draw the item image and then its name on the same line. Drawing of name is offset by the width of the image.

    }


    public void paintComponent(Graphics2D g, int x, int y, int viewWidth, int viewHeight) {
        int newHorizontalOffset = (horizontalOffset * viewWidth) - statName.length();
        g.drawImage(statIcon, x, y, 18, 18, this);
        g.setColor(Color.DARK_GRAY);
        g.drawString(statName + ": " + value, x+ (int) newHorizontalOffset, y + 13); //want to draw the item image and then its name on the same line. Drawing of name is offset by the width of the image.
    }

}
