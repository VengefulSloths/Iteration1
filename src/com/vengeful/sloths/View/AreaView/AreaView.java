package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.View.AreaView.EntityMapViewObject;
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
	private EntityMapViewObject player;
	private CameraView currentCameraView;
	public EntityMapViewObject getPlayer() {
		return player;
	}
	private int count=0;
	
	public AreaView() {
		manager = new MapViewObjectManager();
		currentCameraView = new StaticCameraView(0,0,7,7);
		currentCameraView.populate(manager);

		CoordinateStrategy centered32converter = new Centered32PixelCoordinateStrategy(currentCameraView, this);

		player = new EntityMapViewObject(2,2, centered32converter, new BoundedAnimation("resources/man2/standing/man_south", 1));
		player.setWalkingN(new BoundedAnimation("resources/man2/moving/north/man_north", 5));
		player.setWalkingNE(new BoundedAnimation("resources/man2/moving/northeast/man_northeast", 5));
		player.setWalkingE(new BoundedAnimation("resources/man2/moving/east/man_east", 5));
		player.setWalkingSE(new BoundedAnimation("resources/man2/moving/southeast/man_southeast", 5));
		player.setWalkingS(new BoundedAnimation("resources/man2/moving/south/man_south", 5));
		player.setWalkingSW(new BoundedAnimation("resources/man2/moving/southwest/man_southwest", 5));
		player.setWalkingW(new BoundedAnimation("resources/man2/moving/west/man_west", 5));
		player.setWalkingNW(new BoundedAnimation("resources/man2/moving/northwest/man_northwest", 5));




		for (int i=0; i<7; i++) {
			for (int j=0; j<7; j++) {
				manager.addMapViewObject(new TerrainMapViewObject(i,j, "resources/grass.png", centered32converter));
			}
		}
		manager.addMapViewObject(player);


		
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
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
