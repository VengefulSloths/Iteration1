package com.vengeful.sloths.View.StatsView;

import com.vengeful.sloths.Models.Stats.BaseStats;
import com.vengeful.sloths.Models.Stats.EntityStats;
import com.vengeful.sloths.Models.Stats.Stats;

import java.util.ArrayList;

/**
 * Created by John on 2/5/2016.
 */
public class StatsViewObjectFactory {

    public ArrayList<StatsViewObject> generateStatsViewObjects(Stats stats){
        ArrayList<StatsViewObject> tmpList = new ArrayList<>();
        if(stats instanceof EntityStats){
            StatsViewObject tmp;

            //base stats
            //strength
            tmp = new StatsViewObject("Strength", ((EntityStats) stats).getStrength());
            tmpList.add(tmp);
            //agility
            tmp = new StatsViewObject("Agility", ((EntityStats) stats).getAgility());
            tmpList.add(tmp);
            //
            tmp = new StatsViewObject("Intellect", ((EntityStats) stats).getIntellect());
            tmpList.add(tmp);
            //
            tmp = new StatsViewObject("Movement", ((EntityStats) stats).getMovement());
            tmpList.add(tmp);

            //derived stats
            //health
            //tmp = new StatsViewObject("Health", ((EntityStats) stats).getCurrentHealth());
            //tmpList.add(tmp);
            //mana

            //xp
            //tmp = new StatsViewObject("XP", ((EntityStats) stats).getExperience());
            //tmpList.add(tmp);
            //xp to level
            //tmp = new StatsViewObject("Next Level XP", ((EntityStats) stats).getRequiredLevelXP());
            //tmpList.add(tmp);
            //offensive rating
            tmp = new StatsViewObject("Offensive Rating", ((EntityStats) stats).getOffensiveRating());
            tmpList.add(tmp);
            //defensive rating
            tmp = new StatsViewObject("Defensive Rating", ((EntityStats) stats).getDefensiveRating());
            tmpList.add(tmp);
            //Armor rating
            tmp = new StatsViewObject("Armor Rating", ((EntityStats) stats).getArmorRating());
            tmpList.add(tmp);
            //life
            tmp = new StatsViewObject("Level", ((EntityStats) stats).getLevel());
            tmpList.add(tmp);
            tmp = new StatsViewObject("Health", ((EntityStats) stats).getLife());
            tmpList.add(tmp);
            tmp = new StatsViewObject("Mana", ((EntityStats) stats).getMana());
            tmpList.add(tmp);

            //lives Left
            //tmp = new StatsViewObject("Lives Left", ((EntityStats) stats).getLivesLeft());
            //tmpList.add(tmp);


        }else if(stats instanceof BaseStats){
            StatsViewObject tmp;

            //base stats
            //strength
            tmp = new StatsViewObject("Strength", stats.getStrength());
            tmpList.add(tmp);
            //agility
            tmp = new StatsViewObject("Agility", stats.getAgility());
            tmpList.add(tmp);
            //
            tmp = new StatsViewObject("Intellect", stats.getIntellect());
            tmpList.add(tmp);
            //
            tmp = new StatsViewObject("Movement", stats.getMovement());
            tmpList.add(tmp);
        }else{
            StatsViewObject tmp;

            //base stats
            //strength
            tmp = new StatsViewObject("Strength", stats.getStrength());
            tmpList.add(tmp);
            //agility
            tmp = new StatsViewObject("Agility", stats.getAgility());
            tmpList.add(tmp);
            //
            tmp = new StatsViewObject("Intellect", stats.getIntellect());
            tmpList.add(tmp);
            //
            tmp = new StatsViewObject("Movement", stats.getMovement());
            tmpList.add(tmp);
        }
        return tmpList;
    }
}
