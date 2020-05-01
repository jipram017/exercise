package exercise;

import java.util.ArrayList;
import java.util.List;

public class RiverSize {
	public int numIslands(char[][] grid) {
		List<Integer> sizes = new ArrayList<Integer>();
		boolean visited[][] = new boolean[grid.length][grid[0].length];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(visited[i][j]) {
					continue;
				}
				sizes = traverseIsland(grid, visited, i, j, sizes);
			}
		}
		
		return sizes.size();
	}
	
	public static List<Integer> traverseIsland(char[][]grid, boolean[][]visited, int i, int j, List<Integer> sizes) {
		int currentSize = 0;
		List<Integer[]> nodesToExplore = new ArrayList<Integer[]>();
		nodesToExplore.add(new Integer[] {i,j});
		while(!nodesToExplore.isEmpty()) {
			Integer[] currentNode = nodesToExplore.get(nodesToExplore.size()-1);
			i = currentNode[0];
			j = currentNode[1];
			
			if(visited[i][j]) {
				continue;
			}
			
			visited[i][j] = true;
			if(grid[i][j] == '0') {
				continue;
			}
			currentSize++;
		    
			List<Integer[]>unvisitedNeighbors = getUnvisitedNeighbors(i,j,grid, visited);
			for (Integer[] neighbor : unvisitedNeighbors) {
				nodesToExplore.add(neighbor);
			}
			if(currentSize > 0) {
				sizes.add(currentSize);
			}
		}
		
		return sizes;
	}
	
	public static List<Integer[]> getUnvisitedNeighbors(int i, int j, char[][]grid, boolean[][] visited){
		List<Integer[]> unvisitedNeighbors = new ArrayList<Integer[]>();
		if(i > 0 && !visited[i-1][j]) {
			unvisitedNeighbors.add(new Integer[] {i-1,j});
		}
		if(i < grid.length && !visited[i+1][j]) {
			unvisitedNeighbors.add(new Integer[] {i+1,j});
		}
		if(j > 0 && !visited[i][j-1]) {
			unvisitedNeighbors.add(new Integer[] {i,j-1});
		}
		if(j < grid[0].length && !visited[i][j+1]) {
			unvisitedNeighbors.add(new Integer[] {i,j+1});
		}
		
		return unvisitedNeighbors;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
