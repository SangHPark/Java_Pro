package bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs_breakwall {

	static int N;
	static int M;
	
	static int[][] map;
	static boolean[][] visited;
	
	static boolean[][] OneTimeBreak;
	static boolean isUsed = false;
	
	static int result;
	
	static Queue<myMAP> q = new LinkedList<>();	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\bfs\\bfs_breakwall.txt"));
 
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Read data in input file or external input.		
			
//			int T = Integer.parseInt(br.readLine()); // <- input has 2 group of test set
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]); // Read next integer at first group starts which is 2. 2nd group case it would be 3.
			M = Integer.parseInt(input[1]); // Read next integer at first group starts which is 1. 2nd group case it would be 3.
			
//			Scanner sc = new Scanner(System.in);
//			
//			N = sc.nextInt();
//			M = sc.nextInt();
			
			map = new int[N+1][M+1];
			visited = new boolean[N+1][M+1];
			OneTimeBreak = new boolean[N+1][M+1];
			for (int i = 1 ; i < N+1 ; i++) {
				input = br.readLine().split("");
				for (int j = 1 ; j < M +1; j ++ ) {
					map[i][j] =  Integer.parseInt(input[j-1]);
				}
			}
			
//			for (int i = 1 ; i < N+1 ; i++) {
//				
//				for (int j = 1 ; j < M +1; j ++ ) {
//					map[i][j] =  sc.nextInt();
//				}
//			}
//			
			for (int i = 1 ; i < N+1 ; i++) {
				for (int j = 1 ; j < M +1; j ++ ) {
					visited[i][j] =  false;
					OneTimeBreak[i][j] =  false;
				}
			}

		
//			for (int i = 1 ; i < N+1 ; i++) {
//				for (int j = 1 ; j < M +1; j ++ ) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println("");
//			}
			

			
			myMAP current = new myMAP(1,1,1);
			visited[1][1] = true;
			
			q.add(current);
			
			while (!q.isEmpty()) {
				current = q.poll();
				
				if (current.xpos == N && current.ypos == M)	{
					System.out.println("result: " + current.v_cnt);
					return;
				}
				
				if (OneTimeBreak[current.xpos][current.ypos]) {
					isUsed = true;
				}
				
				int newX, newY;
				int count;
				count = current.v_cnt;
//				System.out.println("Count: " + count);
				
//				     System.out.println("startX: " + current.xpos + " startY: " + current.ypos);
					 newX = current.xpos + 1;
					 newY = current.ypos ;
//					 System.out.println("+X newX: " + newX + " newY: " + newY);					 
					 moveNext(newX, newY, count);	
						
					 newX = current.xpos - 1;
					 newY = current.ypos ;
//					 System.out.println("-X newX: " + newX + " newY: " + newY);
					 moveNext(newX, newY, count);
						
					 newX = current.xpos ;
					 newY = current.ypos + 1;
//					 System.out.println("+Y newX: " + newX + " newY: " + newY);
					 moveNext(newX, newY, count);				 
					 
					 newX = current.xpos ;
					 newY = current.ypos - 1;
//					 System.out.println("-Y newX: " + newX + " newY: " + newY);
					 moveNext(newX, newY, count);				 
			}
			
			System.out.println(-1);

//			sc.close();
			br.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void moveNext(int newX, int newY, int count) {
		 if (newX > 0 && newX < (N+1) && newY > 0 && newY < (M+1) ) {
			 if (!visited[newX][newY]) {
				 visited[newX][newY] = true;
				 if (map[newX][newY] == 0) {
					 q.add(new myMAP(newX, newY,  count + 1));
//					 System.out.println("Added Queue");
				 } else {
					 if (!isUsed) {
						 OneTimeBreak[newX][newY] = true;
						 q.add(new myMAP(newX, newY, count + 1));
//						 System.out.println("Added Queue with Break");
					 }
				 }
			 }
		 }		
	}


}

class myMAP {
	int xpos; int ypos;
	int v_cnt;
	
	public myMAP (int x, int y, int vc) {
		this.xpos = x;
		this.ypos = y;
//		this.visited = v;
//		this.broken = b;
		this.v_cnt = vc;
	}
}
