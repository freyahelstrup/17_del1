package diceGame;
import java.util.Scanner;


public class StartMenu {
	
	//Calls the class "PlayGame" to send and retrieve information
	PlayGame game = new PlayGame();
	
//	//Method to set number of players participating
//	private void setPlayerAmount() {
//		
//		// -----> Uncomment stuff below when advancing project to more players <-----
//		
//		//Scanner scan = new Scanner(System.in);
//		
//		//int players = scan.nextInt();
//		
//		//Placeholder as the dice game is a 2 player game
//		int players = 2;
//		//System.out.println(players); // <----- for debugging remove when merging <-----
//		//game.setplayers(players); <----- Uncomment when we merge our code <-----
//		
//	}
	
	//Method for asking if the player wants to play a new game
	private void newGame(){
		
			//"" for spacing
			System.out.println("");
			
			//In case of default answer it returns to this point
			boolean newgameloop = true;
			while (newgameloop == true){
			
				System.out.println("Vil du starte et nyt spil? (J/N)");
				System.out.println("");
				
				Scanner scan = new Scanner(System.in);
	
				//The input is turned to lowercase so the answer is not case sensitive
				String answer = scan.nextLine();
				answer = answer.toLowerCase();
							
				switch(answer){
				
					case "j":
						
						//Sets number of players and runs the playgame method in the PlayGame() class
//						this.setPlayerAmount();
						System.out.println("");
						newgameloop = false;
						//game.playgame(); <----- Uncomment when we merge our code <-----
						break;
						
					case "n":
						
						//Closes the application
						System.exit(0);
				
					default:
						
						//Error and return
						System.out.println("Indtast j eller n");
						break;
	
			}
				scan.close();
				
		}	
		
	}
	
	public static void main(String[] args) {
		
		//Start menu "layout"
		System.out.println("======================================");
		System.out.println("    Velkommen til terningespillet     ");
		
		//Making a StartMenu object so i can call non-static methods from my class
		StartMenu menu = new StartMenu();
		
		//Infinite loop - breaks when the application closes 
		//AKA when the player dont want to start a new game
		while (true){
		
			menu.newGame();
		
		}

	}

}
