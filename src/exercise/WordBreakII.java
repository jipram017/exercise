package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreakII {
	
	public static List<String> wordBreak(String s, List<String> wordDict){
		Set<String> dict = wordDict.stream().collect(Collectors.toSet());
		return recursiveWordBreak(s, dict, 0, new HashMap<Integer, List<String>>());
	}
	
	public static List<String> recursiveWordBreak(String s, Set<String> wordDict, int index, HashMap<Integer, List<String>> map){
		if(index == s.length()) {
			return Collections.singletonList("");
		}
		
		if(map.containsKey(index)) {
			return map.get(index);
		}
		
		List<String> words = new ArrayList<String>();
		
		for(int end = index; end <= s.length(); end++) {
			String sub = s.substring(index, end);
			if(wordDict.contains(sub)) {
				List<String> next_sub = recursiveWordBreak(s, wordDict, end, map);
				for(String str : next_sub) {
					if(!str.equals("")) {
						words.add(sub+" "+str);
					} else {
						words.add(sub);
					}
				}
			}
		}
		
		map.put(index, words);
		return words;
	}

	public static void main(String[] args) {
		String s = "catsanddogr";
	    List<String> wordDict = new ArrayList<String>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
	    List<String> result = wordBreak(s, wordDict);
	    for(String str : result) {
	    	System.out.println(str);
	    }
	}

}
