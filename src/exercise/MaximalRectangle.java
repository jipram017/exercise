package exercise;

import java.util.Stack;

public class MaximalRectangle {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxRectangle = 0;
        int[][] heights = new int[matrix.length][matrix[0].length+1];
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == '1') {
        			if(i==0) {
        				heights[i][j] = 1;
        			} else {
        				heights[i][j] = heights[i-1][j] + 1;
        			}
        		} else {
        			heights[i][j] = 0;
        		}
        	}
        }
        
        for(int k = 0; k < matrix.length; k++) {
        	int currentMax = findMaximumRectangle(heights[k]);
        	if(currentMax > maxRectangle) {
        		maxRectangle = currentMax;
        	}
        }
        
        return maxRectangle;
    }
    
    public static int findMaximumRectangle(int[] heights) {
    	Stack<Integer> stack = new Stack<>();
    	int m = 0, maxRectangle = 0;
    	
    	while(m < heights.length) {
    		if(stack.isEmpty() || heights[stack.peek()] <= heights[m]) {
    			stack.push(m++);
    		} else {
    			int index = stack.pop();
    			int height = heights[index];
    			int width = stack.isEmpty()? m : m - stack.peek() - 1;
    			maxRectangle = Math.max(maxRectangle, height*width);
    		}
    	}
    	
    	return maxRectangle;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
