package exercises;

import java.util.HashMap;

public class DecimalFraction {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0) return "0";
        if(denominator==0) return "";
        String result = "";
        if((numerator<0) ^ (denominator<0)) {
        	result = "-" + result;
        }
        
        long num = numerator, den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        long res = num / den;
        result += String.valueOf(res);
        
        long rem = (num%den)*10;
        if(rem==0) return result;
        
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        result += ".";
        while(rem != 0) {
        	if(map.containsKey(rem)) {
        		int beg = map.get(rem);
        		String part1 = result.substring(0, beg);
        		String part2 = result.substring(beg, result.length());
        		result = part1 + "(" + part2 + ")";
        		return result;
        	}
        	map.put(rem,  result.length());
        	res = rem / den;
        	result += String.valueOf(res);
        	rem = (rem%den)*10;
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
