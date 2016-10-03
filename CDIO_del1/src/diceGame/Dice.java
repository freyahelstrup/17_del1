package diceGame;

public class Dice {
	
	private int value1, value2;
	
	// roll the die and return the value (1-6) 
	private int roll() {
		float d1=(float)Math.random();     // 0-1
		float d2=(float)(d1*6-0.5);        // -0.5 - 5.5
		int d3=Math.round(d2);             // 0-5 integer
		return d3 + 1;                     // 1-6
	}
	
	// roll the die twice and save values in value1 and value2
	public void rollDice(){
		Dice dice;
		value1 = dice.roll();
		value2 = dice.roll();
	}
	
	public int getValue1(){
		return value1;
	}
	
	public int getValue2(){
		return value2;
	}
}
