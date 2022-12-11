package coding_preps;

import helper.DataStructure;

import java.util.Stack;

/** LeetCode #173 **/
public class BSTIterator {
	static Stack<DataStructure.TreeNode> s = new Stack<DataStructure.TreeNode>();
	public BSTIterator(DataStructure.TreeNode root) {
		while(root != null) {
			s.push(root);
			root = root.left;
		}
	}
	
	public static boolean hasNext() {
		return !s.isEmpty();
	}
	
	public static int next() {
		DataStructure.TreeNode node = s.pop();
		int value = node.val;
		if(node.right != null) {
			node = node.right;
			while(node != null) {
				s.push(node);
				node = node.left;
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
