package coding_preps;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	HashMap<Integer, Integer> values;
	HashMap<Integer, Integer> counts;
	HashMap<Integer, LinkedHashSet<Integer>> frequencies;
	int capacity;
	int minimum;
	
	public LFUCache(int capacity) {
		this.capacity = capacity;
		this.minimum = 0;
		this.values = new HashMap<Integer, Integer>();
		this.counts = new HashMap<Integer, Integer>();
		this.frequencies = new HashMap<Integer, LinkedHashSet<Integer>>();
		frequencies.put(1, new LinkedHashSet<Integer>());
	}
	
	// O(1) time
	public int get(int key) {
		if(!values.containsKey(key)) return -1;
		int count = counts.get(key);
		counts.put(key, count+1);
		
		// This will result in O(n) time -> should make it to O(1) time
		frequencies.get(count).remove(key);
		
		if(frequencies.get(count).size()==0 && count==minimum) {
			frequencies.remove(count);
			minimum++;
		}
		
		frequencies.computeIfAbsent(count+1, k -> new LinkedHashSet<>()).add(key);
		return values.get(key);
	}
	
	
	// O(1) time
	public void put(int key, int value) {
		if(capacity <= 0) return;
		if(values.containsKey(key)) {
			values.put(key, value);
			get(key);
			return;
		}
		
		if(values.size() >= capacity) {
			Integer evit = frequencies.get(minimum).iterator().next();
			frequencies.get(minimum).remove(evit);
			counts.remove(evit);
			values.remove(evit);
		}
		
		counts.put(key, 1);
		values.put(key, value);
		frequencies.get(1).add(key);
		minimum = 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
