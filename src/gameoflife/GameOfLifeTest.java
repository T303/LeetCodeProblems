package gameoflife;

public class GameOfLifeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameOfLifeSolution testObject = new GameOfLifeSolution();
		int[][] testcase1 = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		int[][] testcase2 = {{1, 1}, {1, 0}};
		testObject.gameOfLifeTest(testcase1);
		testObject.gameOfLifeTest(testcase2);
		printBoard(testcase1);
	}
	
	public static void printBoard(int[][] board) {
		System.out.println("-----------------");
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
