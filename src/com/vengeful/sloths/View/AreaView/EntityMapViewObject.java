package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Utility.AnimatedImage;
import com.vengeful.sloths.Utility.BoundedAnimation;
import com.vengeful.sloths.Utility.Direction;

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
	private AnimatedImage testAnimation;

	//These are for movement
	private int startX;
	private int startY;
	private int postX;
	private int postY;
	private long animationStartTime;
	private long animationFinishTime;

	private float calculatePosition(int startX, int endX, long startTime, long endTime) {
		long t = System.currentTimeMillis();
		if (t > endTime) {
			return endX;
		}
		else return (float)(endX-startX)/(float)(endTime-startTime)*(float)(t - startTime) + (float)startX;
	}

	public EntityMapViewObject(int x, int y, CoordinateStrategy converter, String up, String right, String down, String left) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.postX = x;
		this.postY = y;
		this.animationStartTime = 0;
		this.animationFinishTime = 0;
		this.converter = converter;

		testAnimation = new BoundedAnimation("resources/man/man_down", 13);

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
		System.out.println("X.x = " + calculatePosition(startX, postX, animationStartTime, animationFinishTime));
		g.drawImage(testAnimation.getCurrentImage(animationStartTime,animationFinishTime),
		//g.drawImage(currentImage,
					converter.convertX(calculatePosition(startX, postX, animationStartTime, animationFinishTime)),
					converter.convertY(calculatePosition(startY, postY, animationStartTime, animationFinishTime)),
					this);

	}

	public void alertDirectionChange(Direction d) {
		System.out.println("New direction " + d);
		switch (d) {
			case N:
				currentImage = entityUp;
				break;
			case W:
				currentImage = entityLeft;
				break;
			case S:
				currentImage = entityDown;
				break;
			case E:
				currentImage = entityRight;
				break;
		}
			
	}
	public void alertMove(int x, int y, long animationTime) {
		this.startX = this.x;
		this.startY = this.y;
		this.postX = x;
		this.postY = y;
		this.x = x;
		this.y = y;

		this.animationStartTime = System.currentTimeMillis();
		this.animationFinishTime = System.currentTimeMillis() + animationTime;
	}

}
