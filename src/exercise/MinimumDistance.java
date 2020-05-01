package exercise;

public class MinimumDistance {
	
	public static int minDistance(String word1, String word2) {
		char[] array1 = word1.toCharArray();
		char[] array2 = word2.toCharArray();
		
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
		
		return (word1.length()+word2.length())- 2*LCS[array1.length][array2.length];
	}

	public static void main(String[] args) {
		String array1 = "AGGTAB";
		String array2 = "GXTXAYB";
		System.out.println(minDistance(array1, array2));
	}

}

