package main;

import java.util.Scanner;

public class Main {
	// player one and two pieces
	private static final char PLAYER_ONE_STONE = 'X';
	private static final char PLAYER_TWO_STONE = 'O';

	public static void main(String[] args) {
		// create a new instance of the Gomoku game
		GoMoKu game = new GoMoKu();
		// look for input
		Scanner scanner = new Scanner(System.in);
		// get the starting player
		char currentPlayer = PLAYER_ONE_STONE;
		
		// the game loop
		while (true) {
			// gives the current board
			System.out.println("Current board:");
			game.printBoard();

			// Prompt the player to place their stone
			System.out.println("Player " + currentPlayer
					+ ", enter x and y coordinates to place your stone (separated by a space):");
			int x = scanner.nextInt() - 1;
			int y = scanner.nextInt() - 1;

			// Place the stone and check for a win
			if (game.placeStone(y, x, currentPlayer)) {
				if (game.checkWin(currentPlayer)) {
					System.out.println("Player " + currentPlayer + " wins!");
					break;
				} else {
					// Switch to the other player
					currentPlayer = (currentPlayer == PLAYER_ONE_STONE) ? PLAYER_TWO_STONE : PLAYER_ONE_STONE;
				}
			} else {
				System.out.println("That spot is already taken. Try again.");
			}
		}

		scanner.close();
	}
}
