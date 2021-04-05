package floyd_warshall;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution_bj_curiousmh {

	static int nV;
	static int map[][];
	static boolean road[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\floyd_warshall\\bj_curiousmh.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			nV = Integer.parseInt(br.readLine());
			map = new int[nV+1][nV+1];
			road = new boolean[nV+1][nV+1];
			
			for (int i = 1; i < nV + 1; i++ ) {
				String[] input = br.readLine().split(" ");
				for (int j = 1; j < nV + 1; j++) {
					map[i][j] = Integer.parseInt(input[j - 1]);
					road[i][j] = true;
				}
			}
			
			for (int i = 1; i < nV + 1; i ++) {
				for (int j = 1; j < nV + 1; j ++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println(" ");
			}
			
			for (int k = 1; k < nV + 1; k ++) {
				for (int i = 1; i < nV + 1; i ++) {
					for (int j = 1; j < nV + 1; j ++) {
						if (map[i][j] > map[i][k] + map[k][j])
							{
							System.out.print("-1");
							}
						if (map[i][j] == map[i][k] + map[k][j]) {
							road[i][j] = false;
							
						}
					}
				}					
			}
		
			for (int i = 1; i < nV + 1; i ++) {
				for (int j = 1; j < nV + 1; j ++) {
					if (road[i][j]) {
						System.out.print("Road: " + road[i][j] + " ");
					}
				}
				System.out.println(" ");
			}					
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

}
