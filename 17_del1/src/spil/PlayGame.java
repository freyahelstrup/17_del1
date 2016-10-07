package spil;

import desktop_resources.GUI;

public class PlayGame {
	
	public void playGame() {
		
		Player p1 = new Player(1, 0, true); // Player ID, 0 Score, isTurn
		Player p2 = new Player(2, 0, false);
		
		boolean winnerfound = false;
		boolean lastturn = false;
		boolean draw = false;
			
		// play game
		while (winnerfound == false) {
			
			
			this.playTurn(p1, p2);
			
			//Define a winner.
			//if winner = -1, it shall be a draw
			Player winner = new Player();
			
			if (lastturn == false) {
				
				if ( (p2.getScore() >= 40) && (p1.getScore() < p2.getScore()) ) {
					winner = p2;
					winnerfound = true;
				}else 
				if (p1.getScore() >= 40 && p2.getScore() < 40) {
					lastturn = true;				
				}
			}else {
				if (p1.getScore() >= 40 && p1.getScore() > p2.getScore()) {
					winnerfound = true;
					winner = p1;
				}else
				if (p1.getScore() >= 40 && p1.getScore() == p2.getScore()) {
					winnerfound = true;
					draw = true;
				}else {
					winnerfound = true;
					winner = p2;
				}
			}
			
			// Print the winner
			if (draw == true && winnerfound == true) {
				GUI.showMessage("Spillet er uafgjort! Scoren for begge spillere er: " + p1.getScore());
			}
			else if (winnerfound == true) {
				GUI.showMessage("Vinderen er: Spiller " + winner.getPlayerId() + "!");
			}
		}
	}
	
	public void playTurn(Player p1, Player p2){
		//Variables
		Player currentplayer;
		
		boolean winnerfound = false;
				
		Dice dice = new Dice();
		Dice previousDice = new Dice();
		
		//Define who's turn it is
		if (p1.getMyTurn() == true) {currentplayer = p1;}
		else {currentplayer = p2;}
		
		//Print who's turn it is
		int nextplayerid;
		if (currentplayer == p1) {nextplayerid = p1.getPlayerId();}																													 
		else {nextplayerid = p2.getPlayerId();}
		
		//Get the user to roll the dice (or at least think they're rolling the dice)
		GUI.getUserButtonPressed("Det er spiller " + nextplayerid + "'s tur. Slå terninger.", "Slå terning");
		
		
		//Roll the dice
		dice.rollDice();
		int dice1 = dice.getValue1();
		int dice2 = dice.getValue2();
		
		GUI.setDice(dice1, dice2);
		
		// The player shall loose his score, if the player rolls a pair of one's.
		if (dice1 == 1 && dice2 == 1) {
			currentplayer.setScore(0);
		}
		// The player shall win, if he/she throws a pair of sixes twice in a row.
		else if ((dice1 == 6 && dice2 == 6) && (currentplayer.getPreviousResult1() == 6 && currentplayer.getPreviousResult2() == 6) ) {
			winnerfound = true;
		}
		// Add the score to the players scorecount
		else {
			int newScore = currentplayer.getScore() + dice1 + dice2;
			currentplayer.setScore(newScore);
			
			//Save the result of the dice to the specific player
			previousDice.setValues(dice1, dice2);
			if (currentplayer == p1) {
				p1.setPreviousResult(previousDice.getValue1(), previousDice.getValue2());
			}else {
				p2.setPreviousResult(previousDice.getValue1(), previousDice.getValue2());
			}
		}
		
		// A player shall get an extra turn, if the result of the dice are a pair
		// And the turn will go to the other player, if the pair is snake eyes
		if (dice1 == dice2 && dice1 + dice2 != 2) {
			if (currentplayer == p1) {
				p1.setMyTurn(true);
				p2.setMyTurn(false);
			}else {
				p1.setMyTurn(false);
				p2.setMyTurn(true);
			}
		}else
			// If it's not a double, the turn goes to the other player!
			if (currentplayer == p1) {
				p1.setMyTurn(false);
				p2.setMyTurn(true);
			}else {
				p1.setMyTurn(true);
				p2.setMyTurn(false);
			}
		
		//Print the score for both players
		GUI.showMessage(p1 + "\t\t\t" + p2);
	}
	
}
