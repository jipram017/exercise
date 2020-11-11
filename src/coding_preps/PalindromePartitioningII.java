package coding_preps;

/** LeetCode #132 **/
public class PalindromePartitioningII {
	// Time complexity O(N*N)
	// Space complexity O(N*N)
	// where N is the length of input s
    public static int minCut(String s) {
        if(s.length()==0) return 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
        	cut[i] = i;
        	for(int j=0; j<=i; j++) {
        		if(s.charAt(i)==s.charAt(j) && ((i-j) <=  1 || dp[j+1][i-1])){
        			dp[j][i] = true;
        			
        			if(j>0) {
        				cut[i] = Math.min(cut[i], cut[j-1] + 1);
        			} else {
        				cut[i] = 0;
        			}
        		}
        	}
        }
        
        return cut[s.length()-1];
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
