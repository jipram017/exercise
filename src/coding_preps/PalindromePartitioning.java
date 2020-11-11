package coding_preps;

import java.util.ArrayList;
import java.util.List;

/** LeetCode #131 **/
public class PalindromePartitioning {
	// Time complexity O(N * 2^N)
	// Space complexity O(N)
	// where N is length of input s
    public static List<List<String>> partition(String s) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	ArrayList<String> temp = new ArrayList<String>();
        if(s==null || s.isEmpty()) return result;
        dfs(0, s, temp, result);
        return result;
    }
    
    public static void dfs(int start, String s, ArrayList<String> temp, List<List<String>> result) {
    	if(start >= s.length()) {
    		ArrayList<String> partition = new ArrayList<String>(temp);
    		result.add(partition);
    		return;
    	}
    	for(int i=start+1; i<=s.length(); i++) {
    		String sub = s.substring(start, i);
    		if(isPalindrome(sub)) {
    			temp.add(sub);
    			dfs(i, s, temp, result);
    			temp.remove(temp.size()-1);
    		}
    	}
    }
    
    public static boolean isPalindrome(String s) {
    	int left = 0;
    	int right = s.length()-1;
    	while(left < right) {
    		if(s.charAt(left) != s.charAt(right)) {
    			return false;
    		}
    		left++;
    		right--;
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
