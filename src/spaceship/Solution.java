package spaceship;

import java.util.Scanner;

public class Solution {

	static int N, M;
	static int[][] map = new int[1000][1000];
	static int[][] round = new int[1000][1000];
	static int[] di = {-1, 1, 0, 0};
	static int[] dj = { 0, 0, 1,-1};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for (int i = 1; i <= N ; i++) {
			for (int j = 1; j <= M ; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
        
//		for (int j = 0; j <= M+1 ; j ++) {
//			map[0][j] = 0;
//		}
		
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println("");
		}
		
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				
				if (map[i][j] != 0) {
					int min_value = 10;
					for (int k = 0; k < 4; k ++) {
						int move_i = i + di[k];
						int move_j = j + dj[k];
						//주변에서 값이 가장 적은 값을 찾는다
						
						if (min_value > map[move_i][move_j]) {
							min_value = map[move_i][move_j];
						}
						
						//찾으값이 0 보다 크면 , 다시 그 점주위 값을 찾아본다 , 0을 찾을때 까지 반복하다.ㅣ
						if (min_value > 0) {
							dofindzero(move_i,move_j);
						}
						
						if (move_i >= 0 && move_i <= N + 1 && move_j >= 0 && move_j <= M + 1) {
							if (map[move_i][move_j] == 0 && map[i][j] > 0) {
								map[i][j] --;
								round[i][j] ++;
							}
						}
					}
				}
				
			}
		}
		
		System.out.println("");
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				System.out.print(map[i][j]);
				
			}
			System.out.println("");
		}		

		System.out.println("");
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < M + 2; j++) {
				System.out.print(round[i][j]);
				
			}
			System.out.println("");
		}			
	}

	private static void dofindzero(int i, int j) {
		if (map[i][j] == 0) {
			return;
		}
		
		
		for (int k = 0; k < 4; k ++) {
			int move_i = i + di[k];
			int move_j = j + dj[k];
			
//			if (map[move_i][map_j] == 0) { 
//				return
//			}
			dofindzero(move_i,move_j);
		}
		
	}

}
