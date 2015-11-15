package BountyHunterSurvival;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class TitleScreen implements Screen, InputProcessor, ApplicationListener {
	private BountySurvival BHGame;
	private SpriteBatch batch;
	private float screenHeight, screenWidth,scaleX, scaleY;
	private Texture background, hunter;
	private String title;
	private BitmapFont titleFont;
	private Stage stage;
	private Table table;
	private Skin skin;
	
	
	/*
	 * Constructor for the Title Screen Class
	 */
	public TitleScreen(BountySurvival game){
		BHGame = game;
	}
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();
		FileHandle file = Gdx.files.internal("Mole/Mole-Stance.png");
		hunter = new Texture(file);
		title = "Bounty Hunter Survival";
		titleFont = new BitmapFont();
		stage = new Stage();
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		table = new Table(skin);
		scaleX = screenWidth/640;
		scaleY = screenHeight/480;
		addMenuButton();
		table.setFillParent(true);
		table.right();
		stage.addActor(table);
		Gdx.input.setInputProcessor(this);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		batch.begin();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.draw(hunter, 50, 50, screenWidth/3, screenHeight/2);
		titleFont.setScale(3, 3);
		titleFont.draw(batch, title, 20,(int) (screenHeight - 100));
		batch.end();
		stage.draw();
	}
	
	/*
	 *  Adds the Main Menu button to the Title Screen 
	 */
	public void addMenuButton(){
		final TextButton button = new TextButton("Main Menu",skin);
		button.setName("Main Menu");
		table.add(button).width(button.getWidth()*scaleX).height(button.getHeight()*scaleY);
		table.row();
		button.addListener(new ClickListener(){
//			@Override
			public void clicked(InputEvent event, float x, float y) {
				BHGame.switchScreens(2);
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
//		BHGame.switchScreens(2);
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
//		BHGame.switchScreens(2);
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
