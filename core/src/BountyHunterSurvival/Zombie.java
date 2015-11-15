package BountyHunterSurvival;

import java.io.IOException;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class Zombie {
	private String name;
	private double movementSpeed,health,damage,zombieXPos,zombieYPos, moveDist  ;
	private List<Texture> zombieImages;
	private Texture zombieImage;
	private int direction;
	
	
	
	public Zombie(int type, int startWall, double xPos, double yPos){
		name = setName(type);
		movementSpeed = setMovementSpeed(type);
		health = setHealth(type);
		damage = setDamage(type);
		direction = setDirection(startWall);
		moveDist = setMoveDist(type);
		setZombieImages(); 
		zombieImage = setInitialImage();
		zombieXPos = xPos;
		zombieYPos = yPos;
	}
	
	public String setName(int type){
		if (type == 1)
			return "Frankenstein";
		else if(type == 2)
			return "Mummy";
		else if(type == 3)
			return "Werewolf";
		else if(type == 4)
			return "Igor";
		else
			return "Dracula";
	}
	
	public double setMovementSpeed(int type){
		if (type == 1)
			return .75;
		if (type == 2)
			return .6;
		if (type == 3)
			return .5;
		if (type == 4)
			return .2;
		else
			return .1;
	}
	
	
	public double setHealth(int type){
		if (type == 1)
			return 20;
		if (type == 2)
			return 25;
		if (type == 3)
			return 30;
		if (type == 4)
			return 50;
		else
			return 75;
	}
	
	public double setMoveDist(int type){
		if ((type == 1) || (type ==2))
			return 30;
		if (type == 3)
			return 22;
		if (type == 4)
			return 45;
		else
			return 40;
		
	}
	
	public double setDamage(int type){
		if (type == 1)
			return 5;
		if (type == 2)
			return 10;
		if (type == 3)
			return 15;
		if (type == 4)
			return 30;
		else
			return 40;
	}
	
	public int setDirection(int wall){
		if(wall == 0)
			return 0;
		else if(wall == 1)
			return 3;
		else if(wall == 2)
			return 1;
		else
			return 2;
	}
	
	public void setZombieImages(){
			try{Element root = new XmlReader().parse(Gdx.files.internal("gameImages.xml"));
			Element zombie = root.getChildByName("Zombie");
			Element zombieName = zombie.getChildByName(getName());
			String[] directions = {"Right", "Left", "Up", "Down"};
			for (int i = 0; i <4; i++){
				Element zombieDir = zombieName.getChildByName(directions[i]);
				FileHandle file = Gdx.files.internal(zombieDir.getText());
				zombieImages.add(new Texture(file));
			}
			}
			catch(IOException e){
			}
		}
	
	public Texture setInitialImage(){
		return zombieImages.get(getDirection());
	}
	
	
	
//	public double initialXPos(int wall){
//		if( (wall == 1) || (wall == 3) )
//			return (double) (Math.random() * screenWidth);
//	}
//	
//	public double initialYPos(int wall){
//		
//	}
	
	public void updateXPosition(){
		double xPos;
		if (getDirection() == 0){
			xPos = getZombieXPos() + (getMovementSpeed() * getMoveDist() );
			setZombieXPos(xPos);
		}
		if (getDirection() == 1){
			xPos = getZombieXPos() - (getMovementSpeed() * getMoveDist() );
			setZombieXPos(xPos);
		}
	}
	
	public void updateYPosition(){
		double yPos;
		if (getDirection() == 0){
			yPos = getZombieYPos() + (getMovementSpeed() * getMoveDist() );
			setZombieYPos(yPos);
		}
		if (getDirection() == 1){
			yPos = getZombieYPos() - (getMovementSpeed() * getMoveDist() );
			setZombieYPos(yPos);
		}
	}

	
	
	//Getters & Setters for Zombies
	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	public Texture getZombieImage() {
		return zombieImage;
	}
	
	
	public void setZombieImage() {
		zombieImage = zombieImages.get(getDirection());
	}

	public void setZombieImage(Texture zombieImage) {
		this.zombieImage = zombieImage;
	}

	public double getZombieXPos() {
		return zombieXPos;
	}

	public void setZombieXPos(double zombieXPos) {
		zombieXPos = zombieXPos;
	}

	public double getZombieYPos() {
		return zombieYPos;
	}

	public void setZombieYPos(double zombieYPos) {
		zombieYPos = zombieYPos;
	}

	public String getName() {
		return name;
	}

	public double getMovementSpeed() {
		return movementSpeed;
	}

	public double getDamage() {
		return damage;
	}

	public List<Texture> getZombieImages() {
		return zombieImages;
	}

	public int getDirection() {
		return direction;
	}

	public double getMoveDist() {
		return moveDist;
	}
	
	
	
	
}
