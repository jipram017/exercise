package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumDistancesTree {
	static List<Set<Integer>> graph;
	static int[] count, ans;
	static int numOfNodes;
	
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
    	graph = new ArrayList<Set<Integer>>();
    	count = new int[N];
    	ans = new int[N];
    	numOfNodes = N;
    	Arrays.fill(count, 1);
    	
    	for(int i=0; i<N; i++) {
    		graph.add(new HashSet<Integer>());
    	}
        for(int[] edge : edges) {
        	graph.get(edge[0]).add(edge[1]);
        	graph.get(edge[1]).add(edge[0]);
        }
        
        dfs1(0,-1);
        dfs2(0,-1);
        return ans;
    }
    
    public static void dfs1(int node, int parent) {
    	for(int child : graph.get(node)) {
    		if(child != parent) {
    			dfs1(child, node);
    			count[node] += count[child];
    			ans[node] += count[node];
    		}
    	}
    }
    
    public static void dfs2(int node, int parent) {
    	for(int child : graph.get(node)) {
    		if(child != parent) {
    			ans[child] = ans[node] + (numOfNodes-count[child]) - count[child];
    			dfs2(child, node);
    		}
    	}
    }
    
	public static void main(String[] args) {
		int N = 6;
	    int[][] edges = {{0,1}, {0,2}, {2,3}, {2,4}, {2,5}};
	    int[] result = sumOfDistancesInTree(N, edges);
	    for(int n : result) {
	    	System.out.print(" " + n);
	    }
	    
	}

}
