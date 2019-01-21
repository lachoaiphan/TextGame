
public class Enemy {
	private String name;
	private int level;
	private int curhealth;
	private int maxhealth;
	private int strength;
	private int defence;
	private int speed;
	
	public Enemy(){
		name = "Red Dog Newcomer";
		level = 1;
		maxhealth = 20;
		curhealth = maxhealth;
		strength = 4;
		defence = 0;
		speed = 5;
	}

	public int returnHealth() {
		return curhealth;
	}
	
	public int returnMaxHealth(){
		return maxhealth;
	}
	
	public int returnStr() {
		return strength;
	}
	
	public int returnDef() {
		return defence;
	}
	
	public int returnSpd() {
		return speed;
	}
	
	public void sustainDamage(int dmg){
		curhealth -= dmg;
		if(curhealth < 0){
			curhealth = 0;
		}
	}
	
	public void setbackHealth(){
		curhealth = maxhealth;
	}
	
	public void checkStats(){
		System.out.println("\nName: " + name);
		System.out.println("Level: " + level);
		System.out.println("Health: " + maxhealth);
		System.out.println("Strength: " + strength);
		System.out.println("Defence: " + defence);
		System.out.print("Speed: " + speed);
	}

}
