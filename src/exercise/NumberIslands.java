package exercise;

import java.util.ArrayList;
import java.util.List;

public class NumberIslands {
	
	public static List<Integer> numIslands(int[][] matrix) {
		int num_island = 0, islandSize = 0;
		List<Integer> islandSizes = new ArrayList<Integer>();
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j <matrix[0].length; j++) {
				if(matrix[i][j] == 1) {
					islandSize = traverseIsland(matrix, i, j);
					islandSizes.add(islandSize);
					num_island++;
				}
			}
		}
		return islandSizes;
	}
	
	public static int traverseIsland(int[][]matrix, int i, int j) {
	    
		if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] == 0) {
			return 0;
		}
		
		matrix[i][j] = 0;
		return 1 + traverseIsland(matrix, i-1, j)
		         + traverseIsland(matrix, i+1, j)
		         + traverseIsland(matrix, i, j-1)
		         + traverseIsland(matrix, i, j+1);
	}

	public static void main(String[] args) {
		int M[][] = new int[][] { 
			{ 1, 1, 0, 0, 0 }, 
            { 0, 1, 0, 0, 1 }, 
            { 1, 0, 0, 1, 1 }, 
            { 0, 0, 0, 0, 0 }, 
            { 1, 0, 1, 0, 1 } }; 
        
            for(Integer n : numIslands(M)) {
            	 System.out.println(n);
            }
           

	}

}
