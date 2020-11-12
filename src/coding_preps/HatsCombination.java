package coding_preps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** LeetCode #1434 **/
public class HatsCombination {
	// Time complexity O(M*N*2^N)
	// Space complexity O(2^N)
	// where M is number of hats and N is number of people
    public static int numberWays(List<List<Integer>> hats) {
        if(hats==null || hats.size()==0) return 0;
        Map<Integer, Set<Integer>> hatsToPeople = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        long[] dp = new long[1<<hats.size()];
        dp[0] = 1L;
        int mod = (int)1e9+7;
        
        for(int i=0; i<hats.size(); i++) {
        	for(int j=0; j<hats.get(i).size(); j++) {
        		hatsToPeople.computeIfAbsent(hats.get(i).get(j), k -> new HashSet<>()).add(i);
        		set.add(hats.get(i).get(j));
        	}
        }
        
        List<Integer> allHatsList = new ArrayList<Integer>(set);
        
        for(int i=0; i<allHatsList.size(); i++) {
        	for(int j=dp.length-1; j>=0; j--) {
        		for(Integer person : hatsToPeople.get(allHatsList.get(i))) {
        			if((j & (1<<person))==0) {
        				int newState = j | (1<<person);
        				dp[newState] = (dp[newState] + dp[j])%mod;
        			}
        		}
        	}
        }
        
        return (int) dp[dp.length-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
