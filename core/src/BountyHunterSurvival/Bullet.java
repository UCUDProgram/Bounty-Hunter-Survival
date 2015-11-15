package BountyHunterSurvival;

public class Bullet {
	private double xPosition;
	private double yPosition;
	private double damage;
	private int direction;
	private boolean active;
	private double bullSpeed, bullSpeedBase;
	
	public Bullet(double xPos, double yPos, int dir){
		xPosition = xPos;
		yPosition = yPos;
		direction = dir;
		damage = 30;
		active = true;
		bullSpeed = .30;
		bullSpeedBase = 30;
	}

	public void updateXPosition(){
		if (direction == 0)
			xPosition = getxPosition() + (bullSpeed * bullSpeedBase);
		if (direction == 1)
			xPosition = getxPosition() - (bullSpeed * bullSpeedBase);
	}
	
	public void updateYPosition(){
		if (direction == 2)
			yPosition = getyPosition() +  (bullSpeed * bullSpeedBase);
		if (direction == 3)
			yPosition = getyPosition() -  (bullSpeed * bullSpeedBase);
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
}
