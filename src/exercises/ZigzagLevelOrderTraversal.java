package exercises;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import helper.DataStructure.TreeNode;

public class ZigzagLevelOrderTraversal {
	
	// Time complexity O(N), space complexity O(N) where N is the number of nodes
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        boolean zigzag = false;
        
        while(!q.isEmpty()) {
        	List<Integer> level = new ArrayList<Integer>();
        	int size = q.size();
        	
        	for(int i=0; i<size; i++) {
        		TreeNode node = q.poll();
        		if(zigzag) {
        			level.add(0, node.val);
        		} else {
        			level.add(node.val);
        		}
        		
        		if(node.left != null) {
        			q.add(node.left);
        		}
        		if(node.right != null) {
        			q.add(node.right);
        		}
        	}
        	
        	zigzag = !zigzag;
        	result.add(level);
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
