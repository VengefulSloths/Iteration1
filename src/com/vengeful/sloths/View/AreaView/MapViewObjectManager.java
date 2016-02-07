package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.View.AreaView.ViewModels.AreaEffectMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ItemMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.DecalViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.TerrainMapViewObject;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class MapViewObjectManager {
	private ArrayList<ViewObject> voList;
	public MapViewObjectManager() {
		voList = new ArrayList<>();
	}

	public void clear() {
		for (ViewObject viewObject:
			 voList) {
			ObserverManager.instance().flagForDelete(viewObject);
		}
		voList.clear();
	}
	public void addMapViewObject(ViewObject vo) {
		//We can sort on iterator because it will be called less
		//System.out.println("Adding " + vo.getClass() + " to mapviewmanager");
		voList.add(vo);
	}
	public Iterator<ViewObject> iterator() {
		voList.sort(new Comparator<ViewObject>() {
			private int viewObjectClassToHeightIndex(ViewObject vo) {
				if (vo.getClass() == EntityMapViewObject.class) return 100;
				else if (vo.getClass() == ItemMapViewObject.class) return 50;
				else if (vo.getClass() == AreaEffectMapViewObject.class) return 30;
				else if (vo.getClass() == DecalViewObject.class) return 20;
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
