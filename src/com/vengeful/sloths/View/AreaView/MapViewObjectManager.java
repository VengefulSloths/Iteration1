package com.vengeful.sloths.View.AreaView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MapViewObjectManager {
	private ArrayList<ViewObject> voList;
	public MapViewObjectManager() {
		voList = new ArrayList<ViewObject>();
	}
	public void clear() {
		voList.clear();
	}
	public void addMapViewObject(ViewObject vo) {
		//We can sort on iterator because it will be called less
		voList.add(vo);
	}
	public Iterator<ViewObject> iterator() {
		voList.sort(new Comparator<ViewObject>() {
			private int viewObjectClassToHeightIndex(ViewObject vo) {
				if (vo.getClass() == EntityMapViewObject.class) return 100;
				else if (vo.getClass() == TerrainMapViewObject.class) return 0;
				else return 1000;
			}
			public int compare(ViewObject left, ViewObject right) {
				return viewObjectClassToHeightIndex(left) - viewObjectClassToHeightIndex(right);
			}
		});
		return voList.iterator();
	}
}
