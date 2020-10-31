package coding_preps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** LeetCode #126 **/
public class WordLadderII {
	static class Node{
		String word;
		Node prev;
		int numSteps;
		public Node(String word, int step, Node prev) {
			this.word = word;
			this.numSteps = step;
			this.prev = prev;
		}
	}
	
	public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>();
		dict.addAll(wordList);
		
		List<List<String>> paths = new ArrayList<List<String>>();
		if (!dict.contains(endWord)) return paths; 

		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(new Node(beginWord, 1, null));

		HashSet<String> visited = new HashSet<>();
		HashSet<String> unvisited = new HashSet<>();
		unvisited.addAll(dict);
		
		int preDist = 0;
		while (!queue.isEmpty()) {
			Node trav = queue.remove();
		    String word = trav.word;
		    int currDist = trav.numSteps;

		    if (word.equals(endWord)) { 
		    	ArrayList<String> list = new ArrayList<>();
		    	list.add(trav.word);
		        while (trav.prev != null) {
		        	list.add(0, trav.prev.word);
		            trav = trav.prev;
		        }
		        paths.add(list);
		        continue;
		    }

		    if (preDist < currDist) { // means we have reached here with the min dist thus there is no point in processsing these words again
		    	unvisited.removeAll(visited);
		    }
		    preDist = currDist;

		    // new word forming logic
		    char[] arr = word.toCharArray();
		    for (int i = 0; i < arr.length; i++) {
		    	for (char c = 'a'; c <= 'z'; c++) {
		    		char temp = arr[i];
		    		if (arr[i] != c) {
		    			arr[i] = c;
		            }
		            String formed = new String(arr);
		            if (unvisited.contains(formed)) {
		            	queue.add(new Node(formed, trav.numSteps + 1, trav));
		            	visited.add(formed);
		            }
		            arr[i] = temp;
		        }
		    }
		}
		
		return paths;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
