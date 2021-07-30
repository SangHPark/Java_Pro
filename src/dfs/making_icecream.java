package dfs;

public class making_icecream {

	static int N = 4;
	static int M = 5;
	static int[][] cases = {
			{0, 0, 1, 1, 0},
			{0, 0, 0, 1, 1},
			{1, 1, 1, 1, 1},
			{0, 0, 0, 0, 0}
	};
	
	
	static boolean[][] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		visited = new boolean[N][M];
		int ice_cnt = 0;
		
		for (int i = 0; i < N; i ++ ) {
			for (int j = 0; j < M; j++ ) {
				if (cases[i][j] == 0 && !visited[i][j]) {
					ice_cnt ++;
//					System.out.println("i = " + i + " j = " + j);
					dfs(i,j);
				}
			}
		}
		
		System.out.println(ice_cnt);
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
	
		int[] dx = {-1, 1, 0, 0};
		int[] dy = { 0, 0,-1, 1};
		
		for (int i = 0; i < 4; i ++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				if (!visited[nx][ny]) {
					if (cases[nx][ny] == 0) {
						dfs(nx, ny);
					}
				}
			}
			
		}
		
		
		
	}
	

}
