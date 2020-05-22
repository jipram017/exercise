package exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

//Time complexity O(1)
class RandomizedCollection {
	Map<Integer, HashSet<Integer>> valueMap = null;
	Map<Integer, Integer> indexMap = null;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
    	valueMap = new HashMap<>();
    	indexMap = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int lastIndex = indexMap.size();
        indexMap.put(lastIndex+1, val);
        
        if(valueMap.containsKey(val)) {
        	HashSet<Integer> set = valueMap.get(val);
        	set.add(lastIndex+1);
        	return false;
        } else {
        	HashSet<Integer> set = new HashSet<>();
        	set.add(lastIndex+1);
        	valueMap.put(val, set);
        	return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!valueMap.containsKey(val)) {
        	return false;
        }
        HashSet<Integer> set = valueMap.get(val);
        int index = set.iterator().next();
        set.remove(index);
        if(set.size() == 0) {
        	valueMap.remove(val);
        }
        
        int lastIndex = indexMap.size();
        if(index == lastIndex) {
        	indexMap.remove(index);
        	return true;
        }
        
        int value = indexMap.get(lastIndex);
        valueMap.get(value).remove(lastIndex);
        valueMap.get(value).add(index);
        indexMap.remove(lastIndex);
        indexMap.remove(index);
        indexMap.put(index, value);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(valueMap.size() == 0) {
        	return -1;
        }
        if(valueMap.size() == 1) {
        	return indexMap.get(1);
        }
        
        Random r = new Random();
        int newIndex = r.nextInt(indexMap.size()) + 1;
        return indexMap.get(newIndex);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
