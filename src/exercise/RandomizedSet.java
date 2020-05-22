package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	// We will use two hash maps 
	Map<Integer, Integer> valueMap = null;
	Map<Integer, Integer> indexMap = null;
	
    /** Initialize your data structure here. */
    public RandomizedSet() {
        valueMap = new HashMap<>();
        indexMap = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valueMap.containsKey(val)) {
        	return false;
        }
        valueMap.put(val, valueMap.size());
        indexMap.put(indexMap.size(), val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valueMap.containsKey(val)) {
        	return false;
        }
        Integer index = valueMap.get(val);
        valueMap.remove(val);
        indexMap.remove(index);
        
        Integer tailElement = indexMap.get(indexMap.size());
        if(tailElement != null) {
        	indexMap.put(index, tailElement);
        	valueMap.put(tailElement,  index);
        }
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        if(valueMap.size() == 0) {
        	return -1;
        }
        if(valueMap.size() == 1) {
        	return indexMap.get(0);
        }
        Random r = new Random();
        int index = r.nextInt(valueMap.size());
        return indexMap.get(index);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
