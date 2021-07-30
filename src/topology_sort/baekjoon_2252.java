package topology_sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2252 {
	static long _start = 0;
	static void printElapse() {
		System.out.println(">> " + (System.currentTimeMillis() - _start) + "ms");
	}
	
	static int N, M;
	static int[] inDegree;
	static ArrayList<Edge> alist;
	
	static class Edge {
		int from;
		int to;
		
		Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_start = System.currentTimeMillis(); // set application start time for test which do not mandatory for exam.
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\topology_sort\\baekjoon_2252.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			
			alist = new ArrayList<Edge>();
			
			inDegree = new int[N+1];
			
			int[] result = new int[N+1];
			Queue<Integer> q = new LinkedList<Integer>();
			
			for (int i = 0; i < M; i ++ ) {
				String[] input2 = br.readLine().split(" ");
				int a = Integer.parseInt(input2[0]);
				int b = Integer.parseInt(input2[1]);
				
				alist.add(new Edge(a, b));
				inDegree[b] ++;
			}
			
			//진입차수가 0인 노드를 큐에 삽입합니다.
			for (int i = 1; i < N+1; i++) {
				if (inDegree[i] == 0) q.add(i);
			}
			
			//위상정렬이 완전히 수랭되려면 정확히 N개의 노드를 방문해야 합니다
			for (int i = 1; i < N+1; i++) {
				//N개를 방문하기 전에 큐가 빈다면 사이클이 발생한것
				if (q.isEmpty()) {
					System.out.println("There is cycle");
					return;
				}
				
				int x = q.poll();
				result[i] = x;
				
				for (int j = 0; j < M; j ++ ) {
					if (alist.get(j).from == x) {
						int to = alist.get(j).to;
						inDegree[to] --;
						//새롭게 진입차수가 0이된 정점을 큐에 삽입합니다.
						if (inDegree[to] == 0) {
							q.add(to);
						}
					}
				}
			}
			

			for (int i = 1; i < N+1; i++) {
				System.out.print(result[i] + " ");
			}
			printElapse(); // Display program running time. This line of code has to be removed from submitted code.
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
