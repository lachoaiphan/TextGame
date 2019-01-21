
public class UserChar {
	private String username;
	private int level;
	private int exp;
	private int nextexp;
	private int curhealth;
	private int maxhealth;
	private int strength;
	private int defence;
	private int speed;
	
	public UserChar(String user, int l, int h, int s, int d, int sp){
		username = user;
		level = l;
		exp = 0;
		nextexp = 100;
		maxhealth = h;
		curhealth = maxhealth;
		strength = s;
		defence = d;
		speed = sp;
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
	
	public String returnName(){
		return username;
	}
	
	public void levelup(int xp, Dialog dlog){
		exp += xp;
		
		// next level up progression will be on an exponential scale
		while(exp >= nextexp){
			level += 1;
			maxhealth += 6;
			strength += 2;
			defence += 2;
			speed += 2;
			nextexp = (int) (nextexp + (nextexp * 1.5));
			dlog.printLevelUp(level);
		}
		
	}
	
	public void innRecoverHealth(){
		curhealth = maxhealth;
	}
	
	public void sustainDamage(int dmg){
		curhealth -= dmg;
		if(curhealth < 0){
			curhealth = 0;
		}
	}
	
	public int runAway(){
		return 1;
	}
	
	public void checkStats(){
		System.out.println("\nName: " + username);
		System.out.println("Level: " + level);
		System.out.println("EXP: " + exp + "/" + nextexp);
		System.out.println("\nHealth: " + curhealth + "/" + maxhealth);
		System.out.println("Strength: " + strength);
		System.out.println("Defence: " + defence);
		System.out.print("Speed: " + speed);
	}
}
