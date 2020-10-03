package coding_preps;

/** LeetCode #154 **/
public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int availableGas = 0;
		int start = 0;
		int total = 0;
		
		for(int i=0;i<gas.length;i++) {
			int remaining = gas[i]-cost[i];
			if(availableGas >= 0) {
				availableGas += remaining;
			} else {
				start = i;
				availableGas = remaining;
			}
			total += remaining;
		}
		
		if(total >= 0) return start;
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
