/*
Bill Zheng
Time: 5 min
USACO Test Cases: ********** 10/10
1-10 Difficulty: 2
Reflection: Solution is really easy, just test all 3 starting positions. Code can get messy if you make mistakes.
 */

import java.io.*;
import java.util.*;

public class shell_1901_bronze {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("shell.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		int[] swap = new int[N*2];
		int[] pick = new int[N];
		for (int i = 0; i < N; i++) {
			swap[i*2] = scan.nextInt();
			swap[i*2+1] = scan.nextInt();
			pick[i] = scan.nextInt();
		}
//--------------------------------------------------------------------------------------------------------------------------
		int max = Integer.MIN_VALUE;
		int shell = 0;
		int count = 0;
		for (int j = 1; j < 4; j++) {
			shell = j;
			count = 0;
			for (int i = 0; i < N; i++) {
				if (shell == swap[i*2]) {
					shell = swap[i*2+1];
				} else if (shell == swap[i*2+1]){
					shell = swap[i*2];
				}
				if (shell == pick[i]) {
					count++;
					max = Math.max(count, max);
				}
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		System.out.println(max);
		out.println(max);

		out.close();
		scan.close();
	}
}
