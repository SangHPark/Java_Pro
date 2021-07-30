package floyd_warshall;

import java.io.FileInputStream;
import java.util.Scanner;

public class via_k {

	static int N;
	static int M;

	static int X;
	static int K;

	static int[][] map;
	
	static int[][] d;
	static int INF = 987654321;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\floyd_warshall\\via_k.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N+1][N+1];
		d = new int[N+1][N+1];
		
		for (int i = 1; i < N+1; i ++) {
			for (int j = 1; j < N+1; j ++) {
				if (i == j) map[i][j] = 0;
				else map[i][j] = INF; 
			}
		}
		
		
		for (int i = 1; i < M  + 1; i ++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			map[from][to] = 1;
			map[to][from] = 1;
		}
		
		
		X = sc.nextInt();
		K = sc.nextInt();		
		
		
		for (int i = 1; i < N + 1; i ++) {
			for (int j = 1; j < N + 1; j ++) {
				System.out.print( map[i][j] + " ");
			}
			System.out.println("");
		}
		
		for (int k = 1; k < N+1; k ++) {
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					if (map[i][j] > map[i][k] + map[k][j]) {
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		System.out.print(map[1][K] + map[K][X]);
	
			
		
	}

}
