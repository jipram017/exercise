package exercises;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> restoreIpAddresses(String s) {
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		dfs(result, temp, 0, s);
		
		List<String> finalResult = new ArrayList<String>();
		
		for(List<String> ls : result) {
			StringBuilder sb = new StringBuilder();
			for(String l : ls) {
				sb.append(l+".");
			}
			sb.setLength(sb.length() - 1);
			finalResult.add(sb.toString());
		}
		
		return finalResult;
	}
	
	public void dfs(List<List<String>> rst, List<String> tmp, int start, String s) {
		if(tmp.size() >= 4 && start != s.length()) {
			return;
		}
		if(tmp.size() + s.length() - start + 1 < 4) {
			return;
		}
		if(tmp.size() == 4 && start == s.length()) {
			ArrayList<String> t = new ArrayList<String>(tmp);
			rst.add(t);
			return;
		}
		
		for(int i=1; i <= 3; i++) {
			if(start+i > s.length()) {
				break;
			}
			
			String sub = s.substring(start, start+i);
			
			// handle case for e.g. 001
			if(i>1 && s.charAt(start) == '0') {
				break;
			}
			
			// number must be <= 255
			if(Integer.valueOf(sub) > 255) {
				break;
			}
			
			tmp.add(sub);
			dfs(rst, tmp, start+i, s);
			tmp.remove(tmp.size()-1);
		}
	}

}
