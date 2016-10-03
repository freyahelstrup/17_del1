package diceGame;

public class Player {

	private int id, score, prevTurn1, prevTurn2;
	private boolean isTurn;
	
	public Player (int id, int score, boolean isTurn)
	{
		this.id = id;
		this.score = score;
		this.isTurn = isTurn;
	}

	public void addScore(int point){
		this.score += point;
	}

	public void setScore(int score){
		this.score = score;
	}

	public void setIsTurn(boolean isTurn){
		this.isTurn = isTurn;
	}

	public void setPrevTurn(int prevTurn1, int prevTurn2){
		this.prevTurn1 = prevTurn1;
		this.prevTurn2 = prevTurn2;
	}
	
	public int getId(){
		return id;
	}

	public int getScore(){
		return score;
	}
	public boolean getIsTurn(){
		return isTurn;
	}

	public int getPrevTurn1(){
		return prevTurn1;
	}

	public int getPrevTurn2(){
		return prevTurn2;
	}
	
	public String toString(){
		return "Spiller " + id + " har " + score + " point.";
	}
}
