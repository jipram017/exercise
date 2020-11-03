package coding_preps;

import java.util.ArrayList;
import java.util.List;

/** LeetCode #60 **/
public class PermutationSequence {
	// Time complexity O(N)
	// Space complexity O(N)
    public static String getPermutation(int n, int k) {
        if(n==0) return "";
        int mod = 1;
        for(int i=1; i<=n; i++) {
        	mod *= i;
        }
        
        List<Integer> numList = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
        	numList.add(i);
        }
        
        k--;
        String numResult = "";
        for(int i=0; i<n; i++) {
        	mod /= (n-i);
        	int currentIdx = k / mod;
        	k = k%mod;
        	numResult = numResult + numList.get(currentIdx);
        	numList.remove(currentIdx);
        }
        
        return numResult;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
