package com.vengeful.sloths.View.AreaView;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class EntityMapViewObject extends ViewObject 
		implements EntityObserver{
	
	private final Image entityDown;
	private final Image entityLeft;
	private final Image entityRight;
	private final Image entityUp;
	private Image currentImage;
	
	public EntityMapViewObject(int x, int y, CoordinateStrategy converter, String up, String right, String down, String left) {
		this.x = x;
		this.y = y;
		this.converter = converter;
		
		ImageIcon iiu = new ImageIcon(up);
		ImageIcon iir = new ImageIcon(right);
		ImageIcon iid = new ImageIcon(down);
		ImageIcon iil = new ImageIcon(left);

		entityUp = iiu.getImage();
		entityRight = iir.getImage();
		entityDown = iid.getImage();
		entityLeft = iil.getImage();

		currentImage = entityDown;
	}
	
	void paintComponent(Graphics2D g) {
		g.drawImage(currentImage, converter.convertX(x),converter.convertY(y), this);

	}
	
	public void alertDirectionChange(Direction d) {
		switch (d) {
			case UP: 
				currentImage = entityUp;
				break;
			case LEFT: 
				currentImage = entityLeft;
				break;
			case DOWN: 
				currentImage = entityDown;
				break;
			case RIGHT: 
				currentImage = entityRight;
				break;
		}
			
	}
	public void alertMove(int x, int y) {
		
	}

}
