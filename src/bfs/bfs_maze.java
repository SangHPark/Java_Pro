package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class bfs_maze {

	static int N=5;
	static int M=6;
	
	static int[][] mymaze = {
			{1,0,1,0,1,0},
			{1,1,1,1,1,1},
			{0,0,0,0,0,1},
			{1,1,1,1,1,1},
			{1,1,1,1,1,1}
	};
	
	static boolean[][] visited;
	

	
	static class myPos {
		int x;
		int y;
		int cnt;
	
		myPos(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		visited = new boolean[N][M];

		

		
		System.out.println(travel());
	}
	
	static int travel() {
		
		int steps = 0;
		Queue<myPos> q = new LinkedList();
		
		q.add(new myPos(0,0,1));
		visited[0][0] = true;
		steps = 1;

		
		while (!q.isEmpty()) {
			myPos curr = q.poll();
			int c_cnt = curr.cnt;
			
			if (curr.x == (N-1) && curr.y == (M-1)) return c_cnt;
			
			int[] dx = { -1, 1, 0, 0};
			int[] dy = {  0, 0,-1, 1};
			
			for (int i = 0; i < 4; i ++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					if (!visited[nx][ny] && mymaze[nx][ny] == 1) {
						q.add(new myPos(nx, ny, c_cnt+1));
						System.out.println("nx = " + nx + " ny = " + ny + " c_cnt = " + c_cnt + " steps = " + steps);
						steps ++;
						visited[nx][ny] = true;
					}
				}
			}
		}
		
		return -1;
	}

}
