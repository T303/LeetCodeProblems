package shift2DGrid;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGridSolution {

	public static void main(String[] args) {
		//int[][] test1 = {{1,2,3},{4,5,6},{7,8,9}};
		//List<List<Integer>> result1 = shiftGrid(test1, 2);
		//int[][] test2 = {{1}};
		//List<List<Integer>> result2 = shiftGrid(test2, 5);
		int[][] test3 = {{1},{2},{3},{4},{7},{6},{5}};
		List<List<Integer>> result3 = shiftGrid(test3, 5);
		//printMatrix(result1);
		//printMatrix(result2);
		printMatrix(result3);
	}
	
	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int n = grid.length;
		List<Integer> numList = new ArrayList<>();
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				numList.add(grid[i][j]);
			}
		}
		List<Integer> resultAsList = shiftGridRecursively(numList, 3);
		List<List<Integer>> resultAsMatrix = new ArrayList<>();
		for(int i = 0; i < grid.length; i++) {
			resultAsMatrix.add(new ArrayList<Integer>());
			for(int j = 0; j < grid[i].length; j++) {
				resultAsMatrix.get(i).add(resultAsList.get(j + (i * grid[i].length)));
			}
		}
		
		return resultAsMatrix;
	}
	
	public static List<Integer> shiftGridRecursively(List<Integer> numList, int k){
		if(k <= 0) {
			return numList;
		}
		List<Integer> resultAsList = new ArrayList<>();
		resultAsList.add(numList.get(numList.size() - 1));
		for(int i = 0; i < numList.size() - 1; i++) {
			resultAsList.add(numList.get(i));
		}
		return shiftGridRecursively(resultAsList, k - 1);
	}
	
	public static void printMatrix(List<List<Integer>> arr) {
		for(int i = 0; i < arr.size(); i++) {
			for(int j = 0; j < arr.get(i).size(); j++) {
				System.out.print(arr.get(i).get(j) + " ");
			}
			System.out.println("");
		}
	}

}
