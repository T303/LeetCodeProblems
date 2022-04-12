package gameoflife;

public class GameOfLifeSolution {
	int[] possibleNeighborsX = {-1, -1, 0, 1, 1, 1, 0, -1};
	int[] possibleNeighborsY = {0, -1, -1, -1, 0, 1, 1, 1};
	
	public void gameOfLifeTest(int[][] board) {
		int[][] boardCopy = new int[board.length][board[0].length];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				boardCopy[i][j] = board[i][j];
			}
		}
		
		
		for(int i = 0; i < boardCopy.length; i++) {
			for(int j = 0; j < boardCopy[i].length; j++) {
				int livingNeighbors = 0;
				for(int k = 0; k < 8; k++) {
					try {
						int neighborValue = boardCopy[i + possibleNeighborsX[k]][j + possibleNeighborsY[k]];
						if(neighborValue == 1) {
							livingNeighbors++;
						}
					} catch(ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
				if(boardCopy[i][j] == 1) {
					if(livingNeighbors < 2) {
						board[i][j] = 0;
					}
					if(livingNeighbors == 2 || livingNeighbors == 3) {
						board[i][j] = 1;
					}
					if(livingNeighbors > 3) {
						board[i][j] = 0;
					}
				}
				if(boardCopy[i][j] == 0) {
					if(livingNeighbors == 3) {
						board[i][j] = 1;
					}
				}
				
			}
		}
    }
	
	/*
	 * This was the original method that I wrote that returned a copy of the board matrix
	 * I had to modify it as Leetcode expects modifying the board directly
	public int[][] gameOfLife(int[][] board) {
		int[][] nextState = new int[board.length][board[0].length];
		
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				int livingNeighbors = 0;
				for(int k = 0; k < 8; k++) {
					try {
						int neighborValue = board[i + possibleNeighborsX[k]][j + possibleNeighborsY[k]];
						if(neighborValue == 1) {
							livingNeighbors++;
						}
					} catch(ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
				if(board[i][j] == 1) {
					if(livingNeighbors < 2) {
						nextState[i][j] = 0;
					}
					if(livingNeighbors == 2 || livingNeighbors == 3) {
						nextState[i][j] = 1;
					}
					if(livingNeighbors > 3) {
						nextState[i][j] = 0;
					}
				}
				if(board[i][j] == 0) {
					if(livingNeighbors == 3) {
						nextState[i][j] = 1;
					}
				}
				
			}
		}
		return nextState;
	}
	*/
}
