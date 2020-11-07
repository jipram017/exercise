package coding_preps;

import java.util.HashMap;
import java.util.Map;

import helper.DataStructure.TreeNode;

/** LeetCode #889 **/
public class ConstructBinaryTreeIII {
	Map<Integer, Integer> map = null;
	int pre_idx;
	int[] preorder, postorder;
	
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is length of postorder array
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        //if(pre==null || pre.length==0 || post==null || post.length==0) return null;
		map = new HashMap<Integer, Integer>();
		this.preorder = pre; this.postorder = post;
		
		int idx = 0;
		for(Integer num : post) {
			map.put(num, idx++);
		}
		pre_idx = 0;
		return buildTreeHelper(0, preorder.length-1);
    }
    
    public TreeNode buildTreeHelper(int startIdx, int endIdx) {
    	if(startIdx>endIdx) return null;
    	
    	TreeNode root = new TreeNode(preorder[pre_idx++]);
        if(pre_idx == preorder.length) return root;
    	
    	int rootIdx = map.get(preorder[pre_idx]);
    	if(startIdx <= endIdx-1) {
    		root.left = buildTreeHelper(startIdx, rootIdx);
    	    root.right = buildTreeHelper(rootIdx+1, endIdx-1);
    	}
    	
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
