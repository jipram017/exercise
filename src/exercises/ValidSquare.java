package exercises;

public class ValidSquare {
	// Time complexity O(1), space complexity O(1)
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        long[] sides = new long[] {side(p1,p2), side(p1,p3), side(p1,p4), side(p2,p3), side(p3,p4), side(p2,p4)};
        long max  = 0, count = 0, noMax = 0;
        for(long side : sides) {
        	max = Math.max(max, side);
        }
        for(long side : sides) {
        	if(side == max) {
        		count++;
        	} else {
        		noMax = side;
        	}
        }
        
        if(count != 2) return false;
        for(long side : sides) {
        	if(side != max && side != noMax) return false;
        }
        return true;
    }
    
    public static long side(int[] point1, int[] point2) {
    	double sum = Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1],2);
    	return (long) sum;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
