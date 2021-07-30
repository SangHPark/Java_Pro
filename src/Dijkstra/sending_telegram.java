package Dijkstra;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class sending_telegram {

	static int N;
	static int M;
	static int C;
	
	static int[][] map;
	static int[] d;
	
	static int INF = 1001;
	
	static class Element implements Comparable <Element>{
		int idx;
		int distance;
		
		public Element(int i, int d) {
			this.idx = i;
			this.distance = d;
		}

		@Override
		public int compareTo(Element target) {
			// TODO Auto-generated method stub
			return this.distance > target.distance ? 1 : -1;
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\Dijkstra\\sending_telegram.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		C = Integer.parseInt(input[2]);
		
		map = new int[N+1][N+1];
		d = new int[N+1];
		
		Arrays.fill(d,  INF);
		
		for (int i = 1; i < N+1; i ++) {
			for (int j = 1; j < N+1; j ++) {
				if (i == j) map[i][j] = 0;
				else map[i][j] = INF;
			}
		}		
		
		for (int i = 1; i < M+1; i ++) {
			String[] input2 = br.readLine().split(" ");
			
			int from = Integer.parseInt(input2[0]);
			int to = Integer.parseInt(input2[1]);			
			int cost = Integer.parseInt(input2[2]);
			
			map[from][to] = cost;
		}
		


		
		for (int i = 1; i < N+1; i ++) {
			for (int j = 1; j < N+1; j ++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println(" ");
		}
		
		Dijkstra(C);
		
		for (int i = 1; i < N+1; i++) {
			System.out.print(d[i] + " ");
		}
	}
	
	static void Dijkstra(int C) {
		PriorityQueue<Element> pq = new PriorityQueue<>();
		
		pq.offer(new Element(C, 0));
		while (!pq.isEmpty()) {
			Element curr = pq.poll();
			
			for (int i = 1; i < d.length; i++) {
				if (d[i] < curr.distance) continue;
				
				int cost = curr.distance + map[curr.idx][i];
				if (d[i] > cost) {
					d[i] = cost;
					pq.offer(new Element(i, d[i]));
				}
			}
		}
	}

}


