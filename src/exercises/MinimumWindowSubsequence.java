package exercises;

public class MinimumWindowSubsequence {
	
	// Time complexity O(st) where s: length of string S and t length of string T
	// Space complexity O(1)
	public String minWindow(String S, String T) {
		int start=0;
		String result="";
		
		while(start < S.length()) {
			int j = 0;
			
			for(int i=start; i<T.length(); i++) {
				if(S.charAt(i) == T.charAt(j) && j==0) {
					start=i;
				}
				
				if(S.charAt(i) == T.charAt(j)) {
					j++;
				}
				
				if(j==T.length()) {
					if(result.length()==0 || (i-start+1)<result.length()) {
						result = S.substring(start, i+1);
					}
					start = start+1;
					break;
				}
				
				if(i==S.length()-1) {
					return result;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
