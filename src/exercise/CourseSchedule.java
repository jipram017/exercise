package exercise;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0 && (prerequisites == null || prerequisites.length == 0)) return false;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int[] num : prerequisites) {
        	if(map.containsKey(num[0])) {
        		map.get(num[0]).add(num[1]);
        	} else {
        		ArrayList<Integer> list = new ArrayList<Integer>();
        		list.add(num[1]);
        		map.put(num[0], list);
        	}
        }
        
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
        	if(!canTakeCourse(i, visited, map)) {
        		return false;
        	}
        }
        
        return true;
    }
    
    public static boolean canTakeCourse(int i, int[] visited, HashMap<Integer, ArrayList<Integer>> map) {
    	if(visited[i] == 1) return true;
    	if(visited[i] == -1) return false;
    	
    	visited[i] = -1;
    	if(map.containsKey(i)) {
    		for(Integer prereq : map.get(i)) {
    			if(!canTakeCourse(prereq, visited, map)) {
    				return false;
    			}
    		}
    	}
    	
    	visited[i] = 1;
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
