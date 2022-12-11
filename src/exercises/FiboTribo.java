package exercises;

public class FiboTribo {
	// Time complexity O(N), space complexity O(1)
	public int fibonacci(int n) {
		int t0 = 0, t1 = 1, res = 0;
		for(int i = 2; i <= n; i++){
			res = t0+t1;
			t0 = t1;
			t1 = res;
	    }
	    return n == 0?0:n==1? 1: res;
	}
	
	// Time complexity O(N), space complexity O(1)
	public int tribonacci(int n) {
		int t0 = 0, t1 = 1, t2 = 1, res = 0;
		for(int i = 3; i <= n; i++){
			res = t0+t1+t2;
			t0 = t1;
			t1 = t2;
			t2 = res;
	    }
	    return n == 0?0:(n==1 || n==2)? 1: res;
	}
	   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
