
public class BattleSystem {

	public BattleSystem(){
		
	}
	
	public int dealtDamage(UserChar u, Enemy e, int t){
		int str = 0, def = 0, dmg;
		if(t == 0){ // enemy's turn
			str = e.returnStr();
			def = u.returnDef();
		}
		else if(t == 1){ // player's turn
			str = u.returnStr();
			def = e.returnDef();
		}
		dmg = str - def;
		
		if(dmg < 0) { // if damage is negative
			dmg = 0;
		}
		
		if(t == 0){ // enemy deals damage
			u.sustainDamage(dmg);
		}
		else if(t == 1){ // player deals damage
			e.sustainDamage(dmg);
		}
		
		return dmg;
	}
	
	public int dodgeAttack(UserChar u, Enemy e, int t){
		int spd1 = 0, spd2 = 1; // indicators speeds for player and enemy
		double chance; // holds value for chance of missing/attacking
		double rand = Math.random(); // holds random value to compare with chance
		
		if(t == 0){ // if enemy's turn
			// if player has no speed or enemy has more spd than player
			if(u.returnSpd() == 0 || e.returnSpd() >= u.returnSpd()){ 
				return 1;
			}
			// enemy's spd / player's spd
			spd1 = e.returnSpd();
			spd2 = u.returnSpd();
		}
		else if (t == 1){ // if player's turn
			// if enemy has no speed or player has more spd than player
			if(e.returnSpd() == 0 || u.returnSpd() >= e.returnSpd()){
				return 1;
			}
			// player's spd / enemy's spd
			spd1 = u.returnSpd();
			spd2 = e.returnSpd();
		}
		
		chance = (double)spd1 / (double)spd2;
		
		if(chance < rand){ // if attack misses
			return 0;
		}
		
		return 1; // attack went through
	}
}
