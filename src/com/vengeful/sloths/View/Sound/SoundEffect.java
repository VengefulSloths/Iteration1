package com.vengeful.sloths.View.Sound;

import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;

/**
 * Created by alexs on 2/4/2016.
 */
public enum SoundEffect {
    SMASH("resources/Audio/break.wav"),   // explosion
    GRASS("resources/Audio/grass_step3.wav");

    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH
    }

    public static Volume volume = Volume.LOW;

    private Clip clip;

    SoundEffect(String soundFileName) {
        try {
            URL url = this.getClass().getClassLoader().getResource(soundFileName);
            File file = new File(soundFileName);

            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Play or Re-play the sound effect from the beginning, by rewinding.
    public void play() {
        if (volume != Volume.MUTE) {
            if (clip.isRunning())
                clip.stop();   // Stop the player if it is still running
            clip.setFramePosition(0); // rewind to the beginning
            clip.start();     // Start playing
        }
    }

    // Optional static method to pre-load all the sound files.
    public static void init() {
        values();
    }
}
