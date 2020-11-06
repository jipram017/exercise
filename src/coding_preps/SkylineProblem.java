package coding_preps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** LeetCode #218 **/
public class SkylineProblem {
	class TreeNode{
		private int start;
		private int end;
		private int height;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
    public List<List<Integer>> getSkyline(int[][] buildings) {
        if(buildings==null || buildings.length==0) return new ArrayList<>();
        
        Set<Integer> set = new HashSet<Integer>();
        for(int[] building : buildings) {
        	set.add(building[0]);
        	set.add(building[1]);
        }
        
        List<Integer> nodes = new ArrayList<Integer>(set);
        Collections.sort(nodes);
        
        int len = nodes.size();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<len; i++) {
        	map.put(nodes.get(i), i);
        }
        
        // Build a segment tree
        TreeNode tree = buildSegmentTree(0, len-1);
        
        // Update height
        for(int[] building : buildings) {
        	int start = map.get(building[0]);
        	int end = map.get(building[1]);
        	int height = building[2];
        	updateHeight(start, end, height, tree);
        }
        
        // Generate result
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        generateResult(result, nodes, tree);
        if(nodes.size() > 0) {
        	List<Integer> l = new ArrayList<Integer>();
        	l.add(nodes.get(nodes.size()-1));
        	l.add(0);
        	result.add(l);
        }
        
        return result;
    }
    
    private TreeNode buildSegmentTree(int start, int end) {
    	if(start >= end) return null;
    	TreeNode root = new TreeNode(start, end);
    	if(start+1 < end) {
    		int mid = start + (end-start)/2;
    		root.left = buildSegmentTree(start, mid);
    		root.right = buildSegmentTree(mid, end);
    	}
    	return root;
    }
    
    private void updateHeight(int start, int end, int height, TreeNode node) {
    	if(node==null || start >= node.end || end <= node.start || height < node.height) {
    		return;
    	}
    	if(node.left == null && node.right == null) {
    		node.height = height;
    	}
    	else {
    		updateHeight(start, end, height, node.left);
    		updateHeight(start, end, height, node.right);
    		int leftHeight = (node.left == null) ? 0 : node.left.height;
    		int rightHeight = (node.right == null) ? 0 : node.right.height;
    		node.height = Math.min(leftHeight, rightHeight);
    	}
    }
    
    public void generateResult(List<List<Integer>> result, List<Integer> nodes, TreeNode root) {
    	if(root==null) return;
    	if(root.left==null && root.right==null && (result.size()==0 || result.get(result.size()-1).get(1) != root.height)) {
    		List<Integer> l = new ArrayList<Integer>();
    		l.add(nodes.get(root.start));
    		l.add(root.height);
    		result.add(l);
    	}
    	else {
    		generateResult(result, nodes, root.left);
    		generateResult(result, nodes, root.right);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
