package floyd_warshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class floyd_bj {

	static int nV;
	static int nE;
	static int INF = 100001;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\floyd_warshall\\floyd_baekjoon.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			nV = Integer.parseInt(br.readLine());
			nE = Integer.parseInt(br.readLine());
			
			int map[][] = new int[nV+1][nV+1];
			
			for (int i = 1; i < nV + 1; i++) {
				for (int j = 1; j < nV + 1; j++) {
					if (i == j) map[i][j] = 0;
					else map[i][j] = INF;
				}
			}
			
			for (int i = 1; i < nE + 1; i++) {
				String[] input = br.readLine().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				int cost = Integer.parseInt(input[2]);
				if (map[start][end] > cost) {
					map[start][end] = cost;
				}
			}
			
			
			for (int i = 1; i < nV + 1; i++) {
				for (int j = 1; j < nV + 1; j++) {
					System.out.print(map[i][j] + "      ");
				}
				System.out.println("");
			}
			
			for (int k = 1; k < nV + 1; k ++) {
				for (int i= 1; i < nV + 1; i ++) {
					for (int j = 1; j < nV + 1; j ++) {
						if (map[i][k] + map[k][j] < map [i][j]) {
						System.out.println("i = " + i + " j = " + j +  " k = " + k + " cost = " + map[i][j] + " --> " + map[i][k] + " + " + map[k][j] ) ;
							map [i][j] = map[i][k] + map[k][j];
						}
					}
				}	
			}
		
			
			
//			for (int i = 1; i < nV + 1; i ++) {
//				for (int j= 1; j < nV + 1; j ++) {
//					for (int k = 1; k < nV + 1; k ++) {
//						if (map[i][k] + map[k][j] < map [i][j]) {
//							map [i][j] = map[i][k] + map[k][j];
//						}
//					}
//				}	
//			}
						
			
			for (int i = 1; i < nV + 1; i++) {
				for (int j = 1; j < nV + 1; j++) {
					System.out.print(map[i][j] + "      ");
				}
				System.out.println("");
			}			
						
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
