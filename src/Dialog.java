public class Dialog {
	public Dialog(){
		
	}
	
	public void WelcomeGame(){
		System.out.println("\nHello user! Welcome to my text-based RPG called Test Game!");
		System.out.print("Please select your name: ");
	}
	public void HobbyPref(){
		System.out.println("\nAh a spectacular name I may say! Now let me ask you a");
		System.out.println("question. What hobby do you prefer indicated below?");
		System.out.print("Weight Training (1), Martial Arts (2), Track (3): ");
	}
	public void IntroToBegTown(String name){
		System.out.println("\nNice! Well, welcome " + name + "! This game will be a");
		System.out.println("sendoff to text-based RPGs that was created in the late");
		System.out.println("1900s. If you know how to play these kinds of RPGs that");
		System.out.println("involves turn-based strategy and Final Fantasy elements");
		System.out.println("then you are set to go! Otherwise, you'll have to wait");
		System.out.println("for a tutorial I will cook up in the future.\n");
		System.out.println("For now, let's start you off in Beginner Town which hosts a");
		System.out.println("small community who will help prepare yourself for the");
		System.out.println("impending threat of this world. What are these impending threats?");
		System.out.println("Well, our main villian at this time will be Cliff, a boss");
		System.out.println("of a group of bandits named Red Dog Bandits. These");
		System.out.println("group of bandits have been terrorizing this community for");
		System.out.println("a few weeks now so now you have to stop them!");
		System.out.println("\nBy the way, you have been knocked out by one of these");
		System.out.println("bandits for some time and resting at the town's inn so now wake up!");
	}
	public void faBT(){
		System.out.println("Welcome to Beginner Town! Please help us");
		System.out.print("clear out the bandits!");
	}
	public void faNOS(){
		System.out.println("A spring breeze goes through your hair.");
		System.out.print("This must be the New Outskirts.");
	}
	
	public void printLevelUp(int level){
		System.out.println("You have leveled up to " + level);
	}
}
