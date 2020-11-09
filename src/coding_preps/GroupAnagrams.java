package coding_preps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** LeetCode #49 **/
public class GroupAnagrams {
	// Time complexity O(NKlogK)
	// Space complexity O(NK)
	// where N is the length of strs and K is max length of a string in strs
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0) return new ArrayList<List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String str : strs) {
        	char[] ch = str.toCharArray();
        	Arrays.sort(ch);
        	String newStr = String.valueOf(ch);
        	
        	List<String> l = null;
        	if(map.containsKey(newStr)) {
        		l = new ArrayList<String>(map.get(newStr));
        	} else {
        		l = new ArrayList<String>();
        	}
        	
      		l.add(str);
    		map.put(newStr, l);
        }
        
        result.addAll(map.values());
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
