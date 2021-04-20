package topology_sort;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2252 {
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
			
			for (int i = 1; i < N+1; i++) {
				if (inDegree[i] == 0) q.add(i);
			}
			
			for (int i = 1; i < N+1; i++) {
				if (q.isEmpty()) {
					System.out.println("There is cycle");
					return;
				}
				
				int x = q.poll();
				result[i] = x;
				
				for (int j = 0; j < alist.size(); j ++ ) {
					if (alist.get(j).from == x) {
						inDegree[alist.get(j).to] --;
						if (inDegree[alist.get(j).to] == 0) {
							q.add(alist.get(j).to);
						}
					}
				}
			}
			

			for (int i = 1; i < N+1; i++) {
				System.out.print(result[i] + " ");
			}
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
