package exercise;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import exercise.FlattenBinaryTree.TreeNode;

public class MaxLevelSumBST {
    public static int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 1; int max  = Integer.MIN_VALUE;
        Map<Integer, Integer> result = new HashMap<>();
        while(!q.isEmpty()) {
        	int size = q.size();
        	int currentSum = 0;
        	for(int i = 0; i < size; i++) {
        		TreeNode top = q.poll();
        		currentSum += top.val;
        		if(top.left != null) q.offer(top.left);
        	    if(top.right != null) q.offer(top.right);
        	}	
        	level += 1;
        	result.put(currentSum, level);
        }
        
        for(Integer sum : result.keySet()) {
        	max = Math.max(max, sum);
        }
        return result.get(max);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
