package coding_preps;

import java.util.HashMap;
import java.util.Map;

import helper.DataStructure.TreeNode;

/** LeetCode #105 **/
public class ConstructBinaryTreeI {
	int pre_idx = 0;
	Map<Integer, Integer> map = null;
	int[] preorder, inorder;
	
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is length of inorder array
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0) return null;
    	map = new HashMap<Integer, Integer>();
    	this.preorder = preorder; this.inorder = inorder;
    	
    	int index = 0;
    	for(Integer num : inorder) {
    		map.put(num,  index++);
    	}
    	return buildTreeHelper(0, inorder.length);
    }
    
    public TreeNode buildTreeHelper(int startIdx, int endIdx) {
    	if(startIdx == endIdx) return null;
    	TreeNode root = new TreeNode(preorder[pre_idx]);
    	
    	int rootIdx = map.get(preorder[pre_idx]);
    	pre_idx++;
    	
    	root.left = buildTreeHelper(startIdx, rootIdx);
    	root.right = buildTreeHelper(rootIdx+1, endIdx);
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
