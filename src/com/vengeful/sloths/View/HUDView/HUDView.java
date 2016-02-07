package com.vengeful.sloths.View.HUDView;

import com.vengeful.sloths.Models.Stats.Stats;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.View.Observers.StatsObserver;
import com.vengeful.sloths.View.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by echristiansen on 2/5/2016.
 */
public class HUDView extends View implements StatsObserver {

    JPanel leftPanel;
    JPanel centerPanel;
    JPanel rightPanel;

    public static final int leftPanelWidth = (int) (0.20*Config.instance().getHUDViewWidth());
    public static final int rightPanelWidth = (int) (0.15*Config.instance().getHUDViewWidth());
    public static final int centerSubPanelWidth = Config.instance().getHUDViewWidth() - leftPanelWidth - rightPanelWidth;
    public static final int subPanelHeight = (int) (Config.instance().getHUDViewHeight());
    //public static final int centerSubPanelWidth = (int) (Config.instance().getHUDViewWidth() - (2*subPanelWidth));

    public static final String backgroundImageFileName = "resources/statsBackground.jpg";
    public static final String characterImageFileName = "resources/hulk.jpg";
    public static final String livesImageFileName = "resources/lives.png";

    public static final String title = "Character Status";


    public HUDView() {
        generateTitle(title);
        this.setBackgroundImageFileName(backgroundImageFileName);
        initHUDPanel();
    }

    @Override
    public void alertStatChanged(Stats stat) {

    }


    public void generateTitle(String title) {
        titleLabel = new JLabel(title);
        Font font = new Font(titleLabel.getFont().getName(), Font.BOLD, 20);
        titleLabel.setForeground(Color.GREEN);
        titleLabel.setFont(font);
        //titleLabel.setBorder(new BevelBorder(BevelBorder.RAISED,Color.GRAY, Color.BLACK));
        this.add(titleLabel);

    }

    public void initHUDPanel() {
        this.setPreferredSize(new Dimension(this.getViewWidth(), this.getViewHeight()));
        this.setLayout(new BorderLayout());

        initLeftPanel();
        initCenterPanel();
        initRightPanel();
        this.add(this.leftPanel, BorderLayout.WEST);
        this.add(this.centerPanel, BorderLayout.CENTER);
        this.add(this.rightPanel, BorderLayout.EAST);
        this.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));

    }

    public void initLeftPanel() {
        this.leftPanel = new JPanel();
        this.leftPanel.setBackground(new Color(0f,0f,0f,0.5f));
        this.leftPanel.setPreferredSize(new Dimension(leftPanelWidth, subPanelHeight));

        JLabel nameLabel = generateTitleLabel("Smasher");
        this.leftPanel.add(nameLabel);

        JLabel levelLabel = new JLabel("Level: 126");
        this.leftPanel.add(generateCharacterImageLabel(characterImageFileName));
        this.leftPanel.add(levelLabel);
        this.leftPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));
    }

    public void initCenterPanel() {
        this.centerPanel = new JPanel();
        this.centerPanel.setPreferredSize(new Dimension(centerSubPanelWidth, subPanelHeight));
        this.centerPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));
        this.centerPanel.setBackground(new Color(0f,0f,0f,0.5f));

        this.centerPanel.setLayout(new GridLayout(4,1,0,0));

        JPanel titlePanel = new JPanel();
        titlePanel.add(generateTitleLabel("Character status"));
        titlePanel.setBackground(new Color(0f,0f,0f,0f));
        //titlePanel.setPreferredSize(new Dimension(centerSubPanelWidth, (int)(0.05*subPanelHeight)));
        this.centerPanel.add(titlePanel);

        JPanel healthPanel = new JPanel();
        JLabel healthLabel = new JLabel("     Health: ");
        healthPanel.setBackground(new Color(0f,0f,0f,0f));
        //healthPanel.setPreferredSize(new Dimension((int) (centerSubPanelWidth), (int) (0.15*subPanelHeight)));
        JProgressBar health = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        health.setValue(80);
        health.setBackground(Color.DARK_GRAY);
        health.setStringPainted(true);
        health.setForeground(Color.GREEN);
        health.setPreferredSize(new Dimension((int) (0.6*centerSubPanelWidth), (int) (0.12*subPanelHeight)));
        healthPanel.add(healthLabel);
        healthPanel.add(health);
        this.centerPanel.add(healthPanel);

        JPanel mannaPanel = new JPanel();
        JLabel mannaLabel = new JLabel("     Manna: ");
        mannaPanel.setBackground(new Color(0f,0f,0f,0f));
        JProgressBar manna = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        manna.setValue(40);
        manna.setBackground(Color.DARK_GRAY);
        manna.setStringPainted(true);
        manna.setForeground(Color.BLUE);
        manna.setPreferredSize(new Dimension((int) (0.6*centerSubPanelWidth), (int) (0.12*subPanelHeight)));
        mannaPanel.add(mannaLabel);
        mannaPanel.add(manna);
        this.centerPanel.add(mannaPanel);

        JPanel xpPanel = new JPanel();
        JLabel xpLabel = new JLabel("XP Points:");
        xpPanel.setBackground(new Color(0f,0f,0f,0f));
        JProgressBar xp = new JProgressBar(SwingConstants.HORIZONTAL, 0, 100);
        xp.setValue(60);
        xp.setBackground(Color.DARK_GRAY);
        xp.setStringPainted(true);
        xp.setForeground(Color.ORANGE);
        xp.setPreferredSize(new Dimension((int) (0.6*centerSubPanelWidth), (int) (0.12*subPanelHeight)));
        xpPanel.add(xpLabel);
        xpPanel.add(xp);
        this.centerPanel.add(xpPanel);

    }

    public void initRightPanel() {
        int livesRemaining = 3;
        this.rightPanel = new JPanel();
        this.rightPanel.setPreferredSize(new Dimension(rightPanelWidth, subPanelHeight));
        this.rightPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));
        this.rightPanel.setBackground(new Color(0f,0f,0f,0.5f));
        //this.rightPanel.setLayout(new GridLayout(4,1,0,0));
        //this.rightPanel.add(generateTitleLabel("Lives remaining"));
        JPanel livesPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        titlePanel.add(generateTitleLabel("Lives"));
        titlePanel.setBackground(new Color(0f,0f,0f,0f));
        titlePanel.setPreferredSize(new Dimension(rightPanelWidth,(int)(0.20*subPanelHeight))); //adjust the height if want to push the hearts down further
        this.rightPanel.add(titlePanel);
        livesPanel.setLayout(new GridLayout(3,1,0,10));
        livesPanel.setBackground(new Color(0f,0f,0f,0f));
        //livesPanel.setPreferredSize(new Dimension(rightPanelWidth,(int)(0.8*subPanelHeight))); //used if want hearts aligned horizontally
        //livesPanel.setLayout(new GridLayout(3,1)); //
        for (int i=0; i<livesRemaining; i++) {
            livesPanel.add(generateLivesImageLabel(livesImageFileName));
            //this.rightPanel.add(generateLivesImageLabel(livesImageFileName)); //used if want hearts aligned horizontally
        }
        this.rightPanel.add(livesPanel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //initHUDPanel();

    }

    public JLabel generateCharacterImageLabel(String imageFileName) {
        ImageIcon characterImageIcon = new ImageIcon(imageFileName);
        Image characterImage = characterImageIcon.getImage();
        characterImage=characterImage.getScaledInstance(leftPanelWidth-(int)(0.20*leftPanelWidth),(int)(subPanelHeight-(.35*subPanelHeight)), Image. SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(characterImage));
        picLabel.setBorder(new LineBorder(Color.BLACK,3));
        return picLabel;
    }

    public JLabel generateLivesImageLabel(String imageFileName) {
        ImageIcon livesImageIcon = new ImageIcon(imageFileName);
        Image livesImage = livesImageIcon.getImage();
        livesImage=livesImage.getScaledInstance(rightPanelWidth - (int)(0.7*rightPanelWidth),(int)(0.15*subPanelHeight), Image. SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(livesImage));
        return picLabel;
    }


    public JLabel generateTitleLabel(String title) {
        JLabel titleLabel = new JLabel(title);
        Font font = new Font(titleLabel.getFont().getName(), Font.BOLD, 18);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(font);
        //titleLabel.setBorder(new BevelBorder(BevelBorder.RAISED,Color.GRAY, Color.BLACK));
        return titleLabel;
    }

    }
