package BountyHunterSurvival;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.ArrayList;
import java.util.List;


public class BountyGame implements Screen, InputProcessor, ApplicationListener {
	private BountySurvival BHGame;
	private SpriteBatch batch;
	private Mole player1;
	private List zombieList;
	private int waveNumber;
	private float screenWidth, screenHeight;
	
	public BountyGame(BountySurvival game){
		BHGame = game;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();
		double playerStartX = screenWidth / 2;
		double playerStartY = screenHeight / 2;
		player1 = new Mole(playerStartX, playerStartY);
		
	}

	
	public void updateZombieGenerator(){
		
	}
	
	public void drawPlayer(){
		batch.draw(player1.getPlayerImage(),(float) (player1.getxPosition()),(float) (player1.getyPosition()),(float) ((player1.getPlayerImage().getWidth() * player1.getMoleScale()) ),(float) ((player1.getPlayerImage().getHeight() * player1.getMoleScale())) ); 
	}
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
//		Drawing the game components
		drawPlayer();
		
		batch.end();
	}	
	
	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render () {
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
