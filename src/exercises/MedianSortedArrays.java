package exercises;

public class MedianSortedArrays {
	
	// Time complexity O(log(min(m,n))), space complexity O(1)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // To ensure m<=n
        if(m>n) {
        	int[] temp = nums1; nums1 = nums2; nums2 = temp;
        	int tmp = m; m = n; n = tmp;
        }
        
        int halfLen = (m + n + 1)/2;
        int minCount = 0, maxCount = m;
        
        while(minCount <= maxCount) {
        	int i = (minCount + maxCount)/2;
        	int j = halfLen - i; 
        	
        	if(i<maxCount && nums2[j-1] > nums1[i]) {
        		minCount = i+1;
        	}
        	else if(i>minCount && nums1[i-1] > nums2[j]) {
        		maxCount = i-1;
        	}
        	else { // i is perfect
        		int maxLeft = 0;
        		if(i==0) maxLeft = nums2[j-1];
        		else if(j==0) maxLeft = nums1[i-1];
        		else {
        			maxLeft = Math.max(nums1[i-1], nums2[j-1]);
        		}
        		if((m+n)%2 == 1) return maxLeft;
        		
        		int minRight = 0;
        		if(i==m) minRight = nums2[j];
        		else if(j==n) minRight = nums1[i];
        		else {
        			minRight = Math.min(nums1[i], nums2[j]);
        		}
        		return (minRight+maxLeft)/2.0;
        	}
        }
        
        return 0.0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
