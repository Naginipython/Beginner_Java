package TicTacToe;/*
 * Name: Ben McCann
 * Date: 10/7/2018
 * Course Number: CSC-220
 * Course Name: Data Structures
 * Problem Number: HW4
 * Email: bnmccann0001@student.stcc.edu
 * TicTacToe class to go with Prof. Silvestri's PlayTicTacToe program.
 */

public class TicTacToe {
	private char[][] board;
	private static int turns = 0;
	
	TicTacToe() {
		board = new char[3][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = ' ';
			}
		}
	}

	public boolean isValid(int r, int c) {
		if (board[r][c] == ' ') {
			return true;
		} else {
			return false;
		}
	}

	public void playMove(char p, int r, int c) {
		turns++;
		board[r][c] = p;
	}

	public char playerAt(int r, int c) {
		return board[r][c];
	}

	public boolean isWinner(char c) {
		//Is there a better way to do this? This was the most simple way I can think of
		if (board[0][0] == c && board[0][1] == c && board[0][2] == c) {
			return true;
		} else if (board[1][0] == c && board[1][1] == c && board[1][2] == c) {
			return true;
		} else if (board[2][0] == c && board[2][1] == c && board[2][2] == c) {
			return true;
		} else if (board[0][0] == c && board[1][0] == c && board[2][0] == c) {
			return true;
		} else if (board[0][1] == c && board[1][1] == c && board[2][1] == c) {
			return true;
		} else if (board[0][2] == c && board[1][2] == c && board[2][2] == c) {
			return true;
		} else if (board[0][0] == c && board[1][1] == c && board[2][2] == c) {
			return true;
		} else if (board[0][2] == c && board[1][1] == c && board[2][0] == c) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}
		return true;
	}
	
	public String toString() {
	      //return getClass().getName()+"@"+Integer.toHexString(hashCode());
		String game = "\n";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (j == board.length-1) {
					game += board[i][j];
				} else {
					game += board[i][j] +"|";
				}
				
			}
			game += "\n";
		}
		return game;
	}

	public String getTurns() {
		return ""+turns;
	}

}
