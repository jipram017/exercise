package coding_preps;

import java.util.ArrayList;
import java.util.List;

/** LeetCode #93 **/
public class RestoreIPAddresses {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is length of input s
	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if(s==null || s.isEmpty() || s.length() < 4) return result;
		dfs(s, 0, "", result);
		return result;
	}
	
	public static void dfs(String s, int count, String res, List<String> result){
		if(count == 4 && s.length() == 0) {
			result.add(res.substring(0, res.length() - 1));
		}
		if(count == 4) return;
		if(s.length() == 0) return;
		
		if(s.length() >= 1) dfs(s.substring(1, s.length()), count+1, res + s.substring(0, 1) + ".", result);
		if(s.length() >= 2 && isValid(s.substring(0,2))) dfs(s.substring(2, s.length()), count+1, res + s.substring(0, 2) + ".", result);
		if(s.length() >= 3 && isValid(s.substring(0,3))) dfs(s.substring(3, s.length()), count+1, res + s.substring(0, 3) + ".", result);
	}
	
	public static boolean isValid(String s) {
		return s.charAt(0) != '0' && Integer.parseInt(s) <= 255;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
