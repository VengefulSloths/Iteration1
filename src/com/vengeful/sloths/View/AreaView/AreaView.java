package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Models.Entity.Entity;
import com.vengeful.sloths.Models.ObserverManager;
import com.vengeful.sloths.Utility.Config;
import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.Cameras.CameraView;
import com.vengeful.sloths.View.AreaView.Cameras.CameraViewManager;
import com.vengeful.sloths.View.Observers.EntityObserver;
import com.vengeful.sloths.View.AreaView.ViewModels.EntityMapViewObject;
import com.vengeful.sloths.View.AreaView.ViewModels.ViewObject;
import com.vengeful.sloths.Models.Map.MapItems.*;
import com.vengeful.sloths.View.View;


import java.awt.*;
import java.util.Iterator;

import javax.swing.JPanel;

public class AreaView extends View
					implements EntityObserver {


	//TODO: change to private
	public MapViewObjectManager mapViewObjectManager;
	
	//TODO: delete this testing crap
	private EntityMapViewObject player;
	private CameraView currentCameraView;
	private CameraViewManager cameraViewManager;

	//These are used to change camaras
	private boolean changeCameraFlag;
	private int playerX;
	private int playerY;
	public EntityMapViewObject getPlayer() {
		return player;
	}
	private int count=0;

	private Entity playerModel;

	public static final String backgroundImageFileName = "resources/desert.jpg";

	public AreaView(CameraViewManager cvm, Entity player) {

		this.setBackgroundImageFileName(backgroundImageFileName);
		//this.setBackground(new Color(0f,1f,1f,.1f));
		this.setBackground(Color.BLACK);

		this.playerModel = player;

		mapViewObjectManager = new MapViewObjectManager();
		this.cameraViewManager  = cvm;
		this.currentCameraView = cvm.getCameraView(player.getLocation().getX(), player.getLocation().getY(), this.playerModel);
		currentCameraView.populate(mapViewObjectManager);

		player.registerObserver(this);
		
		setPreferredSize(new Dimension(Config.instance().getAreaViewWidth(), Config.instance().getAreaViewHeight()));
		setDoubleBuffered(true);

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;

		if (this.changeCameraFlag) {
			//Deregister current camera view!!!
			ObserverManager.instance().flagForDelete(currentCameraView);
			currentCameraView = cameraViewManager.getCameraView(playerX, playerY, this.playerModel);
			mapViewObjectManager.clear();
			currentCameraView.populate(mapViewObjectManager);
			changeCameraFlag = false;

		}
		Iterator<ViewObject> iter= mapViewObjectManager.iterator();
		while (iter.hasNext()) {
			ViewObject current = iter.next();
			current.paintComponent(g2d);
		}

		
        g2d.drawString("AreaVIEW: " + count++, 50, 50+count);
        
        Toolkit.getDefaultToolkit().sync();
	}

	@Override
	public void alertDirectionChange(Direction d) {
		//do nothing
	}

	@Override
	public void alertMove(int x, int y, long timeMicro) {
		if (!currentCameraView.contains(x,y)) {
			this.changeCameraFlag = true;
			this.playerX = x;
			this.playerY = y;
		}
	}

	@Override
	public void alertDrop(int x, int y, MapItem itemToDrop) {

	}

	@Override
	public void alertEquipWeapon(String name) {
	}

	@Override
	public void alertEquipHat(String name) {

	}
}
