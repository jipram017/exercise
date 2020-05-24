package exercise;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordLadderI {
	class WordNode {
		String word;
		int numSteps;
		WordNode(String word, int numSteps){
			this.word = word;
			this.numSteps = numSteps;
		}
	}
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        LinkedList<WordNode> q = new LinkedList<WordNode>();
        q.add(new WordNode(beginWord, 1));
        
        while(!q.isEmpty()) {
        	WordNode top = q.remove();
            String word = top.word;
        	if(word.equals(endWord)) {
        		return top.numSteps;
        	}
        	
        	char[] wordChars = top.word.toCharArray();
        	for(int i = 0; i < wordChars.length; i++) {
        		for(char c = 'a'; c <= 'z'; c++) {
        			char temp = wordChars[i];
        			if(wordChars[i] != c) {
        				wordChars[i] = c;
        			}
        			
        			String newWord = new String(wordChars);
        			if(wordSet.contains(newWord)) {
        				q.add(new WordNode(newWord, top.numSteps+1));
        				wordSet.remove(newWord);
        			}
        			wordChars[i] = temp;
        		}
        	}
        }
        
        return 0;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
