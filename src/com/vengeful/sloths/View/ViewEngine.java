package com.vengeful.sloths.View;

import com.vengeful.sloths.View.AreaView.AreaView;

import javax.swing.*;

import javax.swing.JFrame;
import com.vengeful.sloths.View.AreaView.AreaView;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.EntityObserver;

import javax.swing.*;



public class ViewEngine extends JFrame implements Runnable{

    public ViewEngine(){}

    public ViewEngine(JPanel jpanel) {
        this.jpanel = jpanel;
        initUI();
    }

    private JPanel jpanel;

    private void initUI() {

        add(jpanel);

        setTitle("A game");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void run() {
        int count = 0;

        while(true) {
            long lastTime = System.currentTimeMillis();

            //Actual Code goes here

            jpanel.repaint();
            //EntityObserver eo = (EntityObserver)av.getPlayer();

            long delta = System.currentTimeMillis() - lastTime;
            if (delta < 50) {
                try {
                    Thread.sleep((50 - delta));
                } catch (Exception e) {
                    //dont care
                }

            }
            //System.out.println("View Tick");
        }
    }
    public void start() {
        new Thread(this).start();
    }

    public void registerView(JPanel jpanel){
        this.jpanel = jpanel;
        initUI();
    }
}