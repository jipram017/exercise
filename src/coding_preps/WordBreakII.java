package coding_preps;

import java.util.ArrayList;
import java.util.List;

/** LeetCode #140 **/
public class WordBreakII {
	// Time complexity O(N*N)
	// Space complexity O(N)
	// where N is size of the input string
	public static List<String> wordBreak(String s, List<String> wordDict) {
		if(s==null || s.isEmpty() || wordDict.isEmpty()) return new ArrayList<String>();		
		List<String> [] result = new ArrayList[s.length()+1];
		result[0] = new ArrayList<String>();
		
		for(int i=0; i<s.length(); i++) {
			if(result[i] != null) {
				for(int j=i+1; j<s.length()+1; j++) {
					String sub = s.substring(i,j);
					if(wordDict.contains(sub)) {
						if(result[j]==null) {
							List<String> l = new ArrayList<String>();
							l.add(sub);
							result[j]=l;
						} else {
							result[j].add(sub);
						}
					}
				}
			}
		}
		
		// Traverse through all the results
		if(result[s.length()] == null) return new ArrayList<String>();
		List<String> tmp = new ArrayList<String>();
		dfs(result, tmp, "", s.length());
		return tmp;
	}
	
	public static void dfs(List<String> [] result, List<String> tmp, String s, int slen) {
		if(slen == 0) {
			tmp.add(s.trim());
		}
		for(String str : result[slen]) {
			String current = str + " " + s;
			dfs(result, tmp, current, slen-str.length());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
