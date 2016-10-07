package spil;

public class Player {

	//Variables
	private int score, id;
	private Dice previousresult = new Dice();
	private boolean myturn;
	
	
	public Player (int id, int score, boolean myTurn)
	{

		this.id = id;
		this.score = score;
		this.myturn = myTurn;
		
	}
	
	public Player(){
		this.myturn = false;
	}
	
	//Returns, as a boolean, whether or not it is the given player's turn
	public boolean getMyTurn(){
		return myturn;
	}
	
	//Gives turn to the given player
	public void setMyTurn(boolean myTurn){
		this.myturn = myTurn;
	}
	
	//Returns the player id
	public int getPlayerId(){
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
		previousresult.setValues(value1, value2);
	}
	
	//Returns the previous result's first value
	public int getPreviousResult1(){
		return previousresult.getValue1();
	}
	
	//Returns the previous result's second value
	public int getPreviousResult2(){
		return previousresult.getValue2();
	}
	
	public String toString(){
		return "Spiller " + id + " har " + score + " point";
	}

}
