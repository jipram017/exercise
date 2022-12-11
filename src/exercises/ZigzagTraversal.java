package exercises;

import java.util.ArrayList;
import java.util.List;

public class ZigzagTraversal {
	// Time complexity O(N) because we iterate over 2D arrays with N elements
	// Space complexity O(N) because we store the result into a list of size N
	public static List<Integer> traverse(List<List<Integer>> arr) {
		int height = arr.size();
		int width = arr.get(0).size();
		
		List<Integer> result = new ArrayList<Integer>();
		
		int row = 0, col = 0;
		boolean goingDown = true;
		
		while(!isOutOfBounds(row, col, height, width)) {
			result.add(arr.get(row).get(col));
			if(goingDown) {
				if(col == 0 || row==height) {
					goingDown = false;
					if(row == height) {
						col = col+1;
					}
					else {
						row = row+1;
					}
				}
				else {
					col = col-1;
					row = row+1;
				}
			}
			else {
				if(col == width || row == 0) {
					goingDown = true;
					if(col == width) {
						row = row+1;
					}
					else {
						col = col+1;
					}
				}
				else {
					col = col+1;
					row = row-1;
				}
			}
		}
		
		return result;
	}
	
	public static boolean isOutOfBounds(int row, int col, int height, int width) {
		if (row<0 || row>height) {
			return true;
		}
		if (col<0 || col>width) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
