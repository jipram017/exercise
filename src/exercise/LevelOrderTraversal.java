package exercise;

import java.util.ArrayList;
import java.util.List;

import exercise.FlattenBinaryTree.TreeNode;

public class LevelOrderTraversal {
    List<List<Integer>> levelNodes = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverseTree(0, root);
        return levelNodes;
    }
    public void traverseTree(int level, TreeNode root){
    	if(root == null) return;
        if(level == levelNodes.size()) {
        	levelNodes.add(new ArrayList<>());
        }
        levelNodes.get(level).add(root.val);
        traverseTree(level+1, root.left);
        traverseTree(level+1, root.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
