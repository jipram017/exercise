package exercises;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
    	if(coins == null || coins.length == 0) return 0;
        int[] numCoints = new int[amount+1];
        Arrays.fill(numCoints, Integer.MAX_VALUE);
        numCoints[0] = 0;
        for(int denom : coins) {
        	for(int i = 0; i <= amount; i++) {
        		if(denom <= i && numCoints[i-denom] != Integer.MAX_VALUE) {
        			numCoints[i] = Math.min(numCoints[i], 1+numCoints[i-denom]);
        		}
        	}
        }
        
        return numCoints[amount] != Integer.MAX_VALUE ? numCoints[amount] : -1;
    }
    
    public static int change(int amount, int[] coins) {
    	int[] ways = new int[amount+1];
    	Arrays.fill(ways, 0);
    	ways[0] = 1;
    	for(int denom : coins) {
    		for(int i = 1; i <= amount; i++) {
    			if(denom <= i) {
    				ways[i] = ways[i] + ways[i-denom];
    			}
    		}
    	}
    	return ways[amount];
    }
    
	public static void main(String[] args) {
		int[] denoms = new int[] {1,2,5};
		int amount  = 11;
		System.out.println(coinChange(denoms, amount));
	}

}
