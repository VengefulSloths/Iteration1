package com.vengeful.sloths.View.AreaView;

import com.vengeful.sloths.Utility.Direction;

import java.awt.Graphics2D;
import java.awt.Image;

public class EntityMapViewObject extends ViewObject 
		implements EntityObserver{

	private AnimatedImage walkingN;
	private AnimatedImage walkingNE;
	private AnimatedImage walkingE;
	private AnimatedImage walkingSE;
	private AnimatedImage walkingS;
	private AnimatedImage walkingSW;
	private AnimatedImage walkingW;
	private AnimatedImage walkingNW;

	private Image currentImage;
	private AnimatedImage currentAnimation;

	//These are for movement
	private int startX;
	private int startY;
	private int postX;
	private int postY;
	private long animationStartTime;
	private long animationFinishTime;

	public void setWalkingN(AnimatedImage walkingN) {
		this.walkingN = walkingN;
	}

	public void setWalkingNE(AnimatedImage walkingNE) {
		this.walkingNE = walkingNE;
	}

	public void setWalkingE(AnimatedImage walkingE) {
		this.walkingE = walkingE;
	}

	public void setWalkingSE(AnimatedImage walkingSE) {
		this.walkingSE = walkingSE;
	}

	public void setWalkingS(AnimatedImage walkingS) {
		this.walkingS = walkingS;
	}

	public void setWalkingSW(AnimatedImage walkingSW) {
		this.walkingSW = walkingSW;
	}

	public void setWalkingW(AnimatedImage walkingW) {
		this.walkingW = walkingW;
	}

	public void setWalkingNW(AnimatedImage walkingNW) {
		this.walkingNW = walkingNW;
	}

	private float calculatePosition(int startX, int endX, long startTime, long endTime) {
		long t = System.currentTimeMillis();
		if (t > endTime) {
			return endX;

		}
		else return (float)(endX-startX)/(float)(endTime-startTime)*(float)(t - startTime) + (float)startX;
	}

	public EntityMapViewObject(int x, int y, CoordinateStrategy converter, AnimatedImage standingImage) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.postX = x;
		this.postY = y;
		this.animationStartTime = 0;
		this.animationFinishTime = 0;
		this.converter = converter;

		this.currentAnimation = standingImage;

		//testAnimation = new BoundedAnimation("resources/man/man_down", 13);




	}
	
	public void paintComponent(Graphics2D g) {
		if (currentAnimation != null) {
			g.drawImage(currentAnimation.getCurrentImage(animationStartTime, animationFinishTime),
					//g.drawImage(currentImage,
					converter.convertX(calculatePosition(startX, postX, animationStartTime, animationFinishTime)),
					converter.convertY(calculatePosition(startY, postY, animationStartTime, animationFinishTime)),
					this);
		}

	}

	public void alertDirectionChange(Direction d) {
		//System.out.println("New direction " + d);
		System.out.println("Drection is now " + d);
		switch (d) {
			case N:
				currentAnimation = walkingN;
				break;
			case NW:
				currentAnimation = walkingNW;
				break;
			case W:
				currentAnimation = walkingW;
				break;
			case SW:
				currentAnimation = walkingSW;
				break;
			case S:
				currentAnimation = walkingS;
				break;
			case SE:
				currentAnimation = walkingSE;
				break;
			case E:
				currentAnimation = walkingE;
				break;
			case NE:
				currentAnimation = walkingNE;
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
