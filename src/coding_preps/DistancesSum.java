package coding_preps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** LeetCode #834 **/
public class DistancesSum {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is the number of nodes
	
	static int[] answer, count;
	static List<Set<Integer>> graph;
	static int numOfNodes;
	
	public static int[] sumOfDistancesInTree(int N, int[][] edges) {
		graph = new ArrayList<Set<Integer>>();
		answer = new int[N];
		count = new int[N];
		for(int i=0; i<N; i++) {
			graph.add(new HashSet<Integer>());
		}
		
		for(int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}
		
		Arrays.fill(count, 1);
		numOfNodes = N;
		dfs1(0,-1);
		dfs2(0,-1);
		return answer;
	}
	
	public static void dfs1(int node, int parent) {
		for(Integer child : graph.get(node)) {
			if(child != parent) {
				dfs1(child, node);
				count[node] += count[child];
				answer[node] += count[node];
			}
		}
	}
	
	public static void dfs2(int node, int parent) {
		for(Integer child : graph.get(node)) {
			if(child != parent){
				answer[child] = answer[node] - count[child] + (numOfNodes - count[child]);
				dfs2(child, node);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
