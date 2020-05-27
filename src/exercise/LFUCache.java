package exercise;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	HashMap<Integer, Integer> vals;
	HashMap<Integer, Integer> counts;
	HashMap<Integer, LinkedHashSet<Integer>> freq;
	int capacity;
	int min;
	
    public LFUCache(int capacity) {
    	this.capacity = capacity;
    	this.min = 0;
        this.vals = new HashMap<>();
        this.counts = new HashMap<>();
        this.freq = new HashMap<>();
        freq.put(1, new LinkedHashSet<Integer>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)) {
        	return -1;
        }
        int count = counts.get(key);
        counts.put(key, count+1);
        freq.get(count).remove(key);
        
        if(min == count && freq.get(count).size() == 0) {
        	min++;
        }
        if(!freq.containsKey(count+1)) {
        	freq.put(count+1, new LinkedHashSet<Integer>());
        }
        
        freq.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity <= 0) return;
        if(vals.containsKey(key)) {
        	vals.put(key, value);
        	get(key);
        	return;
        }
        if(vals.size() >= capacity) {
        	Integer evit = freq.get(min).iterator().next();
        	freq.get(min).remove(evit);
        	counts.remove(evit);
        	vals.remove(evit);
        }
        
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        freq.get(1).add(key);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
