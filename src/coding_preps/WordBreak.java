package coding_preps;

import java.util.Arrays;
import java.util.List;

/** LeetCode #139**/
public class WordBreak {
	// Time complexity O(N*N)
	// Space complexity O(N)
	// where N is size of the input string
	public static boolean wordBreak(String s, List<String> wordDict) {
		if(s.isEmpty() || s==null) return false;
		if(wordDict.isEmpty()) return false;
		
	    boolean[] breakable = new boolean[s.length()+1];
	    Arrays.fill(breakable, false);
	    breakable[0] = true;
	    
		for(int i=0; i<s.length(); i++) {
			if(breakable[i]) {
			for(int j=i+1; j<=s.length(); j++) {
				String sub = s.substring(i,j);
				if(wordDict.contains(sub)) {
					breakable[j] = true;
				}
			}}
		}
		
		return breakable[s.length()];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
