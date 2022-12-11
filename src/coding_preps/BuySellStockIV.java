package coding_preps;

/** LeetCode #188 **/
public class BuySellStockIV {
	// Maximum profit with at most k transactions
	// Time complexity O(kN) where k=number of transactions and N=number of input integers
	// Space complexity O(N) since we only store as many as N results
	public static int maxProfit(int k, int[] prices) {
		if(k==0 || prices==null || prices.length==0) return 0;
		
		// First we check if k is quite large (k >= prices.length/2), then we can do quickSolve
		// that is, by considering that we can do as many transactions as we want
		if(k >= prices.length / 2) return quickSolve(prices);
		
		int[][] profit = new int[2][prices.length+1];
		for(int i=0; i<=prices.length; i++) {
			profit[0][i] = 0;
		}
		
		for(int i=1; i<=k; i++) {
			int idx = 1 - (i & 1);
			int maxPrev = Integer.MIN_VALUE;
			for(int j=1; j<prices.length; j++) {
			    maxPrev = Math.max(profit[idx][j-1] - prices[j-1], maxPrev);
				profit[1-idx][j] = Math.max(profit[1-idx][j-1], prices[j] + maxPrev);
			}
		}
		
		return profit[k%2][prices.length-1];
	}
	
	public static int quickSolve(int[] prices) {
		int maxVal = 0;
		for(int i=1; i<prices.length; i++) {
			if(prices[i] >= prices[i-1]) {
				maxVal += prices[i] - prices[i-1];
			}
		}
		return maxVal;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
