package Dijkstra;

import java.io.FileInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

public class dijkstra_pq {

	static int nV;
	static int nE;
	
	static int[][] ad;
	static boolean[] visited;
	static int[] distance;
	
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\Dijkstra\\Dijkstra_2.txt"));
			Scanner sc = new Scanner(System.in);
			
			nV = sc.nextInt();
			nE = sc.nextInt();
			
			
			ad = new int[nV + 1][nV + 1];
			visited = new boolean[nV + 1];			
			distance = new int[nV + 1];
			
			for (int i = 0; i < nV + 1; i ++) {
				distance[i] = Integer.MAX_VALUE;
			}
			
			for (int i = 0; i < nV + 1; i ++ ) {
				for (int j = 0; j < nV + 1; j ++ ) {
					ad[i][j] = Integer.MAX_VALUE;
				}
			}
			
					
			for (int i = 1; i < nE + 1; i++) {
				int t1 = 0;
				int t2 = 0;
				int t3 = 0;
				
				t1 = sc.nextInt();
				t2 = sc.nextInt();
				t3 = sc.nextInt();
				
				ad[t1][t2] = t3;
				
				
			}
			
			int start = sc.nextInt();
			int end = sc.nextInt();
			

			for (int i = 1; i < nV + 1; i++) {
				for (int j = 1; j < nV + 1; j++) {
					System.out.println("start= " + i + " end = " + j + " distance = " + ad[i][j]);
				}
			}
			
			PriorityQueue <Element> pq = new PriorityQueue();
			distance[start] = 0;
			pq.offer(new Element(start, distance[start]));

			while(!pq.isEmpty()) {
				Element current = pq.poll();
				if (current.distance > distance[current.index]) continue;
				
				for (int i = 1; i < nV + 1; i ++) {
					if (ad[current.index][i] != Integer.MAX_VALUE) {
						if (distance[i] > distance[current.index] + ad[current.index][i]) {
							distance[i] = distance[current.index] + ad[current.index][i];
							pq.offer(new Element(i, distance[i]));
							
						}
					}
				}
				
			}
			
			System.out.println(distance[end]);
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
}
