package exercise;

public class LCS {

	public static int LCS(String text1, String text2) {
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
		
		return LCS[array1.length][array2.length];
	}
	public static void main(String[] args) {
		String array1 = "AGGTAB";
		String array2 = "GXTXAYB";
		
		System.out.println(LCS(array1,array2));
	}

}
