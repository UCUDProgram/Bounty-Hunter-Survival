package BountyHunterSurvival;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class Bullet {
	private double xPosition;
	private double yPosition;
	private double damage;
	private int direction;
	private boolean active;
	private double bullSpeed, bullSpeedBase, bulletScale;
	private Texture bulletImage;
	
	
	/*
	 * Constructor for the Bullet Class
	 */
	public Bullet(double xPos, double yPos, int dir){
		xPosition = xPos;
		yPosition = yPos;
		direction = dir;
		bulletImage = setBulletImage();
		damage = 30;
		active = true;
		bullSpeed = .30;
		bullSpeedBase = 30;
		bulletScale = .25f;
	}

	/*
	 * Updates the Bullet's X Position, in both directions.
	 */
	public void updateXPosition(){
		if (direction == 0)
			xPosition += (bullSpeed * bullSpeedBase);
		if (direction == 1)
			xPosition -= (bullSpeed * bullSpeedBase);
	}
	
	/*
	 * Updates the Bullet's Y Position, in both directions.
	 */
	public void updateYPosition(){
		if (direction == 2)
			yPosition +=  (bullSpeed * bullSpeedBase);
		if (direction == 3)
			yPosition -=  (bullSpeed * bullSpeedBase);
	}
	
	/*
	 * Sets the Bullet's Image, in relation to the direction that the bullet will travel in
	 */
	public Texture setBulletImage(){
		List<Texture> bulletImg = new ArrayList <Texture>();
		try{Element root = new XmlReader().parse(Gdx.files.internal("gameImages.xml"));
		Element player = root.getChildByName("Bullet");
		String[] directions = {"Right", "Left", "Up", "Down"};
		for (int i = 0; i <4; i++){
			Element playDir = player.getChildByName(directions[i]);
			FileHandle file = Gdx.files.internal(playDir.getText());
			bulletImg.add(new Texture(file));
		}
		}
		catch(IOException e){
		}
		return bulletImg.get(getDirection());
	}
	
// Getters & Setters for Bullet Properties
	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		this.xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		this.yPosition = yPosition;
	}

	public double getDamage() {
		return damage;
	}

	public int getDirection() {
		return direction;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		active = active;
	}

	public Texture getBulletImage() {
		return bulletImage;
	}

	public double getBulletScale() {
		return bulletScale;
	}	
}
