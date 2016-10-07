package diceGame;

import desktop_resources.GUI;

public class PlayGame {
	
	public void playGame() {
		
	
		//Variables
		Player p1 = new Player(1, 0, true); // Player ID, 0 Score, isTurn
		Player p2 = new Player(2, 0, false);
		Player currentPlayer = new Player(0, 0, false);
		
		Dice dice = new Dice();
		Dice previousDice = new Dice();
		
		boolean winnerFound = false;
		boolean firstTurn = true;
		boolean lastTurn = false;
		boolean draw = false;
			
		// play game
		while (winnerFound == false) {
			
			//Define who's turn it is
			if (p1.getMyTurn() == true) {
				currentPlayer = p1;
			}
			else {
				currentPlayer = p2;
			}
			
			//Print who's turn it is
			int nextPlayerId;
			if (currentPlayer == p1) {
				nextPlayerId = p1.getPlayerid();																				
			}																													 
			else {
				nextPlayerId = p2.getPlayerid();
			}
			
			GUI.getUserButtonPressed("Det er spiller " + nextPlayerId + "'s tur. Slå terninger.");
			
			//Roll the dice
			dice.rollDice();
			int dice1 = dice.getValue1();
			int dice2 = dice.getValue2();
			
			GUI.setDice(dice1, dice2);
			
			// The player shall loose his score, if the player rolls a pair of one's.
			if (dice1 == 1 && dice2 == 1) {
				currentPlayer.setScore(0);
			}
			// The player shall win, if he/she throws a pair of sixes twice in a row.
			else if ((dice1 == 6 && dice2 == 6) && 
						(currentPlayer.getPreviousResult() == previousDice) && firstTurn == false) {			// Currently not working - needs a fix
				winnerFound = true;
			}
			// Add the score to the players scorecount
			else {
				int newScore = currentPlayer.getScore() + dice1 + dice2;
				currentPlayer.setScore(newScore);
				
				//Save the result of the dice to the specific player
				previousDice.setValues(dice1, dice2);
				if (currentPlayer == p1) {
					p1.setPreviousResult(dice1, dice2);
				}else {
					p2.setPreviousResult(dice1, dice2);
				}
			}
			
			// A player shall get an extra turn, if the result of the dice are a pair
			// And the turn will go to the other player, if the pair is snake eyes
			if (dice1 == dice2 && dice1 + dice2 != 2) {
				if (currentPlayer == p1) {
					p1.setMyTurn(true);
					p2.setMyTurn(false);
				}else {
					p1.setMyTurn(false);
					p2.setMyTurn(true);
				}
			}else
				// If it's not a double, the turn goes to the other player!
				if (currentPlayer == p1) {
					p1.setMyTurn(false);
					p2.setMyTurn(true);
				}else {
					p1.setMyTurn(true);
					p2.setMyTurn(false);
				}
			
			// First turn is now over
			firstTurn = false;
			
			//Print the score for both players
			GUI.showMessage(p1 + "\t\t\t" + p2);
			
			
			//Define a winner.
			//if winner = -1, it shall be a draw
			Player winner = new Player(0,0,false);
			
			if (lastTurn == false) {
				
				if ( (p2.getScore() >= 40) && (p1.getScore() < p2.getScore()) ) {
					winner = p2;
					winnerFound = true;
				}else 
				if (p1.getScore() >= 40 && p2.getScore() < 40) {
					lastTurn = true;				
				}
			}else {
				if (p1.getScore() >= 40 && p1.getScore() > p2.getScore()) {
					winnerFound = true;
					winner = p1;
				}else
				if (p1.getScore() >= 40 && p1.getScore() == p2.getScore()) {
					winnerFound = true;
					draw = true;
				}else {
					winnerFound = true;
					winner = p2;
				}
			}
			
			// Print the winner
			if (draw == true) {
				GUI.showMessage("Spillet er uafgjort! Scoren for begge spillere er: " + p1.getScore());
			}else if (winnerFound == true) { 
				GUI.showMessage("Vinderen er: Spiller " + winner.getPlayerid() + "!");
			}
		}
	}
}
				