package coding_preps;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/** LeetCode #726 **/
public class NumberOfAtoms {
	// Time complexity O(N)
	// Space complexity O(N)
    public static String countOfAtoms(String formula) {
        if(formula==null || formula.length()==0) return "";
        LinkedList<String> atoms = new LinkedList<String>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
        LinkedList<Integer> frontBrackets = new LinkedList<Integer>();
        
        for(int i=0; i<formula.length(); i++) {
        	if(formula.charAt(i)=='(') {
        		frontBrackets.add(atoms.size());
        	}
        	else if(formula.charAt(i)==')') {
        		int num = 0;
        		while(i+1 <= formula.length()-1 && formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9') {
        			num = num*10 + formula.charAt(i+1) - '0';
        			i++;
        		}
        		if(num == 0) num = 1;
        		int idx = frontBrackets.removeLast();
        		for(int j = idx; j<counts.size(); j++) {
        			counts.set(j, num*counts.get(j));
        		}
        	}
        	else if(formula.charAt(i) >= 'A' && formula.charAt(i) <= 'Z'){
        		int t = i;
        		while(t+1 <= formula.length()-1 && formula.charAt(t+1) >= 'a' && formula.charAt(i+1) <= 'z') {
        			t++;
        		}
        		String name = formula.substring(i, t+1);
        		atoms.add(name);
        		i = t;
        		int count = 0;
        		while(i+1 <= formula.length()-1 && formula.charAt(i+1) >= '0' && formula.charAt(i+1) <= '9') {
        			count = count*10 + formula.charAt(i+1) - '0';
        			i++;
        		}
        		if(count == 0) count = 1;
        		counts.add(count);
        	}
        }
        
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for(int k=0; k<atoms.size(); k++) {
        	map.put(atoms.get(k), map.getOrDefault(atoms.get(k), 0) + counts.get(k));
        }
        
        StringBuilder sb = new StringBuilder();
        for(String str : map.keySet()) {
        	sb.append(str);
        	int atomCount = map.get(str);
        	sb.append(atomCount != 1? atomCount : "");
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
