package coding_preps;

import java.util.ArrayList;
import java.util.HashMap;

/** LeetCode #207 **/
public class CourseSchedule {
	
	// Time complexity O(j+d)
	// Space complexity O(j+d)
	// where j = numCourses and d = prerequisites.length()
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
    	if(numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
    		return true;
    	}
    	
    	int[] visited = new int[numCourses];
    	HashMap<Integer, ArrayList<Integer>> coursesMap = new HashMap<Integer, ArrayList<Integer>>();
    	
    	for(int[] prereq : prerequisites) {
    		if(coursesMap.containsKey(prereq[0])) {
    			coursesMap.get(prereq[0]).add(prereq[1]);
    		} else {
    			ArrayList<Integer> arr = new ArrayList<Integer>();
    			arr.add(prereq[1]);
    			coursesMap.put(prereq[0], arr);
    		}
    	}
    	
    	for(int i=0; i<numCourses; i++) {
    		if(!canFinish(visited, coursesMap, i)) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    
    public static boolean canFinish(int[] visited, HashMap<Integer, ArrayList<Integer>> map, int k) {
    	if(visited[k] == -1) return false;
    	if(visited[k] == 1) return true;
    	visited[k] = -1;
    	
    	if(map.containsKey(k)) {
    		ArrayList<Integer> prereqs = map.get(k);
        	for(int prereq : prereqs) {
        		if(!canFinish(visited, map, prereq)) {
        			return false;
        		}   		
        	}
    	}
    	
    	visited[k] = 1;
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2;
		int[][] prerequisites = new int[][] {{1,0}};
		System.out.println(canFinish(numCourses, prerequisites));
	}

}
