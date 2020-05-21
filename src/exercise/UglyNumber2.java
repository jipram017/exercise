package exercise;

public class UglyNumber2 {
    public static int nthUglyNumber(int n) {
    	if(n==0) return 0;
        int i = 0, j = 0, k = 0;
        int[] result = new int[n];
        result[0] = 1;
        
        for(int m = 1; m < n; m++) {
        	int multipleTwo = result[i] * 2;
        	int multipleThree = result[j] * 3;
        	int multipleFive = result[k] * 5;
        	
        	int min = Math.min(multipleTwo, Math.min(multipleThree, multipleFive));
        	result[m] = min;
        	if(min == multipleTwo) {
        		i++;
        	}
        	if(min == multipleThree) {
        		j++;
        	} 
        	if(min == multipleFive) {
        		k++;
        	}
        }
        
        return result[n-1];
    }
    
	public static void main(String[] args) {
		int result = nthUglyNumber(10);
		System.out.print(result + " ");
	}

}