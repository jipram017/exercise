package exercise;

public class SuperUglyNumber {
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
		int[] primes = new int[] {2,7,13,19};
		int n = 12;
		System.out.println(nthSuperUglyNumber(n, primes));
	}

}
