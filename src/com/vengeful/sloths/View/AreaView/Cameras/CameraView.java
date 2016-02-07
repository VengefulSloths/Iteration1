package com.vengeful.sloths.View.AreaView.Cameras;

import com.vengeful.sloths.Models.Map.Map;
import com.vengeful.sloths.Models.Map.MapItems.MapItem;
import com.vengeful.sloths.Utility.Coord;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.Utility.Tuple;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.AreaView.MapViewObjectFactory;
import com.vengeful.sloths.View.AreaView.MapViewObjectManager;
import com.vengeful.sloths.View.AreaView.ViewModels.DecalViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ViewObject;
import com.vengeful.sloths.View.Observers.EntityObserver;

import java.util.ArrayList;

public abstract class CameraView implements EntityObserver {
	protected MapViewObjectFactory mvoFactory;
	protected MapViewObjectManager mapViewObjectManager;
	protected Map map;

	protected ArrayList<Tuple<Integer,Integer,String>> decals = new ArrayList<>();

	protected int x;
	protected int y;
	protected CoordinateStrategy converter;
	protected int height;
	protected int width;
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public void setMapViewObjectFactory(MapViewObjectFactory mapViewObjectFactory) {
		this.mvoFactory = mapViewObjectFactory;
	}
	public CameraView(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	public void addDecal(int x, int y, String path) {
		this.decals.add(new Tuple<>(x,y,path));
	}

	public boolean contains(int x, int y) {
		return (this.x <= x &&
				this.y <= y &&
				this.x + this.width > x &&
				this.y + this.height > y);
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public void populate(MapViewObjectManager mvom) {
		for (Tuple decal:
			 decals) {
			mvom.addMapViewObject(mvoFactory.createDecalViewObject((String) decal.z, (int)decal.x, (int)decal.y));
		}
	}

	@Override
	public void alertDirectionChange(Direction d) {
		//do nothing
	}
	@Override
	public void alertEquipWeapon(String name) {}


	@Override
	public void alertMove(int x, int y, long animationTime) {

	}
	@Override
	public void alertDrop(int x, int y, MapItem itemToDrop) {
		mapViewObjectManager.addMapViewObject(mvoFactory.createItemMapViewObject(itemToDrop, x, y));
	}

	@Override
	public void alertEquipHat(String name) {

	}
	@Override
	public void alertLevelUp() {

	}
	@Override
	public void alertDeath() {

	}
}
