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
	public ViewObject getPlayer() {
		return player;
	}
	private int count=0;
	
	public AreaView() {
		manager = new MapViewObjectManager();
		
		
		player = new EntityMapViewObject(150,150, 
				"resources/avatar_up.png",
				"resources/avatar_left.png",
				"resources/avatar_down.png",
				"resources/avatar_right.png");
		
		
		manager.addMapViewObject(player);

		for (int i=0; i<321; i=i+32) {
			for (int j=0; j<321; j=j+32) {
				manager.addMapViewObject(new TerrainMapViewObject(i,j, "resources/grass.png"));
			}
		}
		
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
