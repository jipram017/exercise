package coding_preps;

public class BulbSwitcher {
	/** LeetCode #319 **/
	// O(1) time, O(1) space
	public static int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}
	
	/** LeetCode #1375 **/
	// O(N) time, O(1) space
    public static int numTimesAllBlue(int[] light) {
        int max = -1;
        int moment = 0;
        for(int i=0; i<light.length; i++) {
        	max = Math.max(max, light[i]);
        	if(i+1 == max) {
        		moment++;
        	}
        }
        return moment;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
