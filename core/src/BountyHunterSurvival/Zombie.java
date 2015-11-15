package BountyHunterSurvival;

import java.io.IOException;
import java.util.ArrayList;
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
	public static int direction;
	private double zombieScale;
	private static boolean active;
	private static long nextRanMove;
	
	
	/*
	 * Constructor for the Zombie Class
	 */
	public Zombie(int type, int startWall, double xPos, double yPos){
		name = setName(type);
		movementSpeed = setMovementSpeed(type);
		health = setHealth(type);
		damage = setDamage(type);
		direction = setDirection(startWall);
		moveDist = setMoveDist(type);
		zombieImages = setZombieImages(); 
		zombieImage = setInitialImage();
		zombieXPos = xPos;
		zombieYPos = yPos;
		zombieScale = .15f;
		active = false;
		nextRanMove = 0;
	}
	
	/*
	 * Returns the name of the Zombie
	 * Takes in an int, representing Zombie Type
	 */
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
	
	/*
	 * Returns the Movement Speed of the Zombie
	 * Take in an int, representing Zombie Type
	 * This will be used to help detemine how much the zombie moves in the game
	 */
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
	
	/*
	 * Returns the Initial Health of the Zombie
	 * Take in an int, representing Zombie Type
	 */
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
	
	/*
	 * Returns the Movement Distance of the Zombie
	 * Take in an int, representing Zombie Type
	 * This will be used to help detemine how much the zombie moves in the game
	 */
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
	
	/*
	 * Returns the Damage of the Zombie
	 * Take in an int, representing Zombie Type
	 * This will be used to detemine how much damage the zombie does to the player in the game
	 */
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
	
	/*
	 * Returns the Direction of the Zombie
	 * Take in an int, representing the wall the zombie will start from
	 * This will be used to detemine the initial direction of the zombie in the game
	 */
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
	
	/*
	 * Returns an Texture list, representing the Zombie images, related to the cardinal directions
	 */
	public List<Texture> setZombieImages(){
			List<Texture> ZomImg = new ArrayList <Texture>();
			try{Element root = new XmlReader().parse(Gdx.files.internal("gameImages.xml"));
			Element zombie = root.getChildByName("Zombie");
			Element zombieName = zombie.getChildByName(getName());
			String[] directions = {"Right", "Left", "Up", "Down"};
			for (int i = 0; i <4; i++){
				Element zombieDir = zombieName.getChildByName(directions[i]);
				FileHandle file = Gdx.files.internal(zombieDir.getText());
				ZomImg.add(new Texture(file));
			}
			}
			catch(IOException e){
			}
			return ZomImg;
		}
	
	/*
	 * Used to determine the Zombie's next direction.
	 */
	public void updateZombieMovement(){
		int nextMove;
		do{
			nextMove = (int) (Math.random() * 4);
		}while (nextMove == getDirection() );
		setDirection(nextMove);	
	}
	
	/*
	 * Used to set the initial image of the Zombie in the game
	 */
	public Texture setInitialImage(){
		return zombieImages.get(getDirection());
	}
	
	/*
	 * Updates the zombie's image, which will be used in the drawing of the zombie
	 */
	public void updateZombieImage(){
		int newImgRef= direction;
		Texture img = getZombieImages().get(newImgRef);
		setNewZombieImage(img);
	}
	
	/* 
	 * Sets the zombie's newest image, showing it's direction
	 * Consumes a texture to set the zombie image property
	 */
	public void setNewZombieImage(Texture newImg) {
		zombieImage = newImg;
	}
	
	/*
	 * Updates the Zombie's Position in the X Direction
	 */
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
	
	/*
	 * Updates the Zombie's Position in the Y Direction
	 */
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

	public double getZombieScale() {
		return zombieScale;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		active = active;
	}

	public static long getNextRanMove() {
		return nextRanMove;
	}

	public static void setNextRanMove() {
		nextRanMove -=1;
	}	
	
	public static void setNextRanMove(long next){
		nextRanMove =next;
	}
}
