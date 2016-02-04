package com.vengeful.sloths.View.AreaView;




import com.vengeful.sloths.View.Observers.EntityObserver;
import com.vengeful.sloths.View.Sound.SoundEffect;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;

public class driver extends JFrame{

    // Constructor
    public driver() {
        // Pre-load all the sound files
        //SoundEffect.init();
        SoundEffect.volume = SoundEffect.Volume.LOW;  // un-mute

        // Set up UI components
        Container cp = this.getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnSound1 = new JButton("Sound 1");
        btnSound1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SoundEffect.SMASH.play();
            }
        });
        cp.add(btnSound1);
        JButton btnSound2 = new JButton("Sound 2");
        btnSound2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SoundEffect.SMASH.play();
            }
        });
        cp.add(btnSound2);
        JButton btnSound3 = new JButton("Sound 3");
        btnSound3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //SoundEffect.SMASH.play();
            }
        });
        cp.add(btnSound3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test SoundEffct");
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new driver();
    }
}