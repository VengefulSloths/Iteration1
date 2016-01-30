package com.vengeful.sloths.View.AreaView;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;


public class TerrainMapViewObject extends ViewObject {

	private Image terrainImage;
	
	public TerrainMapViewObject(int x, int y, String imageFile) {
		this.x = x;
		this.y = y;
		
		ImageIcon ii = new ImageIcon(imageFile);
		terrainImage = ii.getImage();
	}
	@Override
	void paintComponent(Graphics2D g) {
		g.drawImage(terrainImage, x, y, this);

	}

}
