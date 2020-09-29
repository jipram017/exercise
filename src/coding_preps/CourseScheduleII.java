package coding_preps;

import java.util.LinkedList;

/** LeetCode #210 **/
public class CourseScheduleII {
	
	// Time complexity O(j+d)
	// Space complexity O(j+d)
	// where j = numCourses and d = prerequisites.length()
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(numCourses == 0) return new int[0];
		
		// If there are no prerequisites, return sequence of courses 
		if(prerequisites.length == 0) {
			int[] result = new int[numCourses];
			for(int m=0; m<numCourses; m++) {
				result[m] = m;
			}
			return result;
		}
		
		// Records the number of prerequisites each course have
		int[] numPrereqs = new int[numCourses];
		for(int m=0; m<prerequisites.length; m++) {
			numPrereqs[prerequisites[m][0]]++;
		}
		
		// Store course with no prerequisite
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int m=0; m<numCourses; m++) {
			if(numPrereqs[m] == 0) {
				queue.offer(m);
			}
		}
		
		// Initialize result
		int[] result = new int[numCourses];
		int j=0;
		int numNoPrereqs = queue.size();
		
		while(!queue.isEmpty()) {
			int course = queue.remove();
			result[j++] = course;
			
			for(int m=0; m<prerequisites.length; m++) {
				if(prerequisites[m][1] == course) {
					numPrereqs[prerequisites[m][0]]--;
					if(numPrereqs[prerequisites[m][0]] == 0) {
						queue.offer(prerequisites[m][0]);
						numNoPrereqs++;
					}
				}
			}
		}
		
		if(numNoPrereqs == numCourses) return result;
		return new int[0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
