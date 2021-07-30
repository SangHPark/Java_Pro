package bellman_ford;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Edge {
	int from;
	int to;
	int cost;
	
	public Edge(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}
}

public class bj_11657 {

	static int nV;
	static int nE;
	
	static int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\bellman_ford\\bj_11657.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String[] input = br.readLine().split(" ");
			nV = Integer.parseInt(input[0]);
			nE = Integer.parseInt(input[1]);
			
			Edge[] EdgeArray = new Edge[nE+1];
			
			int[] D = new int[nV + 1];
			
			for (int i = 1; i < nV + 1; i ++ ) {
				D[i] = INF;
			}
			

			
			for (int i = 1; i < nE + 1; i ++) {
				String[] input_map = br.readLine().split(" ");
				int start = Integer.parseInt(input_map[0]);
				int end = Integer.parseInt(input_map[1]);
				int cost = Integer.parseInt(input_map[2]);
				
				EdgeArray[i] = new Edge(start, end, cost);
//				map[start][end] = cost;
			}
			
//			for (int i = 1; i < nV + 1; i ++) {
//				for (int j = 1; j < nV + 1; j ++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println(" ");
//			}
			
			
			D[1] = 0;
			
			for (int i = 1; i < nV ; i ++ ) {
				for (int j = 1; j < nE + 1 ; j ++) {
					if (D[EdgeArray[j].from] == INF) {
						continue;
					}
					
					if (D[EdgeArray[j].to] > D[EdgeArray[j].from] + EdgeArray[j].cost) {
						D[EdgeArray[j].to] = D[EdgeArray[j].from] + EdgeArray[j].cost;
					}

				}
			}
			
			boolean flag = false;
			for (int j = 1; j < nE + 1; j ++) {
				if (D[EdgeArray[j].from] == INF) {
					continue;
				}
				if (D[EdgeArray[j].to] > D[EdgeArray[j].from] + EdgeArray[j].cost) {
					flag = true;
				}
			}
			
			if (flag ) {
				System.out.println("-1");
			} else {
				for (int i = 2; i < nV + 1; i++ ) {
					System.out.println(D[i] == INF ? -1: D[i]);
				}
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
