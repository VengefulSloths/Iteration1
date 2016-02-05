package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.View.ViewEngine;

/**
 * Created by alexs on 2/4/2016.
 */
public class MainMenuDriver {
    public static void main(String[] args) {
        ViewEngine viewEngine = new ViewEngine();
        viewEngine.setVisible(true);
        viewEngine.registerView(new MainMenuView());
        viewEngine.start();
    }
}
