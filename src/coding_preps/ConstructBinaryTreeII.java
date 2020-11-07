package coding_preps;

import java.util.HashMap;
import java.util.Map;

import helper.DataStructure.TreeNode;

/** LeetCode #106 **/
public class ConstructBinaryTreeII {
	Map<Integer, Integer> map = null;
	int post_idx;
	int[] inorder, postorder;
	
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is length of inorder array
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null || inorder.length==0 || postorder==null || postorder.length==0) return null;
		map = new HashMap<Integer, Integer>();
		this.inorder = inorder; this.postorder = postorder;
		int idx = 0;
		for(Integer num : inorder) {
			map.put(num, idx++);
		}
		post_idx = postorder.length - 1;
		return buildTreeHelper(0, inorder.length - 1);
	}
	
	public TreeNode buildTreeHelper(int startIdx, int endIdx) {
		if(startIdx > endIdx) return null;
		TreeNode root = new TreeNode(postorder[post_idx]);
		
		int rootIdx = map.get(postorder[post_idx]);
		post_idx--;
		root.right = buildTreeHelper(rootIdx+1, endIdx);
		root.left = buildTreeHelper(startIdx, rootIdx-1);
		return root;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
