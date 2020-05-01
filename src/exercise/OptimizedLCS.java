package exercise;

//Time complexity: O(mn) where m=length of text1 and n=length of text2
//Space complexity: O(mn) where m=length of text1 and n=length of text2
public class OptimizedLCS {
	private static class Entry{
		char val;
		int longest;
		int row;
		int column;
		
		Entry(char val, int longest, int row, int column){
			this.val = val;
			this.longest = longest;
			this.row = row;
			this.column = column;
		}
	}
	
	public static String optimizedLCS(String text1, String text2) {
		char[] array1 = text1.toCharArray();
		char[] array2 = text2.toCharArray();
		
		Entry[][] lcs = new Entry[array1.length+1][array2.length+1];
		for (int i = 0; i < array1.length+1; i++) {
			for(int j = 0; j < array2.length+1; j++) {
				lcs[i][j] = new Entry('\0', 0, 0, 0);
			}
			
		}
		
		for(int i = 1; i <= array1.length; i++) {
			for(int j = 1; j <= array2.length; j++) {
				if(array1[i-1] == array2[j-1]) {
					lcs[i][j].val = array1[i-1];
					lcs[i][j].longest = lcs[i-1][j-1].longest + 1;
					lcs[i][j].row = i-1;
					lcs[i][j].column = j-1;
				} else {
					if(lcs[i-1][j].longest > lcs[i][j-1].longest) {
						lcs[i][j].longest = lcs[i-1][j].longest;
						lcs[i][j].row = i-1;
						lcs[i][j].column = j;
					} else {
						lcs[i][j].longest = lcs[i][j-1].longest;
						lcs[i][j].row = i;
						lcs[i][j].column = j-1;
					}
				}
			}
		}
		
		return backtrackLCS(lcs);
	}
	
	public static String backtrackLCS(Entry[][] lcs) {
		int index = lcs[lcs.length-1][lcs[0].length-1].longest;
		char[] sequence = new char[index];
		int i = lcs.length-1;
		int j = lcs[0].length-1;
		
		while(i > 0 && j > 0) {
			Entry currentEntry = lcs[i][j];
			if(currentEntry.val != '\0') {
				sequence[index-1] = currentEntry.val;
				index--;
			}
			i = currentEntry.row;
			j = currentEntry.column;
		}
		
		return String.valueOf(sequence);
	}

	public static void main(String[] args) {
		String array1 = "AGGTAB";
		String array2 = "GXTXAYB";
		System.out.println(optimizedLCS(array1, array2));
	}

}
