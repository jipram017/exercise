package exercises;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int availableGas = 0, neededGas = 0, start = 0;
    	for(int i=0; i < gas.length; i++) {
    		availableGas += gas[i] - cost[i];
    		if(availableGas < 0) {
    			start = i+1; availableGas = 0; neededGas += availableGas;
    		}
    	}
    	
    	if(availableGas + neededGas >= 0) {
    		return start;
    	}
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
