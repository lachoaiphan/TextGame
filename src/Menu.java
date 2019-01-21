
public class Menu {
	private int progress;
	private int firstarrival;
	
	public void setFA(int f){
		firstarrival = f;
	}
	
	public void setProgress(int newVal){
		progress = newVal;
	}
	
	
	public int getFA(){
		return firstarrival;
	}
	
	public Menu(int p){
		progress = p;
		firstarrival = 1;
	}
	
	public void printStartMenu(){
		System.out.println("Test Game\n");
		System.out.println("1) New Game");
		System.out.println("2) Exit\n");
	}
	
	public void printNOSMenu(){
		System.out.println("\n1) Encounter");
		System.out.println("2) Return to Beginner Town");
		System.out.println("3) Check your stats");
		System.out.println("4) Exit game");
	}
	
	public void printBTMenu(){
		System.out.println("\n1) Travel the land");
		System.out.println("2) Go to the Inn");
		System.out.println("3) Check your stats");
		System.out.println("4) Exit game");
	}
	
}
