package exercise;

import java.util.Stack;

public class HistogramLargestRectangle {
    public static int largestRectangleArea(int[] heights) {
        if(heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0, maxRectangle = 0;
        
        while(i < heights.length) {
        	if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
        		stack.push(i);
        		i++;
        	} else {
        		Integer prev = stack.pop();
        		int height = heights[prev];
        		int width = stack.isEmpty()? i : i - stack.peek() - 1;
        		maxRectangle = Math.max(maxRectangle, height*width);
        	}
        }
        
        while(!stack.isEmpty()) {
       		Integer prev = stack.pop();
    		int height = heights[prev];
    		int width = stack.isEmpty()? i : i - stack.peek() - 1;
    		maxRectangle = Math.max(maxRectangle, height*width);
        }
        
        return maxRectangle;  
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
