package BountyHunterSurvival;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.HAlignment;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BountyIntro implements Screen, InputProcessor, ApplicationListener{

	private BountySurvival BGame;
	private SpriteBatch batch;
	private boolean pageOne, pageTwo, pageThree, pageFour, pageFive,pageSix;
	private float screenHeight, screenWidth;
	private BitmapFont font;
	private int pageCounter;
	private String instruction, instruction1;
	private Texture character;
	
	
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
		FileHandle file = Gdx.files.internal("Mole/Mole-Right.png");
		character = new Texture(file);
		
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
			instruction = "Use the Arrow keys to move Up, down, left or right";
			instruction1 = "Touch Controls are oriented around the player's location"; 
//			System.out.println("Page Two Instructions shown");
		}
		
		else if(pageThree){
			instruction = "Touch the player to fire his gun";
			instruction1 = "Beware some enemies might need more than one bullet";
//			System.out.println("Page Three Instructions shown");
		}
		else if(pageFour){
			instruction = "You have one Life, use it well";
			instruction1 = "You're health does not regenerate";
//			System.out.println("Page Three Instructions shown");
		}
		else if(pageFive){
			instruction = "Enemies will appear and move randomly";
			instruction1 = "Be careful, some enemies won't hurt you much " + 
			"while others will really hurt you.";
//			System.out.println("Page Three Instructions shown");
		}
		else {
			instruction = "Survival is not Guaranteed";
			instruction1 = "If You do survive, Riches and Fame await";
//			System.out.println("Page Three Instructions shown");
		}
	
//		font.draw(batch,instruction, screenWidth / 3, screenHeight -50);
		font.drawMultiLine(batch, instruction, 10, screenHeight -50, screenWidth - 10,HAlignment.LEFT);
		font.drawMultiLine(batch, instruction1, 10, 50, screenWidth - 10,HAlignment.LEFT);
		
		if (pageTwo){
			batch.draw(character, (float) (screenWidth * .4), (float) (screenHeight * .4), (float) (screenWidth * .20), (float) (screenHeight * .20) ); 
//			font.draw(batch, str, (float) (screenWidth * .45), y)
			font.drawWrapped(batch, "Left of player --> Move Left",(float) (screenWidth * .15), screenHeight / 2, screenWidth / 4);
			font.drawWrapped(batch, "Right of the player --> Move Right",(float) (screenWidth * .60), screenHeight / 2, screenWidth / 4);
			font.drawWrapped(batch, "Below the player--> Move Down",(float) (screenWidth * .4), (float) (screenHeight * .35), screenWidth / 4);
			font.drawWrapped(batch, "Above the player--> Move Up",(float) (screenWidth * .4), (float) (screenHeight * .70), screenWidth / 4);

		
		}
		
		
		batch.end();
	}
	
	
	
	
	
	

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		
		if(pageSix){
			BGame.switchScreens(2);
		}
		
		updatePageBooleans(pageCounter);
		pageCounter++;
		
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
		
		if(pageSix){
			BGame.switchScreens(2);
		}
		
		updatePageBooleans(pageCounter);
		pageCounter++;
		
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
