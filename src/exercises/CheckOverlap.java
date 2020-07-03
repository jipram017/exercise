package exercises;

public class CheckOverlap {
    public static boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int dx=0, dy=0;
        if((x1-x_center) * (x2-x_center) > 0) {
        	dx = Math.min(Math.abs(x1-x_center), Math.abs(x2-x_center));
        }
        if((y1-y_center) * (y2-y_center) > 0) {
        	dy = Math.min(Math.abs(y1-y_center), Math.abs(y2-y_center));
        }
        
        return dx*dx + dy*dy <= radius*radius;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
