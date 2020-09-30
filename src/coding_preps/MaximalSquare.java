package coding_preps;

/** LeetCode #221 **/
public class MaximalSquare {
	// Time complexity O(N) where N is the number of 0 or 1
	// Space complexity O(N) where N is the number of 0 or 1
    public static int maximalSquare(char[][] matrix) {
    	if(matrix.length == 0) return 0;
    	int maxSquare = Integer.MIN_VALUE;
    	int[][] square = new int[matrix.length][matrix[0].length];
    	for(int i=0; i<matrix.length; i++) {
    		for(int j=0; j<matrix[0].length; j++) {
    			if(i==0 || j==0) {
    				square[i][j] = Integer.parseInt(String.valueOf(matrix[i][j]));
    			}
    			else {
    				if(matrix[i][j] == '1') {
    					square[i][j] = 1+Math.min(square[i][j-1], Math.min(square[i-1][j], square[i-1][j-1]));
    				}
    				else {
    					square[i][j] = 0;
    				}
    			}
    			maxSquare = Math.max(maxSquare, square[i][j]);
    		}
    	}
    	
    	return maxSquare*maxSquare;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] square = new char[][] {
			{'1', '0', '1', '0', '0'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'1', '0', '0', '1', '0'},
		};
		
		System.out.println(maximalSquare(square));
	}

}
