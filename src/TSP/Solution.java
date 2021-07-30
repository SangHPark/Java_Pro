package TSP;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

	static int nV;
	static int[][] cost;
	static int[][] dp;
	
	static int INF = Integer.MAX_VALUE;
	static int START = 1;
	static int NOT_CONNECTED = 0;
	static int NOT_VISITED = -1;
	
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\TSP\\Solution.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			nV = Integer.parseInt(br.readLine());
			
			cost = new int[nV + 1][nV + 1]; 
			
			for (int i = 1; i < nV + 1; i ++) {
				String[] input = br.readLine().split(" ");
				for (int j = 1; j < nV + 1; j ++ ) {
					cost[i][j] = Integer.parseInt(input[j - 1]);
				}
			}
			
//			for (int i = 1; i < nV + 1; i ++ ) {
//				int x = 1 << i;
//				System.out.println("십진수 : " +  x + " ");
//				System.out.println("이진수 : " + Integer.toBinaryString(x) + " ");
//				
//			}
			
			dp = new int[nV * nV][1 << nV * nV];
			
			for (int i = 1; i < nV + 1; i ++) {
				for (int j = 1; j < nV + 1; j ++ ) {
					System.out.print(cost[i][j] + " ");
				}
				System.out.println("");				
			}
			
			System.out.println("DP Initial Value");
			for (int i = 1; i < nV + 1; i ++) {
				for (int j = 1; j < nV + 1; j ++) {
					System.out.println("i = " + i + " j = " + j + " dp = " + dp[i][1 << 2 * j] + " ");	
				}
			}			
			
			for (int i =1 ; i < nV + 1; i ++ ) {
				Arrays.fill(dp[i], NOT_VISITED);
			}
			
			
			System.out.println("DP After Set with NOT VISITED (-1)");
			for (int i = 1; i < nV + 1; i ++) {
				for (int j = 1; j < nV + 1; j ++) {
					System.out.println("i = " + i + " j = " +  " dp = " + dp[i][1 << 2 * j] + " ");	
				}
			}			
						
			System.out.println("answer " + solve(START, START << 1));
			
			
		} catch (Exception e) {
			System.out.println(e.toString());

		}

	}
	
	static int solve (int curr, int B) {
		System.out.println("curr = " + curr + " B = " + B + " dp = " + dp[curr][B] + " ");	
		
		if (dp[curr][B] != NOT_VISITED) return dp[curr][B];
		
		if (B == (1 << nV) - 1) {
			return dp[curr][B] = cost[curr][START] != NOT_CONNECTED ? cost[curr][START] : INF;
		}
		
		dp[curr][B] = INF;
		
		for (int i = 1; i < nV + 1; i ++) {
			if (cost[curr][i] == NOT_CONNECTED || (B & (1 << i)) > 0) continue;
			
			dp[curr][B] = Math.min(dp[curr][B], solve(i, B | (i << i) + cost[curr][i]));
		}
		
		return dp[curr][B];
	}

}
