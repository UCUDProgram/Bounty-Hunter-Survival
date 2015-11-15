package BountyHunterSurvival;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class BountySurvival extends Game {
	
	private float[] screenSize;
	private Screen tScreen, main, intro, game, score,current;
	private String player;
	
	public BountySurvival(){
	}
	
	@Override
	public void create() {
		screenSize = new float[4];
		screenSize[0]=0;
		screenSize[1]=0;
		screenSize[2]=0;
		screenSize[3]=0;
		setPlayer("Molle");
		switchScreens(1);
	}
	
	@Override
	public void render() {
		current.render(0);
	}
	
	/*
	 * Sets the screens, for easy navigation by the player, in the game
	 */
	public void switchScreens(int next){
		
		// Title Screen
		if(next==1){
			current = new TitleScreen(this);
			((TitleScreen) current).create();
			tScreen = current;
		}
		
		// Main Menu Screen
		if(next==2){
			current = new MainMenu(this);
			((MainMenu) current).create();
			main = current;
		}
		
		// Intro Screen
		if(next==3){
			current = new BountyIntro(this);
			((BountyIntro) current).create();
			intro = current;
		}
		
		// Game Screen
		if(next==4){
			current = new BountyGame(this);
			((BountyGame) current).create();
			game = current;
		}
		
		
		setScreen(current);
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}




}
