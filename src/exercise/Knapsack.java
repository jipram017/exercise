package exercise;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
	public static List<Integer> knapsackProblem(List<Integer[]> items, int capacity) {
		int[][] knapsackValues = new int[items.size()+1][capacity+1];
		for(int i = 1; i <= items.size(); i++) {
			for(int w = 0; w <= capacity; w++) {
				if(i == 0 || w == 0) {
					knapsackValues[i][w] = 0;
				}
				else {
					if(items.get(i-1)[1] > w) {
						knapsackValues[i][w] = knapsackValues[i-1][w];
					} else {
						knapsackValues[i][w] = Math.max(knapsackValues[i-1][w], items.get(i-1)[0] + knapsackValues[i-1][w-items.get(i-1)[1]]);
					}
				}
			}
		}
		
		List<Integer> indexes = new ArrayList<>();
		int j = items.size();
		int c = capacity;
		while(j > 0 && c > 0) {
			if(knapsackValues[j][c] == knapsackValues[j-1][c]) {
				j = j-1;
			} else {
				j = j-1;
			    c -= items.get(j)[1];
			    if(j == 0) break;
			    indexes.add(items.get(j)[0]);
			}
		}
		//return knapsackValues[items.size()][capacity];
		
		return indexes;
	}
	
	
	public static void main(String[] args) {
		    List<Integer[]> items = new ArrayList<Integer[]>();
		    items.add(new Integer[] {60,10});
		    items.add(new Integer[] {100,20});
		    items.add(new Integer[] {120,30});
		    int  W = 50; 
		    for(int n : knapsackProblem(items, W)) {
		    	 System.out.println(n);  
		    }  
	}

}
