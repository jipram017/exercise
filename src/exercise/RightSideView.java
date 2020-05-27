package exercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exercise.BalancedBST.TreeNode;

public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
    	if(root == null ) return new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        q.add(root);
        
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i = 0; i < size; i++) {
        		TreeNode top = q.remove();
        		if(i == 0) {
        			result.add(top.val);
        		}
        		
        		if(top.right != null) {
        			q.add(top.right);
        		}
        		if(top.left != null) {
        			q.add(top.left);
        		}
        	}
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
