package exercise;

public class ArrayPartition {
    public static boolean canThreePartsEqualSum(int[] A) {
       	if(A.length == 0) return true;
    	int sum = 0;
    	for(int i=0; i < A.length; i++) {
    		sum += A[i];
    	}
    	
    	if(sum%3 != 0) return false;
    	sum = sum/3;
    	
        int curSum = 0; int counter = 0;
        for(int i=0; i < A.length; i++) {
        	curSum += A[i];
        	if(curSum == sum) {
        		curSum = 0;
        		counter++;
        	}
        }
        
        if(counter >= 3) {
        	if(curSum == 0) return true;
        }
        
        return false;     
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
