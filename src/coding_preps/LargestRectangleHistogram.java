package coding_preps;

import java.util.Stack;

/** LeetCode #84 **/
public class LargestRectangleHistogram {
	
	// Time complexity O(N), space complexity O(N) where N is the size of input
	public static int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) return 0;
		int maxArea = 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		int i;
		
		for(i=0; i < heights.length; i++) {
			if(stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i);
				i++;
			}
			else {
				int j = stack.pop();
				int height = heights[j];
				int width = stack.isEmpty()? i : i - stack.peek() - 1;
				maxArea = Math.max(maxArea, height*width);
			}
		}
		
		while(!stack.isEmpty()) {
			int j = stack.pop();
			int height = heights[j];
			int width = stack.isEmpty()? i : i - stack.peek() - 1;
			maxArea = Math.max(maxArea, height*width);
		}
		
		return maxArea;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
