package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.Observers.EntityObserver;
import com.vengeful.sloths.View.Sound.SoundEffect;
import com.vengeful.sloths.View.ViewTime;
import com.vengeful.sloths.Models.Map.MapItems.*;

import java.awt.Graphics2D;
import java.awt.Image;

public class EntityMapViewObject extends ViewObject
		implements EntityObserver {

	private AnimatedImage walkingN;
	private AnimatedImage walkingNE;
	private AnimatedImage walkingE;
	private AnimatedImage walkingSE;
	private AnimatedImage walkingS;
	private AnimatedImage walkingSW;
	private AnimatedImage walkingW;
	private AnimatedImage walkingNW;

	private SoundEffect walkingSound;

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
		long t = ViewTime.getInstance().getCurrentTimeMilli();
		if (t > endTime) {
			return endX;

		}
		else return (float)(endX-startX)/(float)(endTime-startTime)*(float)(t - startTime) + (float)startX;
	}

	public float getFloatX() {
		return calculatePosition(startX, postX, animationStartTime, animationFinishTime);
	}

	public float getFloatY() {
		return 	calculatePosition(startY, postY, animationStartTime, animationFinishTime);

	}

	public EntityMapViewObject(int x, int y, CoordinateStrategy converter, String resourcePath, String walkingSoundPath, Direction facingDir) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.postX = x;
		this.postY = y;
		this.animationStartTime = 0;
		this.animationFinishTime = 0;
		this.converter = converter;

		this.walkingSound = new SoundEffect(walkingSoundPath);

		//setup all animations
		AnimatedImageFactory aif = AnimatedImageFactory.instance();
		this.setWalkingN( aif.createTimedAnimatedImage(resourcePath + "/moving/north/man_north"));
		this.setWalkingNE(aif.createTimedAnimatedImage(resourcePath + "/moving/northeast/man_northeast"));
		this.setWalkingE( aif.createTimedAnimatedImage(resourcePath + "/moving/east/man_east"));
		this.setWalkingSE(aif.createTimedAnimatedImage(resourcePath + "/moving/southeast/man_southeast"));
		this.setWalkingS( aif.createTimedAnimatedImage(resourcePath + "/moving/south/man_south"));
		this.setWalkingSW(aif.createTimedAnimatedImage(resourcePath + "/moving/southwest/man_southwest"));
		this.setWalkingW( aif.createTimedAnimatedImage(resourcePath + "/moving/west/man_west"));
		this.setWalkingNW(aif.createTimedAnimatedImage(resourcePath + "/moving/northwest/man_northwest"));


		switch (facingDir) {
			case N:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_north");
				break;
			case E:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_east");
				break;
			case S:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_south");
				break;
			case W:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_west");
				break;
			case NE:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_northeast");
				break;
			case NW:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_northwest");
				break;
			case SE:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_southeast");
				break;
			case SW:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_southwest");
				break;
			default:
				this.currentAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/standing/man_south");
				break;
		}

		//testAnimation = new BoundedAnimation("resources/man/man_down", 13);




	}
	
	public void paintComponent(Graphics2D g) {
		if (currentAnimation != null) {
			g.drawImage(currentAnimation.getCurrentImage(animationStartTime),
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
		currentAnimation.setDuration(this.animationFinishTime - this.animationStartTime);


	}
	public void alertMove(int x, int y, long animationTime) {
		this.startX = this.x;
		this.startY = this.y;
		this.postX = x;
		this.postY = y;
		this.x = x;
		this.y = y;
		this.walkingSound.play();
		currentAnimation.setDuration(animationTime);
		this.animationStartTime = ViewTime.getInstance().getCurrentTimeMilli();
		this.animationFinishTime = ViewTime.getInstance().getCurrentTimeMilli() + animationTime;

	}

	@Override
	public void alertDrop(int x, int y, MapItem itemToDrop) {
		//do nothing
	}
}
