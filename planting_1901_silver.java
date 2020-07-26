/*
Bill Zheng
Time: 5 min
USACO Test Cases: ********** 10/10
1-10 Difficulty: 3
Reflection: Since I did this problem before I knew the solution but if I didn't know the solution, it might have taken longer
	to find the solution. Once you know the solution the code is really simple.
 */

import java.io.*;
import java.util.*;

public class planting_1901_silver {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("planting.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] nums = new int[N+1];
		for (int i = 0; i < (N-1)*2; i++) {
			int connection = scan.nextInt();
			nums[connection]++;
		}
//--------------------------------------------------------------------------------------------------------------------------
		//The answer is just 1 more than the number of connections the island with the most connections has
		int max = -1;
		for (int i = 0; i < N+1; i++) {
			max = Math.max(max, nums[i]);
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		System.out.println(max+1);
		out.println(max+1);

		out.close();
		scan.close();
	}
}
