package exercise;

public class UglyNumber {
	
	// Ugly numbers >> numbers divisible by 2, 3 and 5 or other set list of primes
    public static boolean isUgly(int num) {
    	if(num == 0) return false;
    	if(num == 1) return true;
    	if(num%2 == 0) {
    		num /= 2;
    		return isUgly(num);
    	}
    	if(num%3 == 0) {
    		num /= 3;
    		return isUgly(num);
    	}
    	if(num%5 == 0) {
    		num /= 5;
    		return isUgly(num);
    	}
    	return false;
    }
    
    // Time complexity O(N), Space complexity O(N)
    public static int nthUglyNumber(int n) {
    	if(n==0) return 0;
        int i = 0, j = 0, k = 0;
        int[] result = new int[n];
        result[0] = 1;
        
        for(int m = 1; m < n; m++) {
        	int multipleTwo = result[i] * 2;
        	int multipleThree = result[j] * 3;
        	int multipleFive = result[k] * 5;
        	
        	result[m] = Math.min(multipleTwo, Math.min(multipleThree, multipleFive));
        	if(result[m] == multipleTwo) {
        		i++;
        	}
        	if(result[m] == multipleThree) {
        		j++;
        	} 
        	if(result[m] == multipleFive) {
        		k++;
        	}   
        }
        
        return result[n-1];
    }
    
    // Time complexity O(N), Space complexity O(N)
    public static int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 0 || primes ==  null || primes.length == 0) return 0;
        int[] times = new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        
        for(int i = 1; i <n; i++) {
        	int min = Integer.MAX_VALUE;
        	for(int j = 0; j < times.length; j++) {
        		min = Math.min(min, primes[j] * result[times[j]]);
        	}
        	result[i] = min;
        	for(int j = 0; j < times.length; j++) {
        		if(primes[j] * result[times[j]] == min) {
        			times[j]++;
        		}
        	}
        }
        
        return result[n-1];
    }
    
	public static void main(String[] args) {
		int result = nthUglyNumber(10);
		System.out.print(result + " ");
		
		int[] primes = new int[] {2,7,13,19};
		int n = 12;
		System.out.print(nthSuperUglyNumber(n, primes));
	}

}
