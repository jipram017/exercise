package exercise;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int maxWidth) {
    	if(words == null || words.length == 0 || maxWidth == 0) return null;
        int charCount = 0;
        int leftOver = 0;
        ArrayList<String> result = new ArrayList<String>();
        
        for(int i = 0; i < words.length; i++) {
        	charCount = charCount + words[i].length();
        	if(charCount + i - leftOver > maxWidth) {
        		charCount = charCount - words[i].length();
        		int spaces = maxWidth - charCount;
        		int spacesBetween = 1;
        		int extraSpaces = 0;
        		
        		if(i-leftOver-1 > 0) {
        			spacesBetween = spaces/(i-leftOver-1);
        		    extraSpaces = spaces%(i-leftOver-1);
        		}
        		
        		StringBuilder sb = new StringBuilder();
        		for(int j = leftOver; j < i-1; j++) {
        			sb.append(words[j]);
        			int counter = 0;
        			while(counter < spacesBetween) {
        				sb.append(" ");
        				counter++;
        			}
        			if(extraSpaces > 0) {
        				sb.append(" ");
        				extraSpaces--;
        			}
        		}
        		
        		// If leftOver is one index less than i, above for loop will not be executed
				sb.append(words[i-1]); 
				while(sb.length() < maxWidth) {
					sb.append(" "); 
				}
	
        		result.add(sb.toString());
        		leftOver = i;
        		charCount = words[i].length();
        	} 
        }
        
        StringBuilder sb = new StringBuilder();
        for(int k = leftOver; k < words.length-1; k++) {
        	sb.append(words[k] + " ");
        }
        
        sb.append(words[words.length-1]);
        while(sb.length() < maxWidth) {
        	sb.append(" ");
        }
        
        result.add(sb.toString());
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
