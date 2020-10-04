package coding_preps;

import java.util.Stack;

/** LeetCode #20 **/
public class ValidParentheses {
    // Time complexity O(N)
	// Space complexity O(N)
	// where N is size of the input
	public static boolean isValid(String s) {
		if(s.length() == 0|| s==null) return true;
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch=='(' || ch=='[' || ch=='{') {
				stack.push(ch);
			} else {
				if(stack.isEmpty()) return false;
				char ci = stack.peek();
				if(ch==')' && ci=='(' || ch==']' && ci=='[' || ch=='}' && ci=='{') {
					stack.pop();
				} else return false;
			}
		}
		
		return stack.isEmpty()? true:false;
		 
	}
	
	public static void main(String[] args) {
		String s = "{[]}";
		boolean isValid = isValid(s);
		System.out.println(isValid);
	}

}
