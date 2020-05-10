package exercise;

public class ValidParenthesesString {
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
		String s = "(*))";
		System.out.println(checkValidString(s));
	}

}
