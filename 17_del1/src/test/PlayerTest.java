package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void getandsetTest() {
		spil.Player player = new spil.Player();
		
		//score test
		int scorevalue1;
		int scorevalue2;
		int scorevalue3;
		
		player.setScore(12);
		scorevalue1 = player.getScore();
		player.setScore(3);
		scorevalue2 = player.getScore();
		player.setScore(42);
		scorevalue3 = player.getScore();
		
		assertEquals(scorevalue1, 12);
		assertEquals(scorevalue2, 3);
		assertEquals(scorevalue3, 42);
		
		System.out.println("score = " + scorevalue1 + ", " + scorevalue2 + ", " + scorevalue3);
		
		
		//myturn test
		player.setMyTurn(true);
		assertEquals(player.getMyTurn(), true);
		
		System.out.print("myturn = " + player.getMyTurn() + ", ");
		
		player.setMyTurn(false);
		assertEquals(player.getMyTurn(), false);
		
		System.out.println(player.getMyTurn());
		
		
		//previousresult test
		int prevvalue1;
		int prevvalue2;
		
		player.setPreviousResult(1, 1);
		prevvalue1 = player.getPreviousResult1();
		prevvalue2 = player.getPreviousResult2(); 
		
		assertEquals(prevvalue1, 1);
		assertEquals(prevvalue2, 1);
		
		System.out.print("previousresult = (" + prevvalue1 + "," + prevvalue2 + ")");
		
		player.setPreviousResult(3, 5);
		prevvalue1 = player.getPreviousResult1();
		prevvalue2 = player.getPreviousResult2(); 
		
		assertEquals(prevvalue1, 3);
		assertEquals(prevvalue2, 5);
		
		System.out.print(",(" + prevvalue1 + "," + prevvalue2 + ")");
		
		player.setPreviousResult(2, 4);
		prevvalue1 = player.getPreviousResult1();
		prevvalue2 = player.getPreviousResult2(); 
		
		assertEquals(prevvalue1, 2);
		assertEquals(prevvalue2, 4);
		
		System.out.println(",(" + prevvalue1 + "," + prevvalue2 + ")");
		
		
	}

}
