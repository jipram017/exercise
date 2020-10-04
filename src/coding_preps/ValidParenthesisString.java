package coding_preps;

/** LeetCode #678 **/
public class ValidParenthesisString {
	
	// Time complexity O(N)
	// Space complexity O(1)
	// where N is input length
	public static boolean checkValidString(String s) {
		if(s.isEmpty()) return true;
		
		int hi = 0, lo = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) != ')') {
				hi++;
			} else {
				hi--;
			}
			
			if(s.charAt(i) == '(') {
				lo++;
			} else {
				lo--;
			}
			
			if(hi < 0) return false;
			lo = Math.max(0,  lo);
		}
		
		return lo==0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t = "(*))";
		System.out.println(checkValidString(t));
	}

}
