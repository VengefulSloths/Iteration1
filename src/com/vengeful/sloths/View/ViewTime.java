package com.vengeful.sloths.View;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Alex on 2/3/2016.
 */
public class ViewTime {
    private long currentTimeMilli;
    private static ViewTime instance = null;
    private CopyOnWriteArrayList<AbstractMap.SimpleEntry<ViewAlertable, Long>> subjects;
    private ViewTime() {
        this.subjects = new CopyOnWriteArrayList<>();
        this.currentTimeMilli = System.currentTimeMillis();
    }
    public static ViewTime getInstance() {
        if (instance == null) {
            instance = new ViewTime();
        }
        return instance;
    }
    public void tick() {
        this.currentTimeMilli = System.currentTimeMillis();

        Iterator<AbstractMap.SimpleEntry<ViewAlertable, Long>> iter = subjects.iterator();
        ArrayList<AbstractMap.SimpleEntry<ViewAlertable, Long>> toDelete = new ArrayList<>();
        while (iter.hasNext()) {

            AbstractMap.SimpleEntry<ViewAlertable, Long> next = iter.next();
            if (currentTimeMilli > next.getValue()) {
                toDelete.add(next);
                next.getKey().activate();
            }
        }
        for (int i = 0; i < toDelete.size(); i++) {
            subjects.remove(toDelete.get(i));
        }

    }
    public long getCurrentTimeMilli() {
        return currentTimeMilli;
    }
    public void alert(long time, ViewAlertable subject) {
        this.subjects.add(new AbstractMap.SimpleEntry<ViewAlertable, Long>(subject, currentTimeMilli + time));
    }
}
