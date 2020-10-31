package coding_preps;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/** LeetCode #127 **/
public class WordLadder {
	static class Node{
		String word;
		int numSteps;
		public Node(String word, int step) {
			this.word = word;
			this.numSteps = step;
		}
	}
	
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(wordList.isEmpty() || beginWord.isEmpty() || endWord.isEmpty()) return 0;
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(beginWord, 1));
		
		Set<String> set = new HashSet<>();
		set.addAll(wordList);
		
		while(!q.isEmpty()) {
			Node top = q.poll();
			String word = top.word;
			if(word.equals(endWord)) {
				return top.numSteps;
			}
			
			char[] chars = word.toCharArray();
			for(int i=0; i<word.length(); i++) {
				for(char j='a'; j<='z'; j++) {
					char temp = chars[i];
					if(chars[i] == j) continue;
					chars[i] = j;
					String newWord = new String(chars);
					if(set.contains(newWord)) {
						q.offer(new Node(newWord, top.numSteps+1));
						set.remove(newWord);
					}
					chars[i] = temp;
				}
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
