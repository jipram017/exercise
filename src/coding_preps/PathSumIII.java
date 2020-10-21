package coding_preps;

import java.util.ArrayList;
import java.util.List;

import helper.DataStructure.TreeNode;

/** LeetCode #113 **/
public class PathSumIII {
	// Time complexity O(N)
	// Space complexity O(NlogN)
	// where N is the number of nodes
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {   
		if(root==null) return new ArrayList<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(root.val);
		return pathSumHelper(root, sum-root.val, list, result);
	}
	
	public static List<List<Integer>> pathSumHelper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) { 
		if(root.left==null && root.right==null && sum == 0) {
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
