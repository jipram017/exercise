package exercises;

public class PrefixTree {
	
	/** Definition of TrieNode. */
	public static class TrieNode {
		TrieNode[] arr;
		boolean isLeaf;
		TrieNode() {
			arr = new TrieNode[26];
		}
	}
	
	public static TrieNode root;
	
    /** Initialize your data structure here. */
    public PrefixTree() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode p = root;
        for(int i=0; i < word.length(); i++) {
        	int ch = word.charAt(i) - 'a';
        	if(p.arr[ch] == null) {
        		TrieNode temp = new TrieNode();
        		p.arr[ch] = temp;
        		p = temp;
        	}
        	else {
        		p = p.arr[ch];
        	}
        }
        p.isLeaf = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode p = searchNode(word);
    	if (p==null) return false;
    	if (!p.isLeaf) return false;
    	return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       	TrieNode p = searchNode(prefix);
    	if (p==null) return false;
    	return true;
    }
    
    /** General method to find a node in the trie. */
    public TrieNode searchNode(String word) {
       	TrieNode p = root;
        for(int i=0; i < word.length(); i++) {
        	int ch = word.charAt(i) - 'a';
        	if(p.arr[ch] != null) {
        		p = p.arr[ch];
        	}
        	else {
        		return null;
        	}
        }
        if(p == root) return null;
        return p;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
