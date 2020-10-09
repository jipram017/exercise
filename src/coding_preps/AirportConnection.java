package coding_preps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AirportConnection {
	static class AirportNode {
		private String airport;
		private boolean isReachable;
		private List<String> connections;
		private List<String> unreachableConnections;
		
		private AirportNode(String airport) {
			this.airport = airport;
			this.isReachable = true;
			this.connections = new ArrayList<String>();
			this.unreachableConnections = new ArrayList<String>();
		}
	}
	
	public static int minimumAirportConnection(ArrayList<String> airports, ArrayList<String[]> routes, String startingAirport) {
		Map<String, AirportNode> airportGraph = createAirportGraph(airports, routes);
		List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(airportGraph, startingAirport, airports);
		markUnreachableConnections(airportGraph, unreachableAirportNodes);
		return getMinimumNewConnections(airportGraph, unreachableAirportNodes, startingAirport);
	}
	
	// Time complexity O(a+r), space complexity O(a+r)
	// where a is the number of airport, r is the number of routes
	public static Map<String, AirportNode> createAirportGraph(List<String> airports, List<String[]> routes){
		Map<String, AirportNode> airportGraph = new HashMap<String, AirportNode>();
		for(String airport : airports) {
			airportGraph.put(airport, new AirportNode(airport));
		}
		for(String[] route : routes) {
			airportGraph.get(route[0]).connections.add(route[1]);
		}
		return airportGraph;
	}
	
	// Time complexity O(a+r), space complexity O(a)
	// where a is the number of airport, r is the number of routes
	public static List<AirportNode> getUnreachableAirportNodes(Map<String, AirportNode> airportGraph, String startingAirport, List<String> airports){
		Map<String, Boolean> visitedAirport = new HashMap<String, Boolean>();
		for(String airport : airports) {
			visitedAirport.put(airport, false);
		}
		depthFirstTraverseAirports(airportGraph, startingAirport, visitedAirport);
		List<AirportNode> unreachableAirportNodes = new ArrayList<AirportNode>();
		for(String airport : airports) {
			if(visitedAirport.get(airport)) continue;
			AirportNode airportNode = airportGraph.get(airport);
			airportNode.isReachable = false;
			unreachableAirportNodes.add(airportNode);
		}
		return unreachableAirportNodes;
	}
	
	public static void depthFirstTraverseAirports(Map<String, AirportNode> airportGraph, String startingAirport, Map<String, Boolean> visitedAirport) {
		if(visitedAirport.get(startingAirport)) return;
		visitedAirport.put(startingAirport,  true);
		for(String connection : airportGraph.get(startingAirport).connections) {
			depthFirstTraverseAirports(airportGraph, connection, visitedAirport);
		}
	}
	
	// Time complexity O(a*(a+r)), space complexity O(a)
	// where a is the number of airport, r is the number of routes
	public static void markUnreachableConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes) {
		for(AirportNode node : unreachableAirportNodes) {
			String airport = node.airport;
			List<String> unreachableConnections = new ArrayList<String>();
			depthFirstAddUnreachableConnections(airportGraph, unreachableConnections, airport, new HashMap<String, Boolean>());
			node.unreachableConnections = unreachableConnections;
		}
	}
	
	public static void depthFirstAddUnreachableConnections(Map<String, AirportNode> airportGraph, List<String>unreachableConnections, String airport, HashMap<String, Boolean> visitedAirport) {
		if(airportGraph.get(airport).isReachable) return;
		if(visitedAirport.containsKey(airport) && visitedAirport.get(airport)) return;
		visitedAirport.put(airport, true);
		unreachableConnections.add(airport);
		for(String connection : airportGraph.get(airport).connections) {
			depthFirstAddUnreachableConnections(airportGraph, unreachableConnections, connection, visitedAirport);
		}
	}
	
	// Time complexity O(alog(a) + a + r), space complexity O(1)
	// where a is the number of airport, r is the number of routes
	public static int getMinimumNewConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes, String startingAirport) {
		int minNewConnections = 0;
		List<AirportNode> sortedUnreachableAirportNodes = 
				unreachableAirportNodes.stream()
				.sorted(Comparator.comparing((AirportNode p) -> p.unreachableConnections.size()).reversed())
				.collect(Collectors.toList());
		
		for(AirportNode airportNode : sortedUnreachableAirportNodes) {
			if(airportNode.isReachable) continue;
			minNewConnections++;
			for(String connection : airportNode.unreachableConnections) {
				airportGraph.get(connection).isReachable = true;
			}
		}
		return minNewConnections;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String[]> routes = new ArrayList<String[]>();
		routes.add(new String[] {"DSM", "ORD"});
		routes.add(new String[] {"ORD", "BGI"});
		routes.add(new String[] {"BGI", "LGA"});
		routes.add(new String[] {"SIN", "CDG"});
		routes.add(new String[] {"CDG", "SIN"});
		routes.add(new String[] {"CDG", "BUD"});
		routes.add(new String[] {"DEL", "DOH"});
		routes.add(new String[] {"DEL", "CDG"});
		routes.add(new String[] {"TLV", "DEL"});
		routes.add(new String[] {"EWR", "HND"});
		routes.add(new String[] {"HND", "ICN"});
		routes.add(new String[] {"HND", "JFK"});
		routes.add(new String[] {"ICN", "JFK"});
		routes.add(new String[] {"JFK", "LGA"});
		routes.add(new String[] {"EYW", "LHR"});
		routes.add(new String[] {"LHR", "SFO"});
		routes.add(new String[] {"SFO", "SAN"});
		routes.add(new String[] {"SFO", "DSM"});
		routes.add(new String[] {"SAN", "EYW"});
		
		ArrayList<String> airports = new ArrayList<String>(
				Arrays.asList("BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN",
						      "JFK", "LGA", "LHR", "ORD", "SAN", "SFO", "SIN", "TLV", "BUD")
				);
		
		String startingAirport = "LGA";
		int minConnections = minimumAirportConnection(airports, routes, startingAirport);
		System.out.println(minConnections);
	}

}
