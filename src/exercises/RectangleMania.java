package exercises;

import java.util.HashSet;
import java.util.Set;

// Time: O(n^2), Space: O(1)
public class RectangleMania {
	public static int countRectangle(int[][] coordinates) {
		if(coordinates == null || coordinates.length == 0) return 0;
		Set<String> coordSets = new HashSet<>();
		int rectangleCount = 0;
		for(int[] coord : coordinates) {
			String coordString = Integer.toString(coord[0]) + "-" + Integer.toString(coord[1]);
			coordSets.add(coordString);
		}
		
		for(int[] coord : coordinates) {
			for(int[] coord2 : coordinates) {
				if(coord2[0] <= coord[0] || coord2[1] <= coord[1]) {
					continue;
				}		
				String upperLeft = Integer.toString(coord[0]) + "-" + Integer.toString(coord2[1]);
				String bottomRight = Integer.toString(coord2[0]) + "-" + Integer.toString(coord[1]);
				if(coordSets.contains(upperLeft) && coordSets.contains(bottomRight)) {
					rectangleCount += 1;
				}
			}
		}
		return rectangleCount;
	}
	public static void main(String[] args) {
		int[][] coordinates = new int[][] {{0,0},{1,0},{2,0},{0,1},{1,1},{2,1},{0,2},{1,2}};
		int count = countRectangle(coordinates);
		System.out.println(count);
	}

}
