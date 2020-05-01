package exercise;

public class LCS {
	public static int[][] LCS(String text1, String text2) {
		char[] array1 = text1.toCharArray();
		char[] array2 = text2.toCharArray();
		
		int[][] LCS = new int[array1.length+1][array2.length+1];
		for(int i = 0; i <= array1.length; i++) {
			for(int j=0; j <= array2.length; j++) {
				if(i==0 || j==0) {
					LCS[i][j] = 0;
				}
				else if(array1[i-1] == array2[j-1]) {
					LCS[i][j] = 1 + LCS[i-1][j-1];
				} else {
					LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
				}
			}
		}
		
		return LCS;
	}
	
	public static char[] lcs_string(String text1, String text2){
		char[] array1 = text1.toCharArray();
		char[] array2 = text2.toCharArray();
		
		int[][] lcs = LCS(text1, text2);
		int index = lcs[array1.length][array2.length];
		char[] lcs_string = new char[index+1];
		lcs_string[index] = '\0';
		
		int i = array1.length, j = array2.length;
		
		while(i > 0 && j > 0) {
			if(array1[i-1] == array2[j-1]) {
				lcs_string[index-1] = array1[i-1];
				i--; j--; index--;
			}
			else {
				if(lcs[i-1][j] >= lcs[i][j-1]) {
					i--;
				} else {
					j--;
				}
			}
		}
		
		return lcs_string;
	}
	public static void main(String[] args) {
		String array1 = "AGGTAB";
		String array2 = "GXTXAYB";
		//String[][] result = LCS(array1, array2);
		//System.out.println(LCS(array1,array2));
		
		System.out.println(lcs_string(array1,array2));
	}

}
