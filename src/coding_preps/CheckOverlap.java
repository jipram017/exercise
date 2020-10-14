package coding_preps;

public class CheckOverlap {
	/** LeetCode #1401 **/
	public static boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
		int dx=0, dy=0;
		if((x1-x_center)*(x2-x_center) > 0) {
			dx = Math.min(Math.abs(x1-x_center), Math.abs(x2-x_center));
		}
		if((y1-y_center)*(y2-y_center) > 0) {
			dy = Math.min(Math.abs(y1-y_center), Math.abs(y2-y_center));
		}
		
		return dx*dx + dy*dy <= radius*radius;
	}
	
	/** LeetCode #836 **/
    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0]==rec1[2] || rec1[1]==rec1[3] || rec2[0] == rec2[2] || rec2[1]==rec2[3]){
            return false;
        }
        if(rec2[0] >= rec1[2] || rec1[0] >= rec2[2]
           || rec2[1] >= rec1[3] || rec1[1] >= rec2[3]) {
        	return false;
        }
        return true; 
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
