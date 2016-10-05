package diceGame;

public class Player {

	//Variables
	private int score, id;
	private Dice previousResult = new Dice();
	private boolean myTurn;
	
	
	public Player (int id, int score, boolean myTurn)
	{

		this.id = id;
		this.score = score;
		this.myTurn = myTurn;
		
	}
	
	//Returns, as a boolean, whether or not it is the given player's turn
	public boolean getMyTurn(){
		return myTurn;
	}
	
	//Gives turn to the given player
	public void setMyTurn(boolean myTurn){
		this.myTurn = myTurn;
	}
	
	//Returns the player id
	public int getPlayerid(){
		return id;
		
	}
	//Returns the score
	public int getScore(){
		return score;
	
	}
	
	//Sets the score of the given player
	public void setScore(int score){
		this.score = score;
	}
	
	//Sets the previous result 
	public void setPreviousResult(int value1, int value2){
		previousResult.setValues(value1, value2);
	}
	
	//Returns the previous result
	public getPreviousResult(){
		return previousResult;
	}
}