package exercises;

public class RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	if(G < A || C < E) {
    		return (C-A)*(D-B) + (G-E)*(H-F);
    	}
    	if(H < B || D < F) {
    		return (C-A)*(D-B) + (G-E)*(H-F); 
    	}
    	
    	int right = Math.min(C, G);
    	int left = Math.max(A, E);
    	int top = Math.min(D, H);
    	int bottom = Math.max(B, F);
    	
    	return (C-A)*(D-B) + (G-E)*(H-F) - (right-left)*(top-bottom);
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
