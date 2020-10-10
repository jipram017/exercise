package coding_preps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/** LeetCode #332 **/
public class ReconstructItinerary {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is the number of airports
	
	static HashMap<String, PriorityQueue<String>> itineraries = new HashMap<String, PriorityQueue<String>>();
	static LinkedList<String> result = new LinkedList<String>();
	
	public List<String> findItinerary(List<List<String>> tickets) {
		for(List<String> ticket : tickets) {
			itineraries.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
			itineraries.get(ticket.get(0)).offer(ticket.get(1));
		}
		
		dfs("JFK");
		return result;
	}
	
	public static void dfs(String airport) {
		PriorityQueue<String> q = itineraries.get(airport);
		while(q!= null && !q.isEmpty()) {
			dfs(q.poll());
		}
		result.addFirst(airport);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
