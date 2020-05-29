package exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

public class ArrayKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
    	if(nums == null || nums.length == 0 || k == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	q.offer(entry);
        	if(q.size() > k) {
        		q.poll();
        	}
        }
        
        List<Integer> result = new ArrayList<>();
        while(q.size() > 0) {
        	result.add(q.poll().getKey());
        }
        
        Collections.reverse(result);
        int[] rst = result.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray();
        return rst;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
