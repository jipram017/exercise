package exercise;

import java.util.ArrayList;
import java.util.List;

import exercise.FlattenBinaryTree.TreeNode;

public class PathSumII {
	
	/** Find all root-to-leaf paths in a binary tree which values summed up to a sum **/
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {    	
		if(root == null) return new ArrayList<List<Integer>>();
	    ArrayList<Integer> list = new ArrayList<Integer>();
	    list.add(root.val);
	    ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
	    return pathSumHelper(root, sum-root.val, list, result);
	}
	    
	public static List<List<Integer>> pathSumHelper(TreeNode root, int sum, ArrayList<Integer> list, ArrayList<List<Integer>> result){
	    if(sum == 0 && root.left == null && root.right == null) {
	    	ArrayList<Integer> temp = new ArrayList<Integer>();
	    	temp.addAll(list);
	        result.add(temp);
	    	return result;
	    }
	    	
	    if(root.left != null) {
	    	list.add(root.left.val);
	    	pathSumHelper(root.left, sum-root.left.val, list, result);
	    	list.remove(list.size()-1);
	    }
	    	
	    if(root.right != null) {
	    	list.add(root.right.val);
	    	pathSumHelper(root.right, sum-root.right.val, list, result);
	    	list.remove(list.size()-1);
	    }
	    	
	    return result;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
