package exercise;

import java.util.Stack;

public class MinimumParenthesesRemoval {
	// Using StringBuilder Only
    public static String minRemoveToMakeValid2(String s) {
    	if(s.isEmpty()) return s;
    	StringBuilder builder = new StringBuilder();
        int open = 0;
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) == '(') open++;
        	else if(s.charAt(i) == ')') {
        		if(open == 0) continue;
        		open--;
        	}
        	builder.append(s.charAt(i));
        }
        
        StringBuilder result = new StringBuilder();
        for(int j = builder.length()-1; j >= 0; j--) {
        	if(builder.charAt(j) == '(' && open-- > 0) continue;
        	result.append(builder.charAt(j));
        }
        return result.reverse().toString();
    }
    
    // Using stack and string builder
    public static String minRemoveToMakeValid(String s) {
    	  StringBuilder sb = new StringBuilder(s);
    	  Stack<Integer> st = new Stack<>();
    	  for (int i = 0; i < sb.length(); ++i) {
    	    if (sb.charAt(i) == '(') st.add(i);
    	    if (sb.charAt(i) == ')') {
    	      if (!st.empty()) st.pop();
    	      else sb.setCharAt(i, '*');
    	    }
    	  }
    	  while (!st.empty())
    	    sb.setCharAt(st.pop(), '*');
    	  return sb.toString().replaceAll("\\*", "");
    }
    
	public static void main(String[] args) {
		String s= "())()(((";
		System.out.println(minRemoveToMakeValid(s));
	}

}
