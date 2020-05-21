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
    
    public static boolean checkValidString(String s) {
    	if(s.isEmpty()) return false;
    	int hi=0; int lo=0;
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) != ')') {
    			hi++;
    		} else {
    			hi--;
    		}
    		
    		if(s.charAt(i) == '(') {
    			lo++;
    		} else {
    			lo--;
    		}
    		
    		if (hi < 0) break;
    		lo = Math.max(0,  lo);
    	}
    	return lo == 0;
    }
	public static void main(String[] args) {
		String s = "{[]}";
		boolean isValid = isValid(s);
		System.out.println(isValid);
		
		String t = "(*))";
		System.out.println(checkValidString(t));
	}

}
