package BountyHunterSurvival;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class BountyGame implements Screen, InputProcessor, ApplicationListener {
	private BountySurvival BHGame;
	private SpriteBatch batch;
	public Mole player1;
	private List zombieList;
	private int waveNumber, levelNumber, instanceCount;
	private float screenWidth, screenHeight;
	private boolean goLeft, goRight, goUp, goDown, bulletShoot;
	private List<Bullet> bullets;
	private List <Zombie> zombies;
	private long startTime,endTime, newZombie;
	
	
	
	public BountyGame(BountySurvival game){
		BHGame = game;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();
		Gdx.input.setInputProcessor(this);
		double playerStartX = screenWidth / 2;
		double playerStartY = screenHeight / 2;
		player1 = new Mole(playerStartX, playerStartY);
		initializeMovement();
		bulletShoot = false;
		bullets = new ArrayList<Bullet>();
		zombies = new ArrayList<Zombie>();
		newZombie = 1000;
		instanceCount = 0;
		levelNumber = 1;
		InitializeZombieList();
		System.out.println("The number of zombies in the list are " + zombies.size());
	}

	
//						ADDRESSES THE PLAYER'S MOVEMENT BEHAVIOR
	public void initializeMovement(){
		goLeft = false;
		goRight = false;
		goUp = false;
		goDown = false;
	}
	
	public void updatePlayerXPos(){
		if(goRight&&player1.getxPosition()<=(screenWidth - (player1.getPlayerImage().getWidth()* player1.getMoleScale() ) ) ){
			player1.updateXPos(true);
			player1.updateMoleImage();
			
		}
		if(goLeft&&player1.getxPosition() >=0 ){
			player1.updateXPos(false);
			player1.updateMoleImage();
		}
	}
	
	public void updatePlayerYPos(){
		if(goUp&&player1.getyPosition()<=(screenHeight - (player1.getPlayerImage().getWidth()* player1.getMoleScale() ) ) ){
			player1.updateYPos(true);
			player1.updateMoleImage();
		}
		if(goDown&&player1.getyPosition() >=0 ){
			player1.updateYPos(false);
			player1.updateMoleImage();
		}
	}
	
	public void updatePlayerDirection(){
		if (goRight)
			player1.direction =0 ;
		if(goLeft)
			player1.direction = 1;
		if (goUp)
			player1.direction =2;
		if(goDown)
			player1.direction =3;
	}
	
//	public void updateBulletList(){
//		
//			for(int i=0;i<bullets.size();i++){
//			if( ( bullets.get(i).getxPosition() > screenWidth) || (bullets.get(i).getxPosition() < 0))
//				bullets.remove(bullets.get(i));
//		
//		if( ( bullets.get(i).getyPosition() > 0) || (bullets.get(i).getyPosition() > screenHeight))
//			bullets.remove(bullets.get(i));
//	
//			bullets.get(i).updateXPosition();
//			bullets.get(i).updateYPosition();
//		}
//		}
	
	public void updateBulletsXPos(){
		for(int i=0; i<bullets.size();i++)
			bullets.get(i).updateXPosition();
	}
	
	public void updateBulletsYPos(){
		for(int i=0; i<bullets.size();i++)
			bullets.get(i).updateYPosition();
	}
	
	public void updateBulletsList(){
		if(bullets != null){
			for(int i=0; i<bullets.size();i++){
				if(bullets.get(i).getxPosition() > screenWidth)
					bullets.remove(i);
				if(bullets.get(i).getxPosition() < 0)
					bullets.remove(i);
				if(bullets.get(i).getyPosition() > screenHeight)
					bullets.remove(i);
				if(bullets.get(i).getyPosition() < 0)
					bullets.remove(i);
				}
		}
	}
	
	public void bulletInitialization(){
		double xPos = player1.getxPosition();
		double yPos = player1.getyPosition();
		Bullet newBullet = new Bullet(xPos, yPos, player1.getDirection());
		bullets.add(newBullet);
		System.out.println("The size of the bullet list is " + bullets.size() );
	}
	
	
	
	public void drawBullets(){
			if(bullets!=null){
				for(int i=0;i<bullets.size();i++)
					batch.draw(bullets.get(i).getBulletImage(),(float) (bullets.get(i).getxPosition() ), (float) (bullets.get(i).getyPosition()  ), (float) (bullets.get(i).getBulletImage().getWidth() * bullets.get(i).getBulletScale()  ), (float) (bullets.get(i).getBulletImage().getHeight() * bullets.get(i).getBulletScale() ) );
		
//			aBullet.bulletDraw(aBullet);
		}
	}
//	public void bulletDraw(Bullet abullet){
//		batch.draw(abullet.getBulletImage(),(float) (abullet.getxPosition() ), (float) (abullet.getyPosition()  ), (float) (abullet.getBulletImage().getWidth()  ), (float) (abullet.getBulletImage().getHeight()  ) );
//	
//	}
	
	
	public void zombieCreator(){
		long currentTime = System.currentTimeMillis();
		if ( ((currentTime - startTime) % newZombie ) == 0)
			ZombieGenerator();
	}
//					ADDRESSSES THE CREATION OF ZOMBIES
	public void ZombieGenerator(){
		int zombieGen = (int) (Math.random() * 5) + 1;
		int start = WallGenerator();
		double yStart = zombieYStart(start);
		double xStart = zombieXStart(start);
		Zombie newZomb = new Zombie(zombieGen, start, xStart, yStart);
		zombies.add(newZomb);
	}
	
	
	public int WallGenerator(){
		int loc = (int) Math.random() * 4;
		return loc;
	}
	
	public double zombieXStart(int wallID ){
		if (wallID == 0) 
			return 0;
		else if( (wallID == 1) || (wallID == 3) )
			return Math.random() * screenWidth;
		else
			return screenWidth;
	}
	
	public double zombieYStart(int wallID ){
		if (wallID == 3) 
			return 0;
		else if( (wallID == 0) || (wallID == 0) )
			return Math.random() * screenHeight;
		else
			return screenHeight;
	}
	
	public void updateZombiesDirection(){
		for(int i=0;i < zombies.size(); i++){
			zombies.get(i).updateZombieMovement();
			zombies.get(i).updateZombieImage();
		}
	}
	
	public void InitializeZombieList(){
		int zombieCount = (int) (Math.random() * (levelNumber * 15));
		for(int i = 0; i < zombieCount; i++)
			ZombieGenerator();
	}
	
//	public void updateZombieMovement(){
//		do{
//			int nextMove = (int) (Math.random() * 4);
//		}while (nextMove == getDirection() );
//		aZombie.setDirection(nextMove);
//			
//		
//	}
	
//						DRAWS THE COMPONENTS ON THE SCREEN
	public void drawPlayer(){
		batch.draw(player1.getPlayerImage(),(float) (player1.getxPosition()),(float) (player1.getyPosition()),(float) ((player1.getPlayerImage().getWidth() * player1.getMoleScale()) ),(float) ((player1.getPlayerImage().getHeight() * player1.getMoleScale())) ); 
	}
	
	
	public void drawZombies(){
		for (Zombie aZombie: zombies)
		batch.draw(aZombie.getZombieImage(),(float) (aZombie.getZombieXPos()),(float) (aZombie.getZombieYPos()),(float) ((aZombie.getZombieImage().getWidth() * aZombie.getZombieScale()) ),(float) ((aZombie.getZombieImage().getHeight() * aZombie.getZombieScale())) ); 
	}
	
	
	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		batch.begin();
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		long startTime = System.currentTimeMillis();
		
		if(bullets!=null){
		updateBulletsXPos();
		updateBulletsYPos();
//		updateBulletsList();
		}
		
		updatePlayerXPos();
		updatePlayerYPos();
		updatePlayerDirection();
		
		for(int i = 0; i < zombies.size() ;i++){
			if (zombies.get(i).isActive()){
			zombies.get(i).updateZombieMovement();
			zombies.get(i).updateZombieImage();
			}
		}
//		player1.updateMoleImage();
		
//		Drawing the game components
		drawPlayer();
		drawZombies();
		drawBullets();
		
//		if(bullets!= null)
//			updateBulletList();
		if(bulletShoot){
			bulletInitialization();
		}
//		System.out.println("The player's Direction is " + player1.getDirection());
		
//		int bullettot
		
//		if(!bullets.isEmpty()){
//			aBullet.bulletdraw();
//			updateBulletList();
//		}
		
		
		batch.end();
	}	
	
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.RIGHT){
			goRight = true;
			player1.setDirection(0);
		}
		if(keycode == Input.Keys.LEFT){
			goLeft = true;
			player1.setDirection(1);
		}
		if(keycode == Input.Keys.UP){
			goUp = true;
			player1.setDirection(2);
		}
		if(keycode == Input.Keys.DOWN){
			goDown = true;
			player1.setDirection(3);
		}
		if( (keycode == Input.Keys.SPACE) && (instanceCount == 0)){	
			bulletShoot = true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		if(keycode == Input.Keys.RIGHT){
			goRight = false;
		}
		if(keycode == Input.Keys.LEFT){
			goLeft = false;
		}
		if(keycode == Input.Keys.UP){
			goUp = false;
		}
		if(keycode == Input.Keys.DOWN){
			goDown = false;
		}
		if(keycode == Input.Keys.SPACE){
			bulletShoot = false;
			instanceCount =0;
		}
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
		int bufferWindow = 25;
		if( ( (player1.getxPosition() + ((player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) - bufferWindow ) < screenX) 
				&& ( screenX <= (player1.getxPosition() + ( (player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) + bufferWindow ) )  
			&& ( (player1.getyPosition() + ((player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) - bufferWindow ) < screenY)  
				&& ( screenX <= (player1.getyPosition() + ( (player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) + bufferWindow ) ) ) { 
			if(instanceCount == 0){	
				bulletShoot = true;
				instanceCount++;
			}
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		bulletShoot = false;
		// TODO Auto-generated method stub
		int bufferWindow = 25;
		if( ( (player1.getxPosition() + ((player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) - bufferWindow ) < screenX) 
				&& ( screenX <= (player1.getxPosition() + ( (player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) + bufferWindow ) )  
			&& ( (player1.getyPosition() + ((player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) - bufferWindow ) < screenY)  
				&& ( screenX <= (player1.getyPosition() + ( (player1.getPlayerImage().getWidth() * player1.getMoleScale()) / 2) + bufferWindow ) ) ) { 
				bulletShoot = false;
				instanceCount = 0;
		}
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
