package coding_preps;

public class BuySellStock {
	/** LeetCode #121 **/
	// Maximum profit with only one transaction (buy once then sell)
	// O(N) time, O(1) space
	public static int maxProfit1(int[] prices) {
		if(prices==null || prices.length==0) return 0;
		int minimum = prices[0], maximum = 0;
		
		for(int i=1; i<prices.length; i++) {
			minimum = Math.min(minimum, prices[i]);
			maximum = Math.max(maximum, prices[i]-minimum);
		}
		return maximum;
	}
	
	/** LeetCode #122 **/
	// Maximum profit with as many transactions
	// O(N) time, O(1) space
	public static int maxProfit2(int[] prices) {
		if(prices==null || prices.length==0) return 0;
		int maximum = 0;
		for(int i=1; i<prices.length; i++) {
			if(prices[i] >= prices[i-1]) {
				maximum += prices[i] - prices[i-1];
			}
		}
		return maximum;
	}
	
	/** LeetCode #123 **/
	// Maximum profit with at most 2 transactions
	// O(N) time, O(N) space
	public static int maxProfit3(int[] prices) {
		if(prices==null || prices.length==0) return 0;
		
		int minimum = prices[0];
		int[] left = new int[prices.length];
		left[0] = 0;
		for(int i=1; i<prices.length; i++) {
			minimum = Math.min(minimum, prices[i]);
			left[i] = Math.max(left[i-1], prices[i]-minimum);
		}
		
		int maximum = prices[prices.length-1];
		int[] right = new int[prices.length];
		right[prices.length-1] = 0;
		for(int i=prices.length-2; i>=0; i--) {
			maximum = Math.max(maximum, prices[i]);
			right[i] = Math.max(right[i+1], maximum-prices[i]);
		}
		
		int maxProfit = 0;
		for(int i=0; i<prices.length; i++) {
			maxProfit = Math.max(maxProfit, left[i]+right[i]);
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
