package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;


public class TerrainMapViewObject extends ViewObject {

	private ArrayList<Image> terrainImages;
	
	public TerrainMapViewObject(int x, int y, String imageFile, CoordinateStrategy converter) {
		this.x = x;
		this.y = y;
		this.converter = converter;
		terrainImages = new ArrayList<>();

		ImageIcon ii = new ImageIcon(imageFile);
		terrainImages.add(ii.getImage());
	}
	public void addTerrainImage(String imageFile) {
		ImageIcon ii = new ImageIcon(imageFile);
		terrainImages.add(ii.getImage());
	}

	@Override
	public void paintComponent(Graphics2D g) {
		for (Image image:
			 terrainImages) {
			g.drawImage(image, converter.convertX(x), converter.convertY(y), this);

		}

	}

}
