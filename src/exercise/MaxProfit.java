package exercise;

public class MaxProfit {
	// Max Profit with Only One Transaction
	public static int maxProfit1(int[] prices) {
		if(prices.length == 0) return 0;
		int min = prices[0], max = 0;
		for(int price : prices) {
			max = Math.max(max, price - min);
			min = Math.min(min, price);
		}
		return max;
	}
	
	// Max Profit with As Many Transactions
	public static int maxProfit2(int[] prices) {
		if(prices.length == 0) return 0;
		int max = 0;
		for(int i = 1; i < prices.length; i++) {
			if(prices[i] - prices[i-1] > 0) {
				max += prices[i] - prices[i-1];
			}
		}
		return max;
	}
	
	// Max Profit with At Most 2 Transaction
	public static int maxProfit3(int[] prices) {
		if(prices.length == 0) return 0;
		
		int[] left = new int[prices.length];
		int min = prices[0]; 
		left[0] = 0; 
		for(int i = 1; i < prices.length; i++) {
			left[i] = Math.max(left[i-1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		
		int[] right = new int[prices.length];
		right[prices.length - 1] = 0;
		int max = prices[prices.length-1];
		for(int j = prices.length-2; j >= 0; j--) {
			max = Math.max(max, prices[j]);
			right[j] = Math.max(right[j+1], max - prices[j]);
		}
		
		int profit = 0;
		for(int k = 0; k <prices.length; k++) {
			profit = Math.max(profit, left[k]+right[k]);
		}
		
		return profit;
	}
	
	// Max Profit with At Most k Transactions
	public static int maxProfit4(int[] prices, int k) {
		if(prices.length == 0) return 0;
		if (k >= prices.length / 2) {
			return maxProfit2(prices);
		}
		
		int maxProfit;
		int[] oddProfits = new int[prices.length];
		int[] evenProfits = new int[prices.length];
		
		for(int i = 1; i <= k ; i++) {
			maxProfit = Integer.MIN_VALUE;
			int[] previousProfits = new int[prices.length];
			int[] currentProfits = new int[prices.length];
			if(i % 2 == 0) {
				currentProfits = evenProfits;
				previousProfits = oddProfits;
			} else {
				currentProfits = oddProfits;
				previousProfits = evenProfits;
			}			
			for(int j = 1; j < prices.length; j++) {
				maxProfit = Math.max(maxProfit, previousProfits[j-1] - prices[j-1]);
				currentProfits[j] = Math.max(currentProfits[j-1], prices[j] + maxProfit);
			}
		}
		
		return k%2 == 0? evenProfits[prices.length-1]: oddProfits[prices.length-1]; 
	}
	
	public static void main(String[] args) {
		int[] prices1 = new int[] {7,1,5,3,6,4};
		int[] prices2 = new int[] {3,2,6,5,0,3};
		System.out.print(maxProfit4(prices2, 2));
	}

}
