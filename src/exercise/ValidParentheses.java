package exercise;

import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
    	if(s.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++) {
    	   char a = s.charAt(i);
    	   if(a == '{' || a == '(' || a == '[') {
    		   stack.push(a);
    	   } else {
    		   char b = stack.peek();
    		   if(a == '}' && b == '{' || a == ')' && b == '(' || a == ']' && b == '[') {
    			   stack.pop();
    		   } else return false;
    	   }
        }
        return stack.isEmpty();  
    }
	public static void main(String[] args) {
		String s = "{[]}";
		boolean isValid = isValid(s);
		System.out.println(isValid);
	}

}
