package test;

import static org.junit.Assert.*;

import org.junit.Test;


public class DiceTest {
	/***************************************
 	Test to see if the method setValues
 	work as intended.
	**************************************/
	@Test
	public void testSetValues() {
		spil.Dice dice = new spil.Dice();
		int value1, value2;

		/******** TEST SET 1 ********/
		value1 = 1;		value2 = 6;
		//We set values of dice to above integers
		dice.setValues(value1, value2);
		
		//We test if values are same as returned 
		//in getValue1 and getValue2
		assertEquals(value1,dice.getValue1());
		assertEquals(value2,dice.getValue2());

		/******** TEST SET 2 ********/
		value1 = 3;		value2 = 1;
		//We set values of dice to above integers
		dice.setValues(value1, value2);
		
		//We test if values are same as returned 
		//in getValue1 and getValue2
		assertEquals(value1,dice.getValue1());
		assertEquals(value2,dice.getValue2());
	}
	
	/***************************************
 	Test to see if dice return values are 
 	integer 1,2,3,4,5 or 6.
	**************************************/
	@Test
	public void testDiceBetween1And6() {
		boolean diceBetween1And6 = false;
		int n = 30000;
		spil.Dice dice = new spil.Dice();
		
		//Loop running n times
		for (int i=1;i<=n;i++){
			dice.rollDice(); //Rolls 2 dice
			if ((dice.getValue1() == 1 
					|| dice.getValue1() == 2
					|| dice.getValue1() == 3
					|| dice.getValue1() == 4
					|| dice.getValue1() == 5
					|| dice.getValue1() == 6
				) && 
				(dice.getValue2() == 1 
					|| dice.getValue2() == 2
					|| dice.getValue2() == 3
					|| dice.getValue2() == 4
					|| dice.getValue2() == 5
					|| dice.getValue2() == 6
				))
			{
				diceBetween1And6 = true; //If dice is 1,2,3,4,5 or 6
			}
			else 
			{
				diceBetween1And6 = false; //If dice is NOT 1,2,3,4,5 or 6
			}
			
			assertEquals(true,diceBetween1And6);
		}
	}

	/***************************************
 	Test to see if dice returns the 6 values
 	randomly, so none is more frequent.
 	We test 60,000 rolls, and therefore 
 	expect 10,000 of each value - with an 
 	acceptable difference of 400.
 	This means that we accept between 9,600
 	and 10,400 of each value.
	**************************************/
	@Test
	public void testRandomness() 
	{
		boolean resultApproved;
		int n = 30000;
		spil.Dice dice = new spil.Dice();
		int counter1 = 0,	counter2 = 0,	counter3 = 0,	counter4 = 0,	counter5 = 0,	counter6 = 0;
		
		//Loop running n times - beware that two dice are rolled,
		//so actually the dice are rolled n*2 times
		for (int i=1;i<=n;i++)
		{
			dice.rollDice(); //Roll the two dice
			
			//Increase counter for the value in Value1
			switch (dice.getValue1())
			{
			case 1: counter1++;	break;
			case 2: counter2++;	break;
			case 3: counter3++;	break;
			case 4: counter4++;	break;
			case 5: counter5++;	break;
			case 6: counter6++;	break;
			default: resultApproved=false;
			}

			//Increase counter for the value in Value2
			switch (dice.getValue2())
			{
			case 1: counter1++;	break;
			case 2: counter2++;	break;
			case 3: counter3++;	break;
			case 4: counter4++;	break;
			case 5: counter5++;	break;
			case 6: counter6++;	break;
			default: resultApproved=false;
			}
		}

		System.out.println("Antal 1'ere ud af " + n + " kast: " + counter1);
		System.out.println("Antal 2'ere ud af " + n + " kast: " + counter2);
		System.out.println("Antal 3'ere ud af " + n + " kast: " + counter3);
		System.out.println("Antal 4'ere ud af " + n + " kast: " + counter4);
		System.out.println("Antal 5'ere ud af " + n + " kast: " + counter5);
		System.out.println("Antal 6'ere ud af " + n + " kast: " + counter6);
		System.out.println("Sum af counters: " + (counter1+counter2+counter3+counter4+counter5+counter6));
		
		final double EXPECTED, MAX, MIN, ACCEPTABLEDIFFERENCE;
		EXPECTED = (n*2.0)*(1.0/6.0); //We expect 1/6 of the rolls to be each value
		ACCEPTABLEDIFFERENCE = EXPECTED * 0.04; //We accept a difference of 4%
		MIN = EXPECTED-ACCEPTABLEDIFFERENCE;
		MAX = EXPECTED+ACCEPTABLEDIFFERENCE;
		
		if (counter1 >= MIN && counter1 <= MAX
			&& counter2 >= MIN && counter2 <= MAX
			&& counter3 >= MIN && counter3 <= MAX
			&& counter4 >= MIN && counter4 <= MAX
			&& counter5 >= MIN && counter5 <= MAX
			&& counter6 >= MIN && counter6 <= MAX)
		{
			resultApproved = true; //If number of each value meets our expectation
		}
		else
		{
			resultApproved = false; //If number of each value does NOT meet our expectation
		}
		
		assertEquals(true,resultApproved);
	}
}