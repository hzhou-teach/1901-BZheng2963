/*
Bill Zheng
Time: 5 min
USACO Test Cases: ************ 12/12
1-10 Difficulty: 2
Reflection: The only hard part about this problem is finding the best solution. In this case, finding the solution took longer
	than writing the code cause the code is super easy if you find the right solution.
 */

import java.io.*;
import java.util.*;

public class sleepy_1901_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("sleepy.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] order = new int[N];
		for (int i = 0; i < N; i++) {
			order[i] = scan.nextInt();
		}
//--------------------------------------------------------------------------------------------------------------------------
		//Count from the end how many cows are in order already cause we only have to move the cows before
		int count = 1;
		for (int i = N-2; i >= 0; i--) {
			if (order[i] < order[i+1]) {
				count ++;
			} else break;
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		System.out.println(N-count);
		out.println(N-count);

		out.close();
		scan.close();
	}
}
