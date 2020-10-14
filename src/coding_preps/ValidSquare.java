package coding_preps;

/** LeetCode #593 **/
public class ValidSquare {
	public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		double[] sides = new double[] {side(p1,p2), side(p1,p3), side(p1,p4),
				                 side(p2,p3), side(p2,p4), side(p3,p4)};
		
		double max = Double.MIN_VALUE, min = Double.MAX_VALUE;
		int count = 0;

		for(double side : sides) {
			max = Math.max(side,max);
			min = Math.min(min, side);
		}
		for(double side : sides) {
			if(side != max && side != min) {
				return false;
			}
			if(side == max) {
				count++;
			}
		}
		
		return count == 2;
	}
	
	public static double side(int[]a, int[]b) {
		double side = Math.pow(a[0]-b[0], 2) + Math.pow(a[1]-b[1], 2);
		return side;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
