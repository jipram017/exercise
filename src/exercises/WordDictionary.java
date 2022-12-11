package exercises;

public class WordDictionary {
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
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;
        for(int i=0; i < word.length(); i++) {
        	int ch = word.charAt(i)-'a';
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfsSearch(root, word, 0);
    }
    
    /** Helper method for search */
    public boolean dfsSearch(TrieNode p, String word, int start) {
    	if(p.isLeaf && start ==  word.length()) {
    		return true;
    	}
    	if(start >= word.length()) {
    		return false;
    	}
    	char ch = word.charAt(start);
    	if(ch == '.') {
    		boolean tResult = false;
    		for(int i = 0; i < 26; i++) {
    			if(p.arr[i] != null) {
    				if(dfsSearch(p.arr[i], word, start+1)) {
    					tResult = true;
    					break;
    				}
    			}
    		}
    		if (tResult) return true;
    	}
    	else {
    		int index = ch-'a';
    		if(p.arr[index] != null) {
    			return dfsSearch(p.arr[index], word, start+1);
    		}
    		else {
    			return false;
    		}
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
