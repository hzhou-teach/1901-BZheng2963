/*
Bill Zheng
Time: 25 min
USACO Test Cases: *********** 11/11
1-10 Difficulty: 5
Reflection: The hardest part is coming up with the solution that would work in time, but I had already did this problem in
	competition so I already knew kind of what the solution was going to be like. I really didn't think my code would work
	in time because I used a "bronze" method, but it turns out that it did work and got all the cases. Code was easy.
 */

import java.io.*;
import java.util.*;

class mountains implements Comparable <mountains>{
	int x, y;
	public int compareTo(mountains m) {
		return m.y - y;
	}
}

public class mountains_1901_silver {
//--------------------------------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner (new File ("mountains.in"));
//--------------------------------------------------------------------------------------------------------------------------
		int N = scan.nextInt();
		mountains[] M = new mountains[N];
		
		for (int i = 0; i < N; i++) {
			M[i] = new mountains();
			M[i].x = scan.nextInt();
			M[i].y = scan.nextInt();
		}
		Arrays.sort(M); //sort mountains starting with mountain with highest peak
//--------------------------------------------------------------------------------------------------------------------------
		int highest = 0;
		for (int i = 0; i < N; i++) {
			if (M[i].x == -1) continue;
			highest = i; //use highest peak to basically knock out/cover up smaller mountains, and don't count them again to save time
			for (int j = i+1; j < N; j++) {
				if (M[j].x == -1) continue;
				int dist = Math.abs(M[highest].x-M[j].x) + Math.abs(M[j].y); //if this mountain is under the tallest mountain
				if (dist <= M[highest].y) {
					M[j].x = -1;
					M[j].y = -1;
				}
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (M[i].x != -1) {
				count++;
			}
		}
//--------------------------------------------------------------------------------------------------------------------------
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		out.println(count);

		out.close();
		scan.close();
	}
}
