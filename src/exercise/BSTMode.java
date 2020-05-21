package exercise;

import java.util.ArrayList;
import java.util.List;

import exercise.MaxPathSum.TreeNode;

public class BSTMode {
	static TreeNode prev;
	static int counter = 1;
	static int maxCount = 0;
    public static int[] findMode(TreeNode root) {
    	if(root == null) return new int[0];
    	List<Integer> list = new ArrayList<Integer>();
    	inorder(root, list);
    	int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
    	return arr;
    }
    
    public static void inorder(TreeNode root, List<Integer> list) {
    	if(root == null) return;
    	inorder(root.left, list);
    	
    	if(prev != null) {
    		if(prev.val == root.val) counter++;
    		else counter = 1;
    	}
    	
    	prev = new TreeNode(root.val);
    	if(counter > maxCount) {
    		maxCount = counter;
    		list.clear();
    		list.add(root.val);
    		
    	} else if(counter == maxCount) {
    		list.add(root.val);
    	}
    	
    	inorder(root.right, list);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
