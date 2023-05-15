package main;

public class GoMoKu {
	// variables to setup the board
	private static final int BOARD_SIZE = 15;
	private static final char EMPTY = '-';
	private char[][] board;

	// setup an empty board of the size defined above
	public GoMoKu() {
		board = new char[BOARD_SIZE][BOARD_SIZE];
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	// print out the board array
	public void printBoard() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			for (int j = 0; j < BOARD_SIZE; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	// place stones based on row and column
	public boolean placeStone(int row, int col, char stone) {
		if (board[row][col] == EMPTY) {
			board[row][col] = stone;
			return true;
		}
		return false;
	}

	// checks the different types of wins on the board
	public boolean checkWin(char stone) {
		// Check for horizontal win
		for (int i = 0; i < BOARD_SIZE; i++) {
			int count = 0;
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[i][j] == stone) {
					count++;
				} else {
					count = 0;
				}
				if (count == 5) {
					return true;
				}
			}
		}

		// Check for vertical win
		for (int i = 0; i < BOARD_SIZE; i++) {
			int count = 0;
			for (int j = 0; j < BOARD_SIZE; j++) {
				if (board[j][i] == stone) {
					count++;
				} else {
					count = 0;
				}
				if (count == 5) {
					return true;
				}
			}
		}

		// Check for diagonal win (top left to bottom right)
		for (int i = 0; i < BOARD_SIZE - 4; i++) {
			for (int j = 0; j < BOARD_SIZE - 4; j++) {
				int count = 0;
				for (int k = 0; k < 5; k++) {
					if (board[i + k][j + k] == stone) {
						count++;
					} else {
						count = 0;
					}
					if (count == 5) {
						return true;
					}
				}
			}
		}

		// Check for diagonal win (bottom left to top right)
		for (int i = 0; i < BOARD_SIZE - 4; i++) {
			for (int j = BOARD_SIZE - 1; j >= 4; j--) {
				int count = 0;
				for (int k = 0; k < 5; k++) {
					if (board[i + k][j - k] == stone) {
						count++;
					} else {
						count = 0;
					}
					if (count == 5) {
						return true;
					}
				}
			}
		}

		return false;
	}
}