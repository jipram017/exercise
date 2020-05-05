package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary{
	static Map<String, PriorityQueue<String>> airports = new HashMap<String, PriorityQueue<String>>();
	static LinkedList<String> result = new LinkedList<String>();
	
    public static List<String> findItinerary(List<List<String>> tickets) {
    	for(List<String> ticket : tickets) {
    		airports.putIfAbsent(ticket.get(0), new PriorityQueue<String>());
    		airports.get(ticket.get(0)).offer(ticket.get(1));
    	}
    	
    	dfs("JFK");
    	return result;
    }
    
    public static void dfs(String airport) {
    	PriorityQueue<String> destination = airports.get(airport);
    	while(destination != null && !destination.isEmpty()) {
    		dfs(destination.poll());
    	}
    	result.addFirst(airport);
    }
    
	public static void main(String[] args) {
	    List<List<String>> tickets = new ArrayList<List<String>>();
		
		tickets.add(Arrays.asList("JFK", "SFO"));
		tickets.add(Arrays.asList("JFK", "ATL"));
		tickets.add(Arrays.asList("SFO", "ATL"));
		tickets.add(Arrays.asList("ATL", "JFK"));
		tickets.add(Arrays.asList("ATL", "SFO"));
		
	    List<List<String>> tickets2 = new ArrayList<List<String>>();
		
		tickets2.add(Arrays.asList("JFK", "KUL"));
		tickets2.add(Arrays.asList("JFK", "NRT"));
		tickets2.add(Arrays.asList("NRT", "JFK"));
		//tickets2.add(Arrays.asList("LHR", "SFO"));
		
		List<String> itinerary1 = findItinerary(tickets);
		for(String it : itinerary1){
			System.out.print(" " + it); 
		}
		
		System.out.println();
		List<String> itinerary2 = findItinerary(tickets2);
		for(String it2 : itinerary2) {
			System.out.print(" " + it2);
		}
	}

}
