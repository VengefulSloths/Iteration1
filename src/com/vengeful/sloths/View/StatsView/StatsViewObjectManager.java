package com.vengeful.sloths.View.StatsView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by John on 2/3/2016.
 */
public class StatsViewObjectManager {
    private ArrayList<StatsViewObject> statsList;

    //InventoryItemViewObject GodSwordItemViewObject = new InventoryItemViewObject(new Sword("GodSword"));
    //InventoryItemViewObject PartyHatItemViewObject = new InventoryItemViewObject(new Hat("Blue Partyhat"));

    public StatsViewObjectManager() {
        statsList = new ArrayList<StatsViewObject>();


    }

    public void addStatsViewObject(StatsViewObject stat) { //rename populate(InventoryItemViewObject item)?
        //We can sort on iterator because it will be called less
        statsList.add(stat);
    }


    public int getItemListSize() {
        return statsList.size();
    }

    public Iterator<StatsViewObject> iterator() {
        return statsList.iterator();
    }

}

