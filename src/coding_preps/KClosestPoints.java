package coding_preps;

import java.util.Arrays;

/** LeetCode #973 **/
public class KClosestPoints {
	// Time complexity O(N) on average
	// Space complexity O(log N)
    public static int[][] kClosest(int[][] points, int K) {
        int i=0, j=points.length-1;
        while(true) {
        	int pivot = partition(points, i,j);
        	if(pivot == K-1) {
        		return Arrays.copyOfRange(points, 0, K);
        	}
        	else if(pivot > K-1) {
        		j = pivot - 1;
        	}
        	else if(pivot < K-1) {
        		i = pivot + 1;
        	}
        }
    }
    
    private static int partition(int[][] points, int start, int end) {
    	swap(points, start + (int) Math.random()*(end-start+1), end);
    	int low = start;
    	for(int i=start; i<end; i++) {
    		if(compare(points[i], points[end]) < 0) {
    			swap(points, low, i);
    			low++;
    		}
    	}
    	swap(points, end, low);
    	return low;
    }
    
    private static int compare(int[] p1, int[] p2) {
    	return (p1[0]*p1[0] + p1[1]*p1[1]) - (p2[0]*p2[0] + p2[1]*p2[1]);
    }
    
    private static void swap(int[][] array, int idx1, int idx2) {
    	int[] temp = array[idx1];
    	array[idx1] = array[idx2];
    	array[idx2] = temp;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
