package BountyHunterSurvival;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class MainMenu implements Screen, InputProcessor, ApplicationListener {
	private BountySurvival BHGame;
	private SpriteBatch batch;
	private float screenHeight, screenWidth,scaleX,scaleY;
	private Skin skin;
	private Table table;
	private Stage stage;
	private Texture character;
	
	/* 
	 * Constructor for the main Menu class
	 */
	public MainMenu(BountySurvival game){
		BHGame = game;
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		batch = new SpriteBatch();
		stage = new Stage();
		skin = new Skin (Gdx.files.internal("uiskin.json"));
		screenHeight = Gdx.graphics.getHeight(); 
		screenWidth = Gdx.graphics.getWidth();
		scaleX = screenWidth/640;
		scaleY = screenHeight/480;
		table = new Table(skin);
		FileHandle file = Gdx.files.internal("Mole/Mole-Right.png");
		character = new Texture(file);
		addPlayButton();
		addStoryButton();
		table.setFillParent(true);
		table.right();
		stage.addActor(table);
		Gdx.input.setInputProcessor(this);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.draw(character, 50, 50, screenWidth / 2, (2 * (screenHeight / 3) ) );
		batch.end();
		stage.draw();
	}

	/*
	 * Add the Play button button on the Main Menu Screen
	 *  Used to get to the game, by the player
	 */
	public void addPlayButton(){
		final TextButton button = new TextButton("Play",skin);
		button.setName("Play");
		table.add(button).width(button.getWidth()*scaleX).height(button.getHeight()*scaleY);
		table.row();
		button.addListener(new ClickListener(){
//			@Override
			public void clicked(InputEvent event, float x, float y) {
				BHGame.switchScreens(4);
			}
		});
	}
	
	/*
	 * Add the Story button button on the Main Menu Screen
	 *  Used to get to game Background Information, by the player
	 *  Information includes the story Background, basic controls and words of wisdom in the game
	 */
	public void addStoryButton(){
		final TextButton button = new TextButton("Story Background",skin);
		button.setName("Story Background");
		table.add(button).width(button.getWidth()*scaleX).height(button.getHeight()*scaleY);
		table.row();
		button.addListener(new ClickListener(){
//			@Override
			public void clicked(InputEvent event, float x, float y) {
				BHGame.switchScreens(3);
			}
		});
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
	public void render() {
		// TODO Auto-generated method stub
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
	public void dispose() {
		// TODO Auto-generated method stub
	}	
}