package ro.sci.main;

/*
 * ro.sci.main  
 * Game.java - a Tic Tac Toe game
 *
 * @author Ovidiu Popa Petrar
 *
 */

import java.util.Random;

public class Game {

	private final String X = new String("X");
	private final String O = new String("O");
	private final String EMPTY = new String(" ");
	final String[] board = new String[9];
	private int currentPlayer = (Math.random() <= 0.5) ? 1 : 2;;
	private String playersMove = " ";

	/**
	 * Method responsible for making a random move on the board.
	 */
	public synchronized void playerMove() {
		Random random = new Random();
		boolean moveWasMade = false;
		if (isBoardFull() < 9) {
			while (!moveWasMade) {
				int i = random.nextInt(9);
				if (board[i].equals(EMPTY)) {
					board[i] = playersMove; // places at the position [i],
											// 'X'
											// or 'O' depending on witch
											// player moves
					moveWasMade = true;
				}
			}
		}
	}

	/**
	 * After each move the player is switch.
	 */
	public synchronized void switchPlayers() {
		if (currentPlayer == 1) {
			playersMove = X;
			currentPlayer = 2;
		} else if (currentPlayer == 2) {
			playersMove = O;
			currentPlayer = 1;
		}
	}

	/**
	 * The method check if there is a winner and printed out if finds one. else
	 * it returns false
	 */
	public synchronized boolean checkingForWinner() { // checks all possible
														// winning moves
		boolean winner = false;
		// checking rows
		if ((board[0].equals(playersMove) && board[1].equals(playersMove) && board[2].equals(playersMove))
				|| (board[3].equals(playersMove) && board[4].equals(playersMove) && board[5].equals(playersMove))
				|| (board[6].equals(playersMove) && board[7].equals(playersMove) && board[8].equals(playersMove))) {
			System.out.println(
					"\n Player " + currentPlayer + " on " + Thread.currentThread().getName() + " won the game on row");
			winner = true;
			System.exit(0);
		}
		// checking columns
		if ((board[0].equals(playersMove) && board[3].equals(playersMove) && board[6].equals(playersMove))
				|| (board[1].equals(playersMove) && board[4].equals(playersMove) && board[7].equals(playersMove))
				|| (board[2].equals(playersMove) && board[5].equals(playersMove) && board[8].equals(playersMove))) {
			System.out.println("\n Player " + currentPlayer + " on " + Thread.currentThread().getName()
					+ " won the game on column");
			winner = true;
			System.exit(0);
		}
		// checking diagonals
		if ((board[0].equals(playersMove) && board[4].equals(playersMove) && board[8].equals(playersMove))
				|| (board[2].equals(playersMove) && board[4].equals(playersMove) && board[6].equals(playersMove))) {
			System.out.println("\n Player " + currentPlayer + " on " + Thread.currentThread().getName()
					+ " won the game on diagonal");
			winner = true;
			System.exit(0);
		}

		// If nobody wins ( winner = false) then it will be draw
		if ((isBoardFull() == 9) && (winner == false)) {
			System.out.println("\n The game is a draw.");
			System.exit(0);
		}
		return winner;
	}

	/**
	 * Printing an update the board after each player move. For visual purpose
	 * only.
	 */
	public synchronized void printBoard() {
		System.out.print("Player " + currentPlayer + " made a move ~ " + Thread.currentThread().getName() + " ~ \n");
		for (int i = 0; i < board.length; i += 3) {
			System.out.print(board[i] + " | " + board[i + 1] + " | " + board[i + 2]);
			System.out.println("\n----------");
		}
		System.out.println("");
	}

	/**
	 * The method check if the board is full
	 */
	public synchronized int isBoardFull() {
		int counter = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i].contentEquals(X) || board[i].contentEquals(O)) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Initializes the board by filling every position with empty spaces. The
	 * board is an Array of length 9. I choose this approach because when they
	 * play random the pool to choose is larger, and the game does not repeat
	 * 
	 * @return
	 */

	public synchronized void initBoard() {
		for (int i = 0; i < board.length; i++) {
			board[i] = " ";
		}
	}

	// for testing purpose
	public int getCurrentPlayer() {
		return currentPlayer;
	}

	/**
	 * Inner class Player that implements Runnable
	 */
	class Player implements Runnable {

		@Override
		public synchronized void run() {
			try {

				for (int i = 0; i < 9; i++) {
					switchPlayers();
					playerMove();
					printBoard();
					checkingForWinner();
					Thread.sleep(1500);
				}
			} catch (Exception e) {
			}
		}
	}
}