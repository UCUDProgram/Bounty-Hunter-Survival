package BountyHunterSurvival;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BountyIntro implements Screen, InputProcessor, ApplicationListener{

	private BountySurvival BGame;
	private SpriteBatch batch;
	private boolean pageOne, pageTwo, pageThree, pageFour, pageFive,pageSix;
	private float screenHeight, screenWidth;
	private BitmapFont font;
	private int pageCounter;
	private String instruction, instruction1;
	
	
	public BountyIntro(BountySurvival game){
		BGame = game;
	}
	
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		font = new BitmapFont();
		booleanInitial();
		pageCounter=0;
		screenHeight = Gdx.graphics.getHeight(); 
		screenWidth = Gdx.graphics.getWidth();
		Gdx.input.setInputProcessor(this);
		
	}
	
	public void booleanInitial(){
		pageOne = true;
		pageTwo = false;
		pageThree = false;
		pageFour = false;
		pageFive = false;
		pageSix = false;
	}
	
	public void pageTwoInstruct(){
		pageOne = false;
		pageTwo = true;
		pageThree = false;
		pageFour = false;
		pageFive = false;
		pageSix = false;
	}
	
	public void pageThreeInstruct(){
		pageOne = false;
		pageTwo = false;
		pageThree = true;
		pageFour = false;
		pageFive = false;
		pageSix = false;
	}
	
	public void pageFourInstruct(){
		pageOne = false;
		pageTwo = false;
		pageThree = false;
		pageFour = true;
		pageFive = false;
		pageSix = false;
	}
	
	public void pageFiveInstruct(){
		pageOne = false;
		pageTwo = false;
		pageThree = false;
		pageFour = false;
		pageFive = true;
		pageSix = false;
	}

	public void pageSixInstruct(){
		pageOne = false;
		pageTwo = false;
		pageThree = false;
		pageFour = false;
		pageFive = false;
		pageSix = true;
	}
	
	public void updatePageBooleans(int current){
		if (current == 0)
			pageTwoInstruct();
		if (current == 1)
			pageThreeInstruct();
		if (current == 2)
			pageFourInstruct();
		if (current == 3)
			pageFiveInstruct();
		if (current == 4)
			pageSixInstruct();
		}
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(pageOne){
			instruction = "You have travelled through time and into a dimension where zombies run the world";
			instruction1 = "You're Transport has been disabled, You must fight through waves of zombies until help arrives";
//			System.out.println("Page One Instructions shown");
		}
		
		else if(pageTwo){
			instruction = "Page Two Instructions";
//			System.out.println("Page Two Instructions shown");
		}
		
		else if(pageThree){
			instruction = "Page Three Instructions";
//			System.out.println("Page Three Instructions shown");
		}
		else if(pageThree){
			instruction = "Page Three Instructions";
//			System.out.println("Page Three Instructions shown");
		}
		else if(pageThree){
			instruction = "Page Three Instructions";
//			System.out.println("Page Three Instructions shown");
		}
		else if(pageThree){
			instruction = "Page Three Instructions";
//			System.out.println("Page Three Instructions shown");
		}
		else {
			instruction = "Page Four Instructions";
//			System.out.println("Page Four Instructions shown");
		}
		font.draw(batch,instruction, screenWidth / 3, screenHeight -50);
		
		
		
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
	public void render() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
	
}
