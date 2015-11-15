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
	private int direction;
	private List<Texture> playerImages;
	private Texture playerImage;
	private double moleScale;
	
	public Mole(double xPos, double yPos){
		xPosition = xPos;
		yPosition = yPos;
		direction = 0;
		health = 50;
		playerImages= setPlayerImages();
		moleScale = .25f;
		setPlayerImage();
		
	}

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

//	public void updateXPos(){
//		if()
//	}
//	
//	public void updateYPos(){
//		if()
//	}
//	
	
//	Getters & Setters for Mole
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
