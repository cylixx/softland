/*
	994. Rotting Oranges
	https://leetcode.com/problems/rotting-oranges/submissions/
	
	You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

Input: grid = [[2,1,1],
			   [1,1,0],
			   [0,1,1]]
Output: 4

*/
package com.softland.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class PA105_RottingOranges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { {2,1,1}, {1,1,0}, {0,1,1} };
		int result = orangesRotting(grid);

		System.out.println("Output:" + result);
	}
	
	public static int orangesRotting(int[][] grid) {
	     
        Set<String> fresh = new HashSet<String>();
        Set<String> rotten = new HashSet<String>();
        
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
//                if (grid[i][j] == 1) fresh.add(String.valueOf(i) + String.valueOf(j));
//                else if (grid[i][j] == 2) rotten.add(String.valueOf(i) + String.valueOf(j));
            	if (grid[i][j] == 1) fresh.add("" + i + j);  // convert to cadena:  "" + i + j
                else if (grid[i][j] == 2) rotten.add("" + i + j);
            }
        }
        
        int[][] adj = {{1,0}, {-1, 0}, {0, -1}, {0, 1} };
        int minutes = 0;
        while(!fresh.isEmpty()) {
            Set<String> infected = new HashSet<String>();
            for (String r: rotten){
                int i = r.charAt(0) - '0';  //convert to int: r.charAt(0) - '0'
                int j = r.charAt(1) - '0';
                for(int[] d: adj) {
                    int nextI = i + d[0];
                    int nextJ = j + d[1];
                    if (fresh.contains("" + nextI + nextJ)) {
                        fresh.remove("" + nextI + nextJ);
                        infected.add("" + nextI +nextJ);
                    }
                }
            }
            
            if (infected.isEmpty()) return -1;
            
            rotten = infected;
            minutes++;
        }
        return minutes;
    }

}
