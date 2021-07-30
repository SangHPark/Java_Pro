package paperpickup;

import java.util.Scanner;

public class Solution {
	
	static int N = 4;
	static int[][] A = new int[N+1][N+1];
	static int[][] D = new int[N+1][N+1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= N; i ++) {
			for (int j = 1; j <= N; j ++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		FindSolution();
		
	}

	private static void FindSolution() {
		for (int i = 1; i <= N; i ++) {
			for (int j = 1; j <= N; j ++) {
				if (i == 1 && j == 1) { D[i][j] = A[i][j];}
				if (i > 1) {D[i][j] = Math.max(D[i][j], D[i-1][j] + A[i][j]);}
				if (j > 1) {D[i][j] = Math.max(D[i][j], D[i][j-1] + A[i][j]);}
				
				System.out.println("i " + i + " j " + j + " :" + D[i][j]);
			}
		}
		
		System.out.println("# " + D[N][N]);
		
	}
}
