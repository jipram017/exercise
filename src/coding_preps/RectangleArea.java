package coding_preps;

/** LeetCode #223 **/
public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		// Check if there is overlap between two rectangles
		if(E>C || A>G || F>D || B>H) {
			// no overlap, return total area of two rectangles
			return (C-A)*(D-B) + (G-E)*(H-F);
		}
		
		// There is some overlap
		int left = Math.max(E, A);
		int right = Math.min(G, C);
		int top = Math.min(D, H);
		int bottom = Math.max(B, F);
		
		return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(top-bottom);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
