package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

    public static List<String> findItinerary(List<List<String>> tickets) {
    	Map<String, List<String>> airports = new HashMap<String, List<String>>();
        for(List<String> route : tickets) {
        	if(airports.containsKey(route.get(0))){
        		List<String> destinationAirports = airports.get(route.get(0));
        		destinationAirports.add(route.get(1));
        	} else {
        		List<String> destinationAirports = new ArrayList<String>();
            	destinationAirports.add(route.get(1));
            	airports.put(route.get(0), destinationAirports);
        	}
        }
        
		for (List<String> destinationAirport : airports.values()) {
			Collections.sort(destinationAirport);
		}
        List<String> itineraryList = new ArrayList<String>();
        dfsTraverseAirportNode("JFK",airports,itineraryList);
        Collections.reverse(itineraryList);
        return itineraryList;
    }
    
    public static void dfsTraverseAirportNode(String startingAirport, Map<String, List<String>> airports,
    		                                  List<String> itineraryList) {
    	
    	if(airports.get(startingAirport) == null) {
    		itineraryList.add(startingAirport);
    		return;
    	}
    	itineraryList.add(startingAirport);	
    	Iterator<String> it = airports.get(startingAirport).iterator();
    	while(it.hasNext()) {
    		String dest = it.next();
    		it.remove();
    		dfsTraverseAirportNode(dest,airports,itineraryList);
    	}	
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
		
		/*
		 * List<String> itinerary1 = findItinerary(tickets); for(String it : itinerary1)
		 * { System.out.print(" " + it); }
		 */
		
		System.out.println();
		List<String> itinerary2 = findItinerary(tickets2);
		for(String it : itinerary2) {
			System.out.print(" " + it);
		}
	}

}
