package coding_preps;

/** LeetCode #765 **/
public class CoupleHoldingHands {
	// time complexity O(N)
	// space complexity O(N)
	// where N is length of input
    public static int minSwapsCouples(int[] row) {
        int[] parent = new int[row.length];
        for(int i=0; i<row.length; i++) {
        	if(row[i]%2==0) parent[row[i]] = row[i];
        	else parent[row[i]] = row[i]-1;
        }
        
        int maxConnectedComponents = row.length/2;
        int curConnectedComponents = maxConnectedComponents;
        for(int i=0; i<row.length; i=i+2) {
        	int g1 = find_it(parent, row[i]);
        	int g2 = find_it(parent, row[i+1]);
        	if(g1 != g2) {
        		parent[g1] = g2;
        		curConnectedComponents--;
        	}
        }
        
        return maxConnectedComponents - curConnectedComponents;
    }
    
    public static int find_it(int[] parent, int k) {
    	if(parent[k] == k) return k;
    	return find_it(parent, parent[k]);
    }
    
	public static void main(String[] args) {
		int[] row1 = new int[] {2, 1, 5, 0, 3, 4};
		int[] row2 = new int[] {0,2,1,3};
		System.out.println(minSwapsCouples(row2));
	}

}
