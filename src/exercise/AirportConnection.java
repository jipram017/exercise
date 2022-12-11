package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AirportConnection {
	public static int minimumAirportConnection(ArrayList<String> airports, ArrayList<String[]> routes, String startingAirport, Boolean flag) {
		Map<String, AirportNode> airportGraph = createAirportGraph(airports, routes);
		List<AirportNode> unreachableAirportNodes = getUnreachableAirportNodes(airports, airportGraph, startingAirport);
		markUnreachableConnections(airportGraph, unreachableAirportNodes);
		return getMinimumAirportConnections(airportGraph, unreachableAirportNodes, flag, startingAirport);
	}
	
	// O(m+n) time, O(m+n) space where m = size of input airports and n = size of input routes
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
	
	// O(m+n) time, O(m) space where m = size of input airports and n = size of input routes 
	public static List<AirportNode> getUnreachableAirportNodes(ArrayList<String> airports, Map<String, AirportNode> airportGraph, String startingAirport){
		Map<String, Boolean> visitedAirports = new HashMap<String, Boolean>();
		dfsTraverseAirportNodes(airportGraph, visitedAirports, startingAirport);
		
		List<AirportNode> unreachableNodes = new ArrayList<AirportNode>();
		for(String airport : airports) {
			if(visitedAirports.containsKey(airport)) continue;
			AirportNode node = airportGraph.get(airport);
			node.isReachable = false;
			unreachableNodes.add(node);
		}
		return unreachableNodes;
	}
	
	public static void dfsTraverseAirportNodes(Map<String, AirportNode> airportGraph, Map<String, Boolean> visitedAirports, String airport) {
		if(visitedAirports.containsKey(airport) && visitedAirports.get(airport)) {
			return;
		}
		if(!airportGraph.get(airport).connections.isEmpty()) {
			visitedAirports.put(airport, true);
		}
		for(String connection : airportGraph.get(airport).connections) {
			dfsTraverseAirportNodes(airportGraph, visitedAirports, connection);
		}
	}
	
	
	public static void markUnreachableConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableNodes) {
		for(AirportNode node : unreachableNodes) {
			String airport = node.airport;
			List<String> unreachableConnections = new ArrayList<String>();
			dfsAddUnreachableConnections(airport, airportGraph, unreachableConnections, new HashMap<String,Boolean>());
			node.unreachableConnections = unreachableConnections;
		}
	}
	
	public static void dfsAddUnreachableConnections(String airport, Map<String, AirportNode> airportGraph, List<String> unreachableConnections, Map<String, Boolean> visitedAirports) {
		if(airportGraph.get(airport).isReachable) {
			return;
		}
		
		if(visitedAirports.containsKey(airport) && visitedAirports.get(airport)) {
			return;
		}
		
		visitedAirports.put(airport, true);
		unreachableConnections.add(airport);
		for(String connection : airportGraph.get(airport).connections) {
			dfsAddUnreachableConnections(connection, airportGraph, unreachableConnections, visitedAirports);
		}
	}
	
	public static int getMinimumAirportConnections(Map<String, AirportNode> airportGraph, List<AirportNode> unreachableAirportNodes, Boolean flag, String startingAirport) {
		int minConnections = 0;
		List<AirportNode> sortedUnreachableAirportNodes = 
				   unreachableAirportNodes.stream()
				  .sorted(Comparator.comparing((AirportNode p) -> p.unreachableConnections.size()).reversed())
				  .collect(Collectors.toList());
		
		for(AirportNode str : sortedUnreachableAirportNodes) {
			System.out.println(" " +str.airport + ": " + str.unreachableConnections.toString());
		}
		
		for(AirportNode node : sortedUnreachableAirportNodes) {
			if(node.isReachable) {
				continue;
			}
			if(flag && !node.unreachableConnections.contains(startingAirport)) {
				continue;
			}
			minConnections++;
			for(String connection : node.unreachableConnections) {
				airportGraph.get(connection).isReachable = true;
			}
		}
		
		return minConnections;
	}
	
	static class AirportNode{
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
	
	public static void main(String[] args) {
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
		int minConnections = minimumAirportConnection(airports, routes, startingAirport, false);
		System.out.println(minConnections);
	}

}
