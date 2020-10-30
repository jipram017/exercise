package coding_preps;

import java.util.ArrayList;
import java.util.List;

/** LeetCode #68 **/
public class TextJustification {
	// Time complexity O(N)
	// Space complexity O(N)
	// where N is size of input array
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> result = new ArrayList<String> ();
		if(words == null || words.length == 0) return result;
		int last = 0, count = 0;
		
		for(int i=0; i<words.length; i++) {
			count += words[i].length();
			if(count+i-last > maxWidth) {
				count = count - words[i].length();
				int spaceLen = maxWidth - count;
				int eachLen = 1;
				int extraLen = 0;
				if(i-last-1 > 0) {
					eachLen = spaceLen / (i-last-1);
					extraLen = spaceLen % (i-last-1);
				}
				
				StringBuilder sb = new StringBuilder();
				for(int j=last; j<i-1; j++) {
					sb.append(words[j]);
					int counter = 0;
					while(counter < eachLen) {
						sb.append(" ");
						counter++;
					}
					if(extraLen > 0) {
						sb.append(" ");
						extraLen--;
					}
				}
				
				sb.append(words[i-1]);
				while(sb.length() < maxWidth) {
					sb.append(" ");
				}
				
				result.add(sb.toString());
				last = i;
				count = words[i].length();
			}	
		}
		
		StringBuilder sb2 = new StringBuilder();
		for(int k=last; k<words.length-1; k++) {
			sb2.append(words[k] + " ");
		}
		
		sb2.append(words[words.length-1]);
		while(sb2.length() < maxWidth) {
			sb2.append(" ");
		}
		
		result.add(sb2.toString());
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
