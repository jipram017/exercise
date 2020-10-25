package coding_preps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** LeetCode #315 **/
public class RightSmallerThan {
	// Time complexity O(N logN)
	// Space complexity O(N)
	// where N is num
	static class Node{
		Node left;
		Node right;
		
		int val;
		int leftSubtrees;
		int count;
		
		public Node(int value) {
			this.val = value;
		}
		
		public int insertNode(Node root, int num) {
			Node p = root;
			int result = 0;
			
			while(p != null) {
				if(num > p.val) {
					result += p.count + p.leftSubtrees;
					if(p.right == null) {
						Node right = new Node(num);
						right.count = 1;
						p.right = right;
						return result;
					} else{
						p = p.right;
					}
				}
				else if(num == p.val) {
					p.count++;
					return result + p.leftSubtrees;
				}
				else {
					p.leftSubtrees++;
					if(p.left == null) {
						Node left = new Node(num);
						left.count = 1;
						p.left = left;
						return result;
					} else{
						p = p.left;
					}
				}
			}
			
			return 0;
		}
	}
	
    public static List<Integer> countSmaller(int[] nums) {
    	List<Integer> result = new ArrayList<Integer>();
        if(nums==null || nums.length == 0) return result;
        
        Node root = new Node(nums[nums.length-1]);
        root.count = 1;
        
        result.add(0);
        for(int i=nums.length-2; i>=0; i--) {
        	result.add(root.insertNode(root, nums[i]));
        }
        
        Collections.reverse(result);
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
