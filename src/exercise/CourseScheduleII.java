package exercise;

import java.util.LinkedList;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
    	if(prerequisites == null) return new int[0];
    	int n = prerequisites.length;
    	
    	// If there are no prerequisites, return all courses in order
    	if(n == 0) {
    		int[] res = new int[numCourses];
    		for(int i=0; i<numCourses; i++) {
    			res[i]=i;
    		}
    		return res;
    	}
    	
    	// Record the number of prerequisites for each course
    	int[] prereq = new int[numCourses];
    	for(int j = 0; j<n; j++) {
    		prereq[prerequisites[j][0]]++;
    	}
    	
    	// Add courses without prerequisite into a queue
    	LinkedList<Integer> q = new LinkedList<>();
    	for(int k = 0; k<numCourses; k++) {
    		if(prereq[k] == 0) {
    			q.offer(k);
    		}
    	}
    	
    	int numNoPrereq = q.size();
    	
    	// Initialize result
    	int[] result = new int[numCourses];
    	int m = 0;
    	
    	while(!q.isEmpty()) {
    		int top = q.remove();
    		result[m++] = top;
    		
    		for(int i = 0; i<n; i++) {
    			if(prerequisites[i][1] == top) {
    				prereq[prerequisites[i][0]]--;
    				if(prereq[prerequisites[i][0]] == 0) {
    					q.add(prerequisites[i][0]);
    					numNoPrereq++;
    				}
    			}
    		}
    	}
    	
    	if(numNoPrereq == numCourses) return result;
    	return new int[0];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
