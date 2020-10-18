package coding_preps;

/** LeetCode #4 **/
public class MedianTwoSortedArrays {
	// Time complexity O(log k) where k = min(m,n)
	// Space complexity O(1)
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		if(m>n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int half = (m+n+1)/2;
		int minIndex = 0, maxIndex = m, i=0, j=0;
		
		while(minIndex <= maxIndex) {
			i = (minIndex + maxIndex)/2;
			j = half - i;
			if(i > 0 && j < n && nums1[i-1] > nums2[j]) {
				maxIndex = i-1;
			}
			else if(i < m && j > 0 && nums2[j-1] > nums1[i]) {
				minIndex = i+1;
			}
			else {
				// We have the solution here
				break;
			}
		}
		
		int maxLeft = 0;
		if(i==0) maxLeft = nums2[j-1];
		else if(j==0) maxLeft = nums1[i-1];
		else {
			maxLeft = Math.max(nums1[i-1], nums2[j-1]);
		}
		
		// if (m+n) is odd return maxLeft
		if((m+n)%2 != 0) {
			return maxLeft * 1.0;
		}
		
		// if (m+n) is even, we need to find out the next larger value
		int minRight = 0;
		if(i==m) minRight = nums2[j];
		else if(j==n) minRight = nums1[i];
		else {
			minRight = Math.min(nums1[i], nums2[j]);
		}
		
		return (maxLeft + minRight)/2.0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
