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



public class Mole {
	private double xPosition,yPosition;
	private int health;
	public static int direction;
	private List<Texture> playerImages;
	private Texture playerImage;
	private double moleScale;
	private double moveDist = 10;
	
	/*
	 * Constructor for the Mole Player Class
	 */
	public Mole(double xPos, double yPos){
		xPosition = xPos;
		yPosition = yPos;
		direction = 0;
		health = 50;
		playerImages= setPlayerImages();
		moleScale = .15f;
		setPlayerImage();
		
	}
/*
 * Sets the Mole Player's Images, based on their direction
 * Uses an xml file to parse through the file system and select the proper images
 * in an efficient manner.
 */
	public List<Texture> setPlayerImages(){
		List<Texture> playImg = new ArrayList <Texture>();
		try{Element root = new XmlReader().parse(Gdx.files.internal("gameImages.xml"));
		Element player = root.getChildByName("Mole");
		String[] directions = {"Right", "Left", "Up", "Down"};
		for (int i = 0; i <4; i++){
			Element playDir = player.getChildByName(directions[i]);
			FileHandle file = Gdx.files.internal(playDir.getText());
			playImg.add(new Texture(file));
		}
		}
		catch(IOException e){
		}
		return playImg;
	}

	/*
	 * Updates the x position of the mole player
	 * Takes in a boolean to indicate direction 
	 * True boolean --> move to the right
	 * False boolean --> move to the left
	 */
	public void updateXPos(boolean hor){
		if(hor)
			xPosition += moveDist;
		else
			xPosition -= moveDist;
	}
	
	/*
	 * Updates the y position of the mole player
	 * Takes in a boolean to indicate direction 
	 * True boolean --> move up
	 * False boolean --> move down
	 */
	public void updateYPos(boolean vert){
		if(vert)
			yPosition += moveDist;
		else
			yPosition -= moveDist;
	}
	
	/*
	 * Update the image of the mole
	 * Used to show proper direction of the mole as the game is being played
	 */
	public void updateMoleImage(){
		int newImgRef= direction;
		Texture img = getPlayerImages().get(newImgRef);
		setNewPlayerImage(img);
	}
	
//	Getters & Setters for Mole Player
	public double getxPosition() {
		return xPosition;
	}

	public void setxPosition(double xPosition) {
		xPosition = xPosition;
	}

	public double getyPosition() {
		return yPosition;
	}

	public void setyPosition(double yPosition) {
		yPosition = yPosition;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		direction = direction;
	}

	public List<Texture> getPlayerImages() {
		return playerImages;
	}

	public void setNewPlayerImage(Texture newImg) {
		playerImage = newImg;
	}

	public void setPlayerImage() {
		playerImage = getPlayerImages().get(getDirection());
	}
	
	public Texture getPlayerImage() {
		return playerImage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		health = getHealth() - health;
	}
	
	public double getMoleScale() {
		return moleScale;
	}
	
	
}
