package diceGame;

import desktop_resources.GUI;

public class PlayGame {

	public static void main(String[] args) {
		
		Player p1 = new Player(1,0,true);
		Player p2 = new Player(2,0,false);
		Player currentPlayer = new Player(0,0,false);

		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		
		
		while (p1.getScore() < 40 && p2.getScore() < 40)
		{
		//define who's turn it is
			if (p1.getIsTurn() == true){
				currentPlayer = p1;
			}
			else {
				currentPlayer = p2;
			}
			
		//print who's turn it is
			int nextPlayerId;
			if (p1.getIsTurn() == true){
				nextPlayerId = p1.getId();
			}
			else {
				nextPlayerId = p2.getId();
			}

			GUI.getUserButtonPressed("Det er spiller " + nextPlayerId + "'s tur.", "Slå terninger");
//			System.out.println("Det er spiller " + nextPlayerId + "'s tur.");
	
		//roll the dice
			int roll1 = dice1.roll(); 
			int roll2 = dice2.roll();
			
			GUI.setDice(roll1, roll2);

//			System.out.println(roll1 + " " + roll2);
			
		//A player shall lose his score if the 
		//result of the dice roll is a pair of ones
			if (roll1 == 1 && roll2 == 1){
				currentPlayer.setScore(0);
			}
		//A player shall win the game, if the player 
		//throws a pair of 6’s twice, regardless from 
		//an extra turn or his previous turn.
			else if(roll1 == 6 && roll2 == 6 
					&& currentPlayer.getPrevTurn1() == 6 && currentPlayer.getPrevTurn2() == 6){
				currentPlayer.setScore(40);
			}
		//Add dice values to current score
			else {
				currentPlayer.addScore(roll1+roll2);
			}
			
		//A player shall get an extra turn if 
		//the result of the dice throw is a pair.
			if (roll1 == roll2){ 
				if (currentPlayer == p1){
					p1.setIsTurn(true);
				}
				else {
					p1.setIsTurn(false);
				}
			}
			else {
				if (currentPlayer == p1){
					p1.setIsTurn(false);
				}
				else {
					p1.setIsTurn(true);
				}
			}
		
		//Print the score for both players
			GUI.showMessage(p1 + "\t" + p2);
//			System.out.println(p1 + "\t" + p2);
//			System.out.println("-----------------------------------------------");
		
		//Save the rolls in prevRoll1 and prevRoll2
			if (currentPlayer == p1){
				p1.setPrevTurn(roll1, roll2);
			}
			else {
				p2.setPrevTurn(roll1, roll2);
			}
		}	
		//Define the winner
		Player winner = new Player(0,0,false);
		
		if (p1.getScore() >= 40){
			winner = p1;
		}
		else {
			winner = p2;
		}
		
		//Print the winner
		GUI.showMessage("Vinderen er: Spiller " + winner.getId() + "!");
		
		GUI.close();
		
//		System.out.println("Vinderen er: Spiller " + winner.id + "!");	
	}
}