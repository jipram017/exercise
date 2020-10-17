package coding_preps;

import java.util.PriorityQueue;

/** LeetCode #407 **/
public class TrappingRainWaterII {
	private static class Node {
		int row, column, height;
		public Node(int x, int y, int h) {
			this.row = x;
			this.column = y;
			this.height = h;
		}
	}
	
	// Time complexity O(nm log nm)
	// Space complexity O(nm)
	// where mxn is size of input map
    public static int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length==0) return 0;
        int[][] hm = heightMap;
        int m = hm.length, n = hm[0].length;
        
        PriorityQueue<Node> q = new PriorityQueue<Node>((a,b) -> a.height-b.height);
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	q.offer(new Node(i, 0, hm[i][0]));
        	q.offer(new Node(i, n-1, hm[i][n-1]));
        	visited[i][0] = true;
        	visited[i][n-1] = true;
        }
        
        for(int j=0; j<n; j++) {
        	q.offer(new Node(0, j, hm[0][j]));
        	q.offer(new Node(m-1, j, hm[m-1][j]));
        	visited[0][j] = true;
        	visited[m-1][j] = true;
        }
        
        int[][] dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int maxWater = 0;
        int currentLevel = Integer.MIN_VALUE;
        
        while(!q.isEmpty()) {
        	Node top = q.poll();
        	if(top.height < currentLevel) {
        		maxWater += currentLevel - top.height;
        	}
        	currentLevel = Math.max(currentLevel, top.height);
        	
        	for(int[] dir : dirs) {
        		int dx = top.row + dir[0];
        		int dy = top.column + dir[1];
        		if(dx < 0 || dx > m || dy < 0 || dy > n) {
        			continue;
        		}
        		if(visited[dx][dy]) {
        			continue;
        		}
        		q.offer(new Node(dx, dy, hm[dx][dy]));
        		visited[dx][dy] = true;
        	}
        }
        
        return maxWater;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
