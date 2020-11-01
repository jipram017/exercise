package coding_preps;

/** LeetCode #1559 **/
public class DetectCycleIn2DGrid {
	static boolean hasCycle = false;
    public static boolean containsCycle(char[][] grid) {
        if(grid == null || grid.length == 0) return false;
        int R = grid.length;
        int C = grid[0].length;
        
        // Initialize our parent array
        int[] parent = new int[R*C];
        for(int i=0; i<R*C; i++) {
        	parent[i] = i;
        }
        
        for(int i=0; i<R; i++) {
        	if(hasCycle) return hasCycle;
        	for(int j=0; j<C; j++) {
        		if(hasCycle) return hasCycle;
        		int val = (i*C) + j;
        		if(j != C-1 && grid[i][j] == grid[i][j+1]) {
        			union_it(parent, val, val+1);
        		}
        		if(i != R-1 && grid[i][j] == grid[i+1][j]) {
        			union_it(parent, val, val+C);
        		}
        	}
        }
        
        return hasCycle;
    }
    
    public static void union_it(int[] parent, int a, int b) {
    	int val1 = find_it(parent, a);
    	int val2 = find_it(parent, b);
    	if(val1 == val2) {
    		hasCycle = true;
    	}
    	else{
    		parent[val1] = val2;
    	}
    }
    
    public static int find_it(int[] parent, int val) {
    	if(parent[val] ==  val) return val;
    	return find_it(parent, parent[val]);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] c = new char[][] {{'a','b','b'},{'b','z','b'},{'b','b','a'}};
		System.out.println(containsCycle(c));
	}

}
