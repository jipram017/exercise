package coding_preps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** LeetCode #1125 **/
public class SmallestSufficientTeam {
	// Time complexity O(M*2^N)
	// Space complexity O(2^N)
	// where N is length of req_skills and M is how many people in the input list
    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> reqSkillsMap = getRequiredSkillsMap(req_skills);
        Map<Integer, Integer> peopleSkillsMap = getPeopleSkillsMap(reqSkillsMap, people);
        ArrayList<Integer>[] dp = new ArrayList[1<<req_skills.length];
        dp[0] = new ArrayList<Integer>();
        
        for(int skillSet = 0; skillSet < dp.length; skillSet++) {
        	List<Integer> currTeam = dp[skillSet];
        	if(currTeam==null) continue;
        	for(int i=0; i<people.size(); i++) {
        		int mergedSkillSet = skillSet | peopleSkillsMap.get(i);
        		if(mergedSkillSet == skillSet) continue;
        		if(dp[mergedSkillSet] == null || dp[mergedSkillSet].size() > dp[skillSet].size() + 1) {
        			dp[mergedSkillSet] = new ArrayList<>(currTeam);
        			dp[mergedSkillSet].add(i);
        		}
        	}
        }
        
        return dp[dp.length-1].stream().mapToInt(i -> i).toArray();
    }
    
    public static Map<String, Integer> getRequiredSkillsMap(String[] req_skills){
    	Map<String, Integer> reqSkillsMap = new HashMap<String, Integer>();
    	for(int i=0; i<req_skills.length; i++) {
    		reqSkillsMap.put(req_skills[i], (1<<i));
    	}
    	return reqSkillsMap;
    }
    
    public static Map<Integer, Integer> getPeopleSkillsMap(Map<String, Integer> reqSkillsMap, List<List<String>> people){
    	Map<Integer, Integer> peopleSkillsMap = new HashMap<Integer, Integer>();
    	for(int i=0; i<people.size(); i++) {
    		int s = 0;
    		List<String> currentSkills = people.get(i);
    		for(String skill : currentSkills) {
    			s = s | reqSkillsMap.get(skill);
    		}
    		peopleSkillsMap.put(i, s);
    	}
    	return peopleSkillsMap;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
