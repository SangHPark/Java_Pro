package largest_shortest_path;

import java.util.Scanner;

//1
//3
//1 2
//4

//1
//4
//3 2 1 4
//1 0 2
//1 0
//2

public class Solution {

	static int N = 500;
	static int [][] graph = new int[N][N];
	static int[] del_order = new int[0];
	static long[][] dist = new long[0][0];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int N = sc.nextInt();
		
		del_order = new int[N+1];
		
		for (int i = N; i >=1; --i) {
			int del_idx = sc.nextInt();
			del_order[del_idx] = i;
		}
		
		for (int i = 1; i <= N; i ++) {
			System.out.print(del_order[i] + " ");
		}
		
		System.out.println("");
		
		int idx1, idx2;
		for (int i=1; i<=N; i++) {
			idx1 = del_order[i];
			for (int j=i+1; j<=N; j++) {
				idx2 = del_order[j];
				graph[idx1][idx2] = sc.nextInt();
				graph[idx2][idx1] = graph[idx1][idx2];	
				
			}
		}
		
		dist = new long[N+1][N+1];
		
		for (int V=1; V <= N; V++) {
			for (int i = 1; i <= V; i++) {
				dist[i][V] = graph[i][V];
				dist[V][i] = dist[i][V];
			}
		}
		
//		for (int i=1; i<=testcase; i++) {
//			for (int j=1; j<=N; j++) {
//				for (int k=j; k<=N; k++) {
//					if (j == k) {graph[j][k] = 0;}
//					else {
//						graph[j][k] = sc.nextInt();
//					}
//				}
//			}
//			
//		}
		
		
		for (int j=1; j<=N; j++) {
			for (int k=1; k<=N; k++) {
					System.out.print(" " + graph[j][k]);
			}
			System.out.println("");
		}
		
	}

}
