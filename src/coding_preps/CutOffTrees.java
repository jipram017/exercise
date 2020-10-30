package coding_preps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/** LeetCode #675 **/
public class CutOffTrees {
	// Time complexity O((RC)*(RC))
	// Space complexity O(RC)
	// where RC is forest dimension
	   public static int cutOffTree(List<List<Integer>> forest) {
	        if(forest == null || forest.isEmpty()) return 0;
	        List<int[]> trees = new ArrayList<int[]>();
	        int r = forest.size();
	        int c = forest.get(0).size();
	        
	        for(int i=0; i<r; i++) {
	        	for(int j=0; j<c; j++) {
	        		if(forest.get(i).get(j) > 1) {
	        			trees.add(new int[] {i, j, forest.get(i).get(j)});
	        		}
	        	}
	        }
	        
	        Collections.sort(trees, (a,b) -> Integer.compare(a[2], b[2]));
	        
	        int sr = 0, sc = 0, sum = 0;
	        for(int[] tree:trees) {
	        	int dist = bfs(sr, sc, tree[0], tree[1], forest);
	        	if(dist < 0) return -1;
	        	sum += dist;
	        	sr = tree[0]; sc = tree[1];
	        }
	        
	        return sum;
	    }
	    
	    public static int bfs(int sr, int sc, int dr, int dc, List<List<Integer>> forest) {
	    	int[][] dd = new int[][] {{-1,0}, {1,0}, {0,-1}, {0,1}};
	    	Queue<int[]> q = new LinkedList<int[]>();
	    	q.offer(new int[] {sr, sc, 0});
	    	boolean[][] visited = new boolean[forest.size()][forest.get(0).size()];
	    	visited[sr][sc] = true;
	    	
	    	while(!q.isEmpty()) {
	    		int[] p = q.poll();
	    		if(p[0] == dr && p[1] == dc) {
	    			return p[2];
	    		}
	    		for(int i=0; i<4; i++) {
	    			int xr = p[0] + dd[i][0];
	    			int yr = p[1] + dd[i][1];
	    			if(xr >= 0 && xr < forest.size() && yr >= 0 && yr < forest.get(0).size() && 
	    					!visited[xr][yr] && forest.get(xr).get(yr) > 0) {
	    				visited[xr][yr] = true;
	    				q.offer(new int[] {xr, yr, p[2] + 1});
	    			}
	    		}
	    	}
	    	
	    	return -1;
	    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
