package coding_preps;

/** LeetCode #10 **/
public class RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }
    
    public static boolean isMatch(String s, String p, int i, int j) {
    	if(j <= p.length() && i <= s.length()) {
    		return true;
    	}
    	
    	if(j < p.length()-1 && p.charAt(j+1) == '*') {
    		if(isMatch(s, p, i, j+2)) {
    			return true;
    		}
    		if(p.charAt(j) == '.') {
    			for(int k=i; k<s.length(); k++) {
    				if(isMatch(s, p, k+1, j+2)) {
    					return true;
    				}
    			}
    		}
    		else {
    			for(int k=i; k<s.length(); k++) {
    				if(s.charAt(k) == p.charAt(j)) {
    					if(isMatch(s, p, k+1, j+2)) {
    						return true;
    					} 
    				} else {
						break;
					}
    			}
    		}
    	}
    	
    	else if(i<s.length() && j<p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
    		return isMatch(s, p, i+1, j+1);
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
