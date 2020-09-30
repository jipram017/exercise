package coding_preps;

import java.util.Stack;

/** LeetCode #85 **/
public class MaximalRectangle {
	// Time complexity O(N*N)
	// Space complexity O(N*N) 
	// where N is the size of input
	public static int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0) return 0;
		int maxArea = 0;
		int[][] heights = new int[matrix.length][matrix[0].length];
		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				if(i==0) heights[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
				else {
					if(matrix[i][j] == '1') {
						heights[i][j] = heights[i-1][j] + 1;
					} else {
						heights[i][j] = 0;
					}
				}
			}
		}
		
		for(int i = 0; i<matrix.length; i++) {
			int currentMax = findCurrentMax(heights[i]);
			maxArea = Math.max(maxArea, currentMax);
		}
		
		return maxArea;
	}
	
	public static int findCurrentMax(int[] heights) {
		Stack<Integer> stack = new Stack<Integer>();
		int m = 0, max = 0;
		
		while(m < heights.length) {
			if(stack.isEmpty() || heights[m] >= heights[stack.peek()]) {
				stack.push(m);
				m++;
			}
			else {
				int n = stack.pop();
				int height = heights[n];
				int width = stack.isEmpty()? m : m - stack.peek() - 1;
				max = Math.max(max, height*width);
			}
		}
		
		while(!stack.isEmpty()) {
			int n = stack.pop();
			int height = heights[n];
			int width = stack.isEmpty()? m : m - stack.peek() - 1;
			max = Math.max(max, height*width);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = new char[][]{
			{'1','0','1','0','0'},
			{'1','0','1','1','1'},
			{'1','1','1','1','1'},
			{'1','0','0','1','0'},
		};
		System.out.println(maximalRectangle(matrix));		
	}

}
