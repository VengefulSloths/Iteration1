package com.vengeful.sloths.View.AreaView.ViewModels;

import com.vengeful.sloths.Utility.Direction;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImage;
import com.vengeful.sloths.View.AreaView.Animation.AnimatedImageFactory;
import com.vengeful.sloths.View.AreaView.CoordinateStrategies.CoordinateStrategy;
import com.vengeful.sloths.View.Observers.EntityObserver;
import com.vengeful.sloths.View.Sound.SoundEffect;
import com.vengeful.sloths.View.ViewAlertable;
import com.vengeful.sloths.View.ViewTime;
import com.vengeful.sloths.Models.Map.MapItems.*;

import java.awt.Graphics2D;
import java.awt.Image;

public class EntityMapViewObject extends ViewObject
		implements EntityObserver, ViewAlertable {

	private Direction facingDirection;

	private AnimatedImage levelUpAnimation;

	private AnimatedImage walkingN;
	private AnimatedImage walkingNE;
	private AnimatedImage walkingE;
	private AnimatedImage walkingSE;
	private AnimatedImage walkingS;
	private AnimatedImage walkingSW;
	private AnimatedImage walkingW;
	private AnimatedImage walkingNW;

	private AnimatedImage weaponN;
	private AnimatedImage weaponNE;
	private AnimatedImage weaponE;
	private AnimatedImage weaponSE;
	private AnimatedImage weaponS;
	private AnimatedImage weaponSW;
	private AnimatedImage weaponW;
	private AnimatedImage weaponNW;

	private AnimatedImage hatN;
	private AnimatedImage hatNE;
	private AnimatedImage hatE;
	private AnimatedImage hatSE;
	private AnimatedImage hatS;
	private AnimatedImage hatSW;
	private AnimatedImage hatW;
	private AnimatedImage hatNW;

	private SoundEffect walkingSound;
	private SoundEffect levelUpSound;
	private SoundEffect deathSound;

	private AnimatedImage currentAnimation;
	private AnimatedImage currentWeaponAnimation;
	private AnimatedImage currentHatAnimation;

	//These are for movement
	private int startX;
	private int startY;
	private int postX;
	private int postY;
	private long animationStartTime;
	private long animationFinishTime;


	private int _x;
	private int _y;
	private int _startX;
	private int _startY;
	private int _postX;
	private int _postY;
	private long _animationStartTime;
	private long _animationFinishTime;
	private long _animationTime;


	private long levelUpStartTime = 0;

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

	public void equipWeapon(String resourcePath) {
		AnimatedImageFactory aif = AnimatedImageFactory.instance();
		String resourceName = resourcePath.substring(resourcePath.lastIndexOf('/')+1);
		//System.out.Println("EQUIPPING: " + resourcePath + "/north/" + resourceName + "_North");
		this.weaponN = aif.createTimedAnimatedImage(resourcePath + "/north/" + resourceName + "_North");
		this.weaponNE = aif.createTimedAnimatedImage(resourcePath + "/northeast/" + resourceName + "_NorthEast");
		this.weaponE = aif.createTimedAnimatedImage(resourcePath + "/east/" + resourceName + "_East");
		this.weaponSE = aif.createTimedAnimatedImage(resourcePath + "/southeast/" + resourceName + "_SouthEast");
		this.weaponS = aif.createTimedAnimatedImage(resourcePath + "/south/" + resourceName + "_South");
		this.weaponSW = aif.createTimedAnimatedImage(resourcePath + "/southwest/" + resourceName + "_SouthWest");
		this.weaponW = aif.createTimedAnimatedImage(resourcePath + "/west/" + resourceName + "_West");
		this.weaponNW = aif.createTimedAnimatedImage(resourcePath + "/northwest/" + resourceName + "_NorthWest");

		switch (this.facingDirection) {
			case N:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/north/" + resourceName + "_North_1");
				break;
			case E:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/east/" + resourceName + "_East_1");
				break;
			case S:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/south/" + resourceName + "_South_1");
				break;
			case W:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/west/" + resourceName + "_West_1");
				break;
			case NE:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/northeast/" + resourceName + "_NorthEast_1");
				break;
			case NW:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/northwest/" + resourceName + "_NorthWest_1");
				break;
			case SE:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/southeast/" + resourceName + "_SouthEast_1");
				break;
			case SW:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/southwest/" + resourceName + "_SouthWest_1");
				break;
			default:
				this.currentWeaponAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "/south/" + resourceName + "_South_1");
				break;
		}
	}

	public void equipHat(String resourcePath) {
		AnimatedImageFactory aif = AnimatedImageFactory.instance();
		this.hatN = aif.createSingleFrameAnimatedImage(resourcePath + "North");
		this.hatNE = aif.createSingleFrameAnimatedImage(resourcePath + "NorthEast");
		this.hatNW = aif.createSingleFrameAnimatedImage(resourcePath + "NorthWest");
		this.hatW = aif.createSingleFrameAnimatedImage(resourcePath + "West");
		this.hatE = aif.createSingleFrameAnimatedImage(resourcePath + "East");
		this.hatS = aif.createSingleFrameAnimatedImage(resourcePath + "South");
		this.hatSE = aif.createSingleFrameAnimatedImage(resourcePath + "SouthEast");
		this.hatSW = aif.createSingleFrameAnimatedImage(resourcePath + "SouthWest");


		switch (this.facingDirection) {
			case N:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "North");
				break;
			case E:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "East");
				break;
			case S:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "South");
				break;
			case W:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "West");
				break;
			case NE:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "NorthEast");
				break;
			case NW:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "NorthWest");
				break;
			case SE:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "SouthEast");
				break;
			case SW:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "SouthWest");
				break;
			default:
				this.currentHatAnimation = AnimatedImageFactory.instance().createSingleFrameAnimatedImage(resourcePath + "South");
				break;
		}
	}

	public EntityMapViewObject(int x, int y, CoordinateStrategy converter, String resourcePath, String walkingSoundPath, Direction facingDir) {
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.postX = x;
		this.postY = y;
		this.facingDirection = facingDir;
		this.animationStartTime = 0;
		this.animationFinishTime = 0;
		this.converter = converter;

		this.walkingSound = new SoundEffect(walkingSoundPath);
		this.levelUpSound = new SoundEffect("resources/Audio/levelup.wav");
		this.deathSound = new SoundEffect("resources/Audio/death_sound.wav");

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

		this.weaponN = aif.createTimedAnimatedImage("nope");
		this.weaponNE = aif.createTimedAnimatedImage("nope");
		this.weaponE = aif.createTimedAnimatedImage("nope");
		this.weaponSE = aif.createTimedAnimatedImage("nope");
		this.weaponS = aif.createTimedAnimatedImage("nope");
		this.weaponSW = aif.createTimedAnimatedImage("nope");
		this.weaponW = aif.createTimedAnimatedImage("nope");
		this.weaponNW = aif.createTimedAnimatedImage("nope");

		this.hatN = aif.createTimedAnimatedImage("nope");
		this.hatNE= aif.createTimedAnimatedImage("nope");
		this.hatE = aif.createTimedAnimatedImage("nope");
		this.hatSE = aif.createTimedAnimatedImage("nope");
		this.hatS = aif.createTimedAnimatedImage("nope");
		this.hatSW = aif.createTimedAnimatedImage("nope");
		this.hatW = aif.createTimedAnimatedImage("nope");
		this.hatNW = aif.createTimedAnimatedImage("nope");

		this.levelUpAnimation = aif.createTimedAnimatedImage(resourcePath + "/levelup/LevelUp");

				//equipWeapon("resources/Equipment/Dagger");

		this.currentWeaponAnimation = aif.createSingleFrameAnimatedImage("nope");
		this.currentHatAnimation = aif.createSingleFrameAnimatedImage("nope");


		switch (this.facingDirection) {
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
			int x = converter.convertX(calculatePosition(startX, postX, animationStartTime, animationFinishTime));
			int y = converter.convertY(calculatePosition(startY, postY, animationStartTime, animationFinishTime));


			g.drawImage(currentAnimation.getCurrentImage(animationStartTime), x, y, this);
			g.drawImage(currentWeaponAnimation.getCurrentImage(animationStartTime), x, y, this);
			g.drawImage(currentHatAnimation.getCurrentImage(animationStartTime), x, y, this);
			g.drawImage(levelUpAnimation.getCurrentImage(levelUpStartTime), x, y, this);

		}

	}

	public void alertDirectionChange(Direction d) {
		////System.out.Println("New direction " + d);
		this.facingDirection = d;
		switch (d) {
			case N:
				currentAnimation = walkingN;
				currentWeaponAnimation = weaponN;
				currentHatAnimation = hatN;
				break;
			case NW:
				currentAnimation = walkingNW;
				currentWeaponAnimation = weaponNW;
				currentHatAnimation = hatNW;
				break;
			case W:
				currentAnimation = walkingW;
				currentWeaponAnimation = weaponW;
				currentHatAnimation = hatW;
				break;
			case SW:
				currentHatAnimation = hatSW;
				currentAnimation = walkingSW;
				currentWeaponAnimation = weaponSW;
				break;
			case S:
				currentHatAnimation = hatS;
				currentAnimation = walkingS;
				currentWeaponAnimation = weaponS;
				break;
			case SE:
				currentHatAnimation = hatSE;
				currentAnimation = walkingSE;
				currentWeaponAnimation = weaponSE;
				break;
			case E:
				currentHatAnimation = hatE;
				currentAnimation = walkingE;
				currentWeaponAnimation = weaponE;
				break;
			case NE:
				currentHatAnimation = hatNE;
				currentAnimation = walkingNE;
				currentWeaponAnimation = weaponNE;
				break;
		}
		currentAnimation.setDuration(this.animationFinishTime - this.animationStartTime);
		currentHatAnimation.setDuration(this.animationFinishTime - this.animationStartTime);
		currentWeaponAnimation.setDuration(this.animationFinishTime - this.animationStartTime);

	}
	public void alertMove(int x, int y, long animationTime) {
		ViewTime.getInstance().alert(0, this);
		this._startX = this.x;
		this._startY = this.y;
		this._postX = x;
		this._postY = y;
		this._x = x;
		this._y = y;
		this._animationTime = animationTime;


	}

	@Override
	public void activate() {
		this.startX = this._startX;
		this.startY = this._startY;
		this.postX = _postX;
		this.postY = _postY;
		this.x = _x;
		this.y = _y;
		this.walkingSound.play();
		currentAnimation.setDuration(_animationTime);
		currentHatAnimation.setDuration(_animationTime);
		currentWeaponAnimation.setDuration(_animationTime);
		this.animationStartTime = ViewTime.getInstance().getCurrentTimeMilli();
		this.animationFinishTime = animationStartTime + _animationTime;
	}

	@Override
	public void alertDrop(int x, int y, MapItem itemToDrop) {
		//do nothing
	}

	@Override
	public void alertEquipWeapon(String name) {
		//System.out.Println("View Equipping " + name );
		if (converter.getResolution() == 64) {
			this.equipWeapon("resources/64/Equipment/" + name);
		} else {
			this.equipWeapon("resources/Equipment/" + name);

		}
	}

	@Override
	public void alertEquipHat(String name) {
		//System.out.Println("View Equipping " + name );
		if (converter.getResolution() == 64) {
			this.equipHat("resources/64/Equipment/" + name + "/" + name);
		} else {
			this.equipHat("resources/Equipment/" + name + "/"  + name);

		}
	}

	@Override
	public void alertLevelUp() {
		this.levelUpStartTime = ViewTime.getInstance().getCurrentTimeMilli();
		this.levelUpSound.play();
	}

	@Override
	public void alertDeath() {
		//System.out.Println("dfdsfsdfsdafsdafsdfasdfasdfdsfd");
		this.deathSound.play();
	}
}
