package exercises;

public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0) return "";
        if(numRows == 1) return s;
        
        int step1 = 2*(numRows-1);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<numRows; i++) {
        	if(i==0 || i==numRows-1) {
        		for(int j=i; j<s.length(); j = j + step1) {
        			sb.append(s.charAt(j));
        		}
        	}
        	
        	else {
        		boolean flag = true;
        		int step2 = 2*(numRows-1-i);
        		int step3 = step1-step2;
        		int k = i;
        			
        		while(k<s.length()) {
        			sb.append(s.charAt(k));
        			if(flag) {k = k+step2;}
        			else {k = k+step3;}
        			flag = !flag;
        		}
        	}
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
