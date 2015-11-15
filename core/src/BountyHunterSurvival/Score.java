package BountyHunterSurvival;

public class Score {
	private double damageInflicted;
	private int zombiesKilled;
	private double survivalTime;
	
	public Score(){
		damageInflicted = 0.0;
		zombiesKilled = 0;
		survivalTime = 0.0;
	}

	
//	Getters & Setters for Score Methods
	public double getDamageInflicted() {
		return damageInflicted;
	}

	public void setDamageInflicted(double damageInflicted) {
		damageInflicted = getDamageInflicted() + damageInflicted;
	}

	public int getZombiesKilled() {
		return zombiesKilled;
	}

	public void setZombiesKilled() {
		zombiesKilled = getZombiesKilled() + 1;
	}

	public double getSurvivalTime() {
		return survivalTime;
	}

	public void setSurvivalTime(double survivalTime) {
		survivalTime = getSurvivalTime() + survivalTime;
	}
	

	
}
