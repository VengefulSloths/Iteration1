package com.vengeful.sloths.View.AreaView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Iterator;

import javax.swing.JPanel;

public class AreaView extends JPanel{

	private final int B_WIDTH = 350;
	private final int B_HEIGHT = 350;

	public int getAreaWidth() {
		return B_WIDTH;
	}
	public int getAreaHeight() {
		return B_HEIGHT;
	}
	//TODO: change to private
	public MapViewObjectManager manager;
	
	//TODO: delete this testing crap
	private ViewObject player;
	private CameraView currentCameraView;
	public ViewObject getPlayer() {
		return player;
	}
	private int count=0;
	
	public AreaView() {
		manager = new MapViewObjectManager();
		currentCameraView = new StaticCameraView(0,0,10,7);
		currentCameraView.populate(manager);

		CoordinateStrategy centered32converter = new Centered32PixelCoordinateStrategy(currentCameraView, this);

		player = new EntityMapViewObject(2,2, centered32converter,
				"resources/avatar_up.png",
				"resources/avatar_left.png",
				"resources/avatar_down.png",
				"resources/avatar_right.png");

		for (int i=0; i<10; i++) {
			for (int j=0; j<7; j++) {
				manager.addMapViewObject(new TerrainMapViewObject(i,j, "resources/grass.png", centered32converter));
			}
		}
		manager.addMapViewObject(player);


		setDoubleBuffered(true);

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		Iterator<ViewObject> iter= manager.iterator();
		while (iter.hasNext()) {
			ViewObject current = iter.next();
			current.paintComponent(g2d);
		}

		
        g2d.drawString("AreaVIEW: " + count++, 50, 50+count);
        
        Toolkit.getDefaultToolkit().sync();
	}
}
