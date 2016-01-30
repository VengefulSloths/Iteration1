package com.vengeful.sloths;

import com.vengeful.sloths.Controller.MainController;
import com.vengeful.sloths.Models.Entity.Avatar;
import com.vengeful.sloths.Models.Stats.EntityStats;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello world TEST");
        Avatar avatar = new Avatar("Smasher", new EntityStats());

        MainController controller = new MainController(avatar);

    }
}
