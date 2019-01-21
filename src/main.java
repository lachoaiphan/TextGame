import java.util.Scanner;
import java.io.*;

public class main{

	public static void main(String[] args){
		int choice = 0, mchoice = 0, progress = 0, location = 0;
		int ingame = 1,  encounter = 0; // in game and first arrival
		int lvl = 1, hp = 10, str = 3, def = 3, spd = 3; // default stats for the user
		
		Menu menu = new Menu(progress);
		Dialog dlog = new Dialog();
		BattleSystem battle = new BattleSystem();
		
		Scanner intreader = new Scanner(System.in); // reading all input in game
		Scanner strreader = new Scanner(System.in);
		String name; // name for the user
		String hold; // for holding the console
		
		// Sample menu
		menu.printStartMenu();
		
		System.out.print("Select option: ");
		
		while(mchoice > 2 || mchoice <= 0){
			mchoice = intreader.nextInt();
			if(mchoice > 2 || mchoice <= 0){
				System.out.print("Please select a valid option: ");
			}
		}
		
		if(mchoice == 2){
			System.out.println("Goodbye!");
			intreader.close();
			strreader.close();
			System.exit(0);
		}
		
		dlog.WelcomeGame();
		name = strreader.nextLine();
			
		dlog.HobbyPref();
		while(choice > 4 || choice <= 0){
			choice = intreader.nextInt();
				
			switch(choice){
				case 1: str += 1;
						break;
				case 2: def += 1;
						break;
				case 3: spd += 1;
						break;
				default: System.out.print("Please choose your hobby indicated above: ");
						break;
			}
		}
		UserChar chr = new UserChar(name, lvl, hp, str, def, spd);
		Enemy enemy = new Enemy();
		dlog.IntroToBegTown(chr.returnName());
			
		System.out.println("\nPress any key and enter to continue.");
			
		hold = strreader.nextLine();
		
		while(ingame == 1){
			while(location == 0){
				System.out.println("\n-------------------------");
				if(menu.getFA() == 1){
					dlog.faBT();
					menu.setFA(0); // to replace First Arrival Message
				}
				else{
					System.out.println("Location: Beginner Town");
				}
				
				menu.printBTMenu();
				
				System.out.print("Select your option 1 - 4: ");
				choice = intreader.nextInt();
				
				switch(choice){
					case 1: location = 1;
							menu.setFA(1);
							break;
					case 2: System.out.println("\nYou rest at the inn and feel refreshed!");
							chr.innRecoverHealth();
							break;
					case 3: chr.checkStats();
							break;
					case 4: location = -1;
							ingame = 0;
							System.out.println("Goodbye!");
							break;
					default: break;
				}
				
			}
			while(location == 1){
				System.out.println("\n-------------------------");
				if(menu.getFA() == 1){
					dlog.faNOS();
					menu.setFA(0);
				}
				else{
					System.out.println("Location: The New Outskirts");
				}
				menu.printNOSMenu();
				
				System.out.print("Select your option 1 - 4: ");
				choice = intreader.nextInt();
				
				switch(choice){
					case 1: encounter = 1;
							menu.setFA(1);
							break;
					case 2: location = 0;
							menu.setFA(1);
							break;
					case 3: chr.checkStats();
							break;
					case 4: location = -1;
							ingame = 0;
							System.out.println("Goodbye!");
							break;
					default: System.out.print("Please enter a valid option."); 
							break;
				}
				while(encounter == 1 && enemy.returnHealth() > 0){
					System.out.println("\n-------------------------");
					if(menu.getFA() == 0){
						System.out.println("A Red Dog Newcomer has appeared!");
						menu.setFA(1);
					}
					else{
						System.out.println("Red Dog Newcomer: Woof!");
					}
					
					System.out.print("\nRed Dog Newcomer's HP: " + enemy.returnHealth());
					System.out.println("/" + enemy.returnMaxHealth());
					System.out.print("\n" + chr.returnName() +"'s HP: " + chr.returnHealth());
					System.out.println("/" + chr.returnMaxHealth());
					System.out.println("1) Attack");
					System.out.println("2) Run Away");
					System.out.print("Select valid option: ");
					choice = intreader.nextInt();
					
					if(choice == 1){
						if(battle.dodgeAttack(chr, enemy, 1) == 1){
							System.out.println("You have dealt " + battle.dealtDamage(chr, enemy, 1) + " damage!");
				
						}
						else{
							System.out.println("You missed your attack!");
						}
						
						if(enemy.returnHealth() > 0){
							if(battle.dodgeAttack(chr, enemy, 0) == 1){
								System.out.println("Red Dog Newcomer dealt " + battle.dealtDamage(chr, enemy, 0) + " damage to you!");
					
							}
							else{
								System.out.println("The enemy missed their attack!");
							}
							
						}
					}
					else if(choice == 2){
						if(chr.runAway() == 1){
							System.out.println("You successfully ran away!");
							enemy.setbackHealth();
							encounter = 0;
						}
					}	
					else{
						System.out.print("Please enter a valid option: ");
					}
					
					if(enemy.returnHealth() == 0){
						System.out.println("Victory!");
						System.out.println("You have gained 10 Experience!");
						chr.levelup(10, dlog);
						enemy.setbackHealth();
						encounter = 0;
					}
					else if(chr.returnHealth() == 0){
						System.out.println("\n" +chr.returnName() + ": No...");
						System.out.println(chr.returnName() + " has fallen...");
						System.out.println("GAME OVER");
						System.out.println("\n\nPress any key and enter to exit.");
						
						hold = strreader.nextLine();
						intreader.close();
						strreader.close();
						System.exit(0);;
					}
				}
			}
		}
			
		intreader.close();
		strreader.close();
		
	}
}