package coding_preps;

import java.util.Stack;

/** LeetCode #1249 **/
public class ParenthesesRemoval {
	
	// Time complexity O(N)
	// Space complexity O(N)
	public static String minRemoveToMakeValid(String s) {
		if(s.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch=='(') {
				sb.append(ch);
				stack.push(i);
			}
			else if(ch==')') {
				if(!stack.isEmpty()) {
					sb.append(ch);
					stack.pop();
				} else {
					sb.append(" ");
				}
			}
			else {
				sb.append(ch);
			}
		}
		
		while(!stack.isEmpty()) {
			int idx = stack.pop();
			sb.deleteCharAt(idx);
		}
		
		return sb.toString().replaceAll(" ", "");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "lee(t(c)o)de)";
		String s2 = "a)b(c)d";
		String s3 = "))((";
		String s4 = "(a(b(c)d)";
		System.out.println(minRemoveToMakeValid(s2));
	}

}
