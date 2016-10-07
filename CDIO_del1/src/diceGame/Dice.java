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
		value1 = this.roll();
		value2 = this.roll();
	}
	
	public int getValue1(){
		return value1;
	}
	
	public int getValue2(){
		return value2;
	}
	
	public void setValues(int value1, int value2){
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public boolean equals(){
		return (value1 == value2);
	}
	
	public int sum(){
		return (value1 + value2);
	}
}
