package dfs;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_adjarray {

	static int nV = 0;
	static int nE = 0;
	static int start = 0;
	static int[][] adjarr;
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\dfs\\dfs2.txt"));
			Scanner sc = new Scanner(System.in);
		
			
			nV = sc.nextInt();
			nE = sc.nextInt();
			
			start = sc.nextInt();			
			
			adjarr = new int[nV+1][nV+1];
			visited = new boolean[nV+1];
			
			
			for (int i = 0; i < nE; i ++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				adjarr[x][y] = 1;
				adjarr[y][x] = 1;
				
//				visited[i][j] = false;
			}
			
			
			for (int i = 0; i < nV + 1; i ++) {
				for (int j = 0; j < nV + 1; j ++) {
					System.out.println("i = " + i + " ,j = " + j + " value = " + adjarr[i][j]);
				}
			}			
			
			DFS(start);

			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	public static void DFS(int i) {
		
		visited[i] = true;
		
		System.out.println(i + " ");
		
		for (int j = 1; j < nV + 1 ; j++ ) {
			if (adjarr[i][j] == 1 && visited[j] == false) {
				DFS(j);
			}
		}
		
	}

}
