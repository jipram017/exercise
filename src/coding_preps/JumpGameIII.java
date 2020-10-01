package coding_preps;

/** LeetCode 1306 **/
public class JumpGameIII {
	public static boolean canReach(int[] array, int start) {
		if(array==null||array.length==0||start<0||start>=array.length) {
			return false;
		}
		return canReach(array, start, new boolean[array.length]);
	}
	
	public static boolean canReach(int[] array, int start, boolean[] visited) {
		if(start<0 || start>=array.length) return false; 
		if(visited[start]) return false;
		if(array[start] == 0) return true;
		
		visited[start] = true;
		return canReach(array, start+array[start], visited) || canReach(array, start-array[start], visited);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {3,0,2,1,2};
		int start = 2;
		System.out.println(canReach(arr, start));
	}

}
