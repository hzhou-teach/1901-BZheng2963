/*
Bill Zheng
Time: 25 min
USACO Test Cases: *********** 11/11
1-10 Difficulty: 4 for recursive floodfill
Reflection: Since we did a problem just like this last week (mooyomooyo) it was a lot easier. This problem is easier than mooyomooyo
	in my opinion. I just needed to balance more variables which wasn't hard. I want to see where I can optimize my code to make it
	quicker or less clunky/messy. Also, I need to practice canonical form for backtracking cause I think recursion is pretty easy already.
 */

import java.io.*;
import java.util.*;

public class perimeter_1901_silver {
	static int N;
	static char[][] grid;
	static boolean[][] visited;
	static int final_area, final_perim;
	static int area, perim;
//--------------------------------------------------------------------------------------------------------------------------
	static void floodFillUtil(char[][] grid, int x, int y, char c) {
		if (x<0 || x>=N || y<0 || y>=N) {
			perim++;
			return;
		}
		if (grid[x][y] != c) {
			perim++;
			return;
		}
		if (visited[x][y]) {
			if (grid[x][y] == '.') perim++; //this is important because we don't want to repeat cases
			return;
		}
		
		area++;
		visited[x][y] = true;
		
		floodFillUtil(grid, x+1, y, c);
		floodFillUtil(grid, x-1, y, c);
		floodFillUtil(grid, x, y+1, c);
		floodFillUtil(grid, x, y-1, c);
	}
	
	static void floodFill(char[][] grid, int x, int y, char c) {
		area = 0;
		perim = 0;
		floodFillUtil(grid, x, y, c);
		if (area >= final_area) {
			final_area = area;
			final_perim = perim;
		}
	}
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("perimeter.in"));
//--------------------------------------------------------------------------------------------------------------------------
		N = scan.nextInt();
		grid = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String input = scan.next();
			for (int j = 0; j < N; j++) {
				grid[i][j] = input.charAt(j);
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		final_area = 0;
		final_perim = 0;
		area = 0;
		perim = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					floodFill(grid, i, j, '#');
				}
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		out.println(final_area + " " + final_perim);

		out.close();
		scan.close();
	}
}
