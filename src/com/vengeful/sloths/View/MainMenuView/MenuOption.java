package com.vengeful.sloths.View.MainMenuView;

import com.vengeful.sloths.Utility.Tuple;
import com.vengeful.sloths.View.ViewAlertable;
import com.vengeful.sloths.View.ViewTime;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Alex on 2/5/2016.
 */
public class MenuOption extends MenuComponent implements ViewAlertable{
    private MenuIcon rightArrow;
    private MenuIcon leftArrow;
    private DefaultMenuComponent mainComponent;

    private int index = 0;
    private String optionsPath;
    private ArrayList<String> options;

    private long rightEndTime = 0;
    private long leftEndTime = 0;

    public MenuOption(String optionsPath, int x, int y) {
        this.x = x;
        this.y = y;

        this.optionsPath = optionsPath;
        this.options = new ArrayList<>();

        this.rightArrow = new MenuIcon("resources/Menu/ArrowRight", this.x + 32 + DefaultMenuComponent.WIDTH, this.y);
        this.leftArrow = new MenuIcon("resources/Menu/ArrowLeft", this.x - 32 - MenuIcon.WIDTH, this.y);
        this.mainComponent = new DefaultMenuComponent("nope", this.x, this.y);

        ViewTime.getInstance().alert(300, this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        rightArrow.paintComponent(g);
        leftArrow.paintComponent(g);
        mainComponent.paintComponent(g);
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        mainComponent.setSelected(selected);
    }

    public void addOption(String optionName) {
        if (options.size() == 0) {
            mainComponent.setText(optionsPath + "/" + optionName);
        }
        options.add(optionName);
    }
    public void removeOption(String optionName) {
        options.remove(optionName);
    }
    public void left() {
        if (--index < 0) {
            index = options.size() - 1;
        }
        mainComponent.setText(optionsPath + "/" + options.get(index));
        leftArrow.setSelected(true);
        this.leftEndTime = ViewTime.getInstance().getCurrentTimeMilli() + 300;

    }

    public void right() {
        if (++index == options.size()) {
            index = 0;
        }
        mainComponent.setText(optionsPath + "/" + options.get(index));
        rightArrow.setSelected(true);
        this.rightEndTime = ViewTime.getInstance().getCurrentTimeMilli() + 300;
    }

    public String getCurrent() {
        return options.get(index);
    }

    @Override
    public void activate() {
        System.out.println("ACTIVATED");
        if (rightEndTime < ViewTime.getInstance().getCurrentTimeMilli()) {
            rightArrow.setSelected(false);
        }
        if (leftEndTime < ViewTime.getInstance().getCurrentTimeMilli()) {
            leftArrow.setSelected(false);
        }
        ViewTime.getInstance().alert(300, this);
    }
}
