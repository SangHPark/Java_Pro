package bfs;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class solution {
	
	static int N = 0;
	static int M = 0;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\bfs\\bfs.txt"));
			Scanner sc = new Scanner(System.in);
		
			
			N = sc.nextInt();
			M = sc.nextInt();
			
			arr = new int[N][M];
			visited = new boolean[N][M];
			
			
			for (int i = 0; i < N; i ++) {
				for (int j = 0; j < M; j ++) {
					arr[i][j] = sc.nextInt();
					visited[i][j] = false;
				}
			}
			
			visited[0][0] = true;
			BFS(0,0);
			
//			for (int i = 0; i < N; i ++) {
//				for (int j = 0; j < M; j ++) {
//					System.out.println("i = " + i + " ,j = " + j + " value = " + arr[i][j]);
//				}
//			}			
//			
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}
	
	static void BFS(int start, int end) {
		try {
			Queue<myNode> q = new LinkedList<>();
			
			q.add(new myNode (start, end, 1));

			while (!q.isEmpty()) {
				myNode node = q.poll();
				visited[node.x][node.y] = true;
				
				System.out.println(node.x + "," + node.y);
				
				if (node.y - 1 > 0 && node.y -1  < M && arr[node.x][node.y - 1] == 1 && visited[node.x][node.y - 1] == false ) {
					q.add(new myNode(node.x, node.y - 1,node.depth + 1));
					System.out.println("In Q " + node.x + "," + (node.y - 1) );
				}

				if (node.y + 1 > 0 && node.y + 1  < M && arr[node.x][node.y + 1] == 1 && visited[node.x][node.y + 1] == false ) {
					q.add(new myNode(node.x, node.y + 1,node.depth + 1));
					System.out.println("In Q " + node.x + "," + (node.y + 1) );					
				}				

				if (node.x - 1 > 0 && node.x - 1 < N && arr[node.x - 1][node.y] == 1 && visited[node.x - 1][node.y] == false ) {
					q.add(new myNode(node.x - 1, node.y,node.depth + 1));
					System.out.println("In Q " + (node.x - 1) + "," + node.y );					
				}
				
				if (node.x + 1 > 0 && node.x + 1 < N && arr[node.x + 1][node.y] == 1 && visited[node.x + 1][node.y] == false ) {
					q.add(new myNode(node.x + 1, node.y,node.depth + 1));
					System.out.println("In Q " + (node.x + 1) + "," + node.y );					
				}				
				
				if (visited[N-1][M-1]) {
					System.out.println("Arrived");
					System.out.println(node.depth);
					break;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	


}
