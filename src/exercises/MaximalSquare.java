package exercises;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int maxSquare = 0;
        
        for(int i = 0; i < matrix.length; i++) {
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] == '1') {
        			if(j == 0 || i == 0) {
        				dp[i][j] = 1;
        			} else {
            			dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
        			}
        			maxSquare = Math.max(maxSquare, dp[i][j]);
        		}		
        	}
        }
        
        return maxSquare*maxSquare;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
