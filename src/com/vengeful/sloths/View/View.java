package com.vengeful.sloths.View;

import com.vengeful.sloths.View.InventoryView.ViewObjectManager;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Created by John on 2/3/2016.
 */
public abstract class View extends JPanel {

    //have width and height here?
    protected int viewWidth;
    protected int viewHeight;
    protected int offset;

    ImageIcon backgroundImageIcon;
    JLabel backgroundImageLabel;
    Image backgroundImage;
    String backgroundImageFileName;

    protected JLabel titleLabel;
    protected String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBackgroundImageFileName(String backgroundImageName) {
        this.backgroundImageFileName = backgroundImageName;
    }

    public ViewObjectManager manager;

    public int getViewWidth() {
        return viewWidth;
    }
    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }
    public int getViewHeight() {
        return viewHeight;
    }
    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
        //System.out.println("SET THE VIEW HEIGHT. IT IS: " + viewHeight);
    }

    public View(){
        generateTitle(title);

    }

    public View(int viewWidth, int viewHeight) {
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }


    public void generateBackground(String imageName) {
        //put the generate background in a method (below)
        backgroundImageIcon = new ImageIcon(imageName);
        backgroundImageLabel = new JLabel(backgroundImageIcon);
        backgroundImageLabel.setBounds(0,0,this.getViewWidth(),this.getViewHeight()); //these don't have anything because in the default view manager this is constructed before the viewWidth, viewHeight are set
        add(backgroundImageLabel);
    }

    public void generateImageBackground(String imageName, Graphics g) {
        ImageIcon itemIcon = new ImageIcon(imageName);
        backgroundImage = itemIcon.getImage();
        g.drawImage(backgroundImage, 0, 0, this.getViewWidth(), this.getViewHeight(),this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        generateImageBackground(backgroundImageFileName, g);
    }

    public void generateBackground() {
        //put the generate background in a method (below)
        setBackground(Color.WHITE);
    }


    public void generateTitle(String title) {
        titleLabel = new JLabel(title);
        Font font = new Font(titleLabel.getFont().getName(), Font.BOLD, 16);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(font);
        //titleLabel.setBorder(new BevelBorder(BevelBorder.RAISED,Color.GRAY, Color.BLACK));
        this.add(titleLabel);


    }






}

