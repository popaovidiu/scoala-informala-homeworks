package ro.sci.main;

/*
 * ro.sci.main  
 * Game.java - a Tic Tac Toe game
 *
 * @author Ovidiu Popa Petrar
 *
 */

public class GameApp {

	public static void main(String[] args) throws InterruptedException {

		Game XandO = new Game();// creating the game board
		XandO.initBoard(); // Initializing the board

		Game.Player player1 = XandO.new Player(); // Creating player 1 who use
													// board XandO
		Game.Player player2 = XandO.new Player();// Creating player 2 who use
													// the same board

		Thread t1 = new Thread(player1, "Thread 1");// Creating Thread 1 witch
													// will be used by player
													// one
		Thread t2 = new Thread(player2, "Thread 2");// Creating Thread 2 witch
													// will be used by player
													// two

		t1.start(); // Starting Thread 1
		// start second thread after waiting for 0.5 seconds or if thread 1 it's
		// dead
		try {
			t1.join(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start(); // Starting Thread 2
		try {
			t2.join(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}