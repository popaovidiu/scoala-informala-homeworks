package ro.sci.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ro.sci.main.Game;

/*
 * ro.sci.main  
 * Game.java - a Tic Tac Toe game
 *
 * @author Ovidiu Popa Petrar
 *
 */
public class Tests {

	@Test
	public void testIfBoardIsInitiaizedAndEmpty() {
		Game XandO = new Game();// creating the game board
		XandO.initBoard(); // Initializing the board
		assertEquals(0, XandO.isBoardFull());
	}

	@Test
	public void testIfAMovedWasMade() {
		Game XandO = new Game();// creating the game board
		XandO.initBoard(); // Initializing the board
		XandO.playerMove(); // make a move
		boolean moveWasMade = false;
		if (XandO.getCurrentPlayer() == 1 || XandO.getCurrentPlayer() == 2) {
			moveWasMade = true;
		}
		assertTrue(moveWasMade);
	}

	@Test
	public void testIfPlayersSwitch() {
		Game XandO = new Game();// creating the game board
		XandO.initBoard(); // Initializing the board
		int player1 = XandO.getCurrentPlayer();
		XandO.switchPlayers();
		;
		int player2 = XandO.getCurrentPlayer();
		assertFalse(player1 == player2);
	}

}
