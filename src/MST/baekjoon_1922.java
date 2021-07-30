package MST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class baekjoon_1922 {

	static int N, M;
	static ArrayList<myEdge> myEdgelist;
	static int[] parent;
	
	static class myEdge implements Comparable<myEdge> {
		int[] node = new int[2];
		int cost;
		
		public myEdge(int f, int t, int c) {
			this.node[0] = f;
			this.node[1] = t;
			this.cost = c;
		}

		@Override
		public int compareTo(myEdge target) {
			// TODO Auto-generated method stub
			return cost <= target.cost ? -1 : 1;
		}
	}
	
	public static int getParent(int[] parent, int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = getParent(parent, parent[x]);
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		int p_a = getParent(parent, a);
		int p_b = getParent(parent, b);
		
		if (p_a < p_b) parent[p_b] = p_a;
		else parent[p_a] = p_b;
	}
	
	public static boolean isSameParent(int[] parent, int a, int b) {
		int p_a = getParent(parent, a);
		int p_b = getParent(parent, b);
		
		if (p_a == p_b) return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\MST\\baekjoon_1922.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			myEdgelist = new ArrayList<myEdge>();
			
			parent = new int[N+1];
			
			for (int i = 0; i < M; i ++) {
				String[] Input = br.readLine().split(" ");
				int from = Integer.parseInt(Input[0]);
				int to = Integer.parseInt(Input[1]);
				int cost = Integer.parseInt(Input[2]);
				
				myEdgelist.add(new myEdge(from, to, cost));
			}
			
			Collections.sort(myEdgelist);
			
			for (int i = 0; i < myEdgelist.size(); i ++) {
				System.out.println(myEdgelist.get(i).node[0] + " " + myEdgelist.get(i).node[1] + " " + myEdgelist.get(i).cost);
			}
			
			for (int i = 1; i < N+1; i ++) {
				parent[i] = i;
			}

			int answer = 0;
			for (int i = 0; i < myEdgelist.size(); i ++) {
				int from = myEdgelist.get(i).node[0];
				int to = myEdgelist.get(i).node[1];
				
	
				if (!isSameParent(parent, from, to)) {
					unionParent(parent, from, to);
					System.out.println("from = " + from + " to = " + to);
					answer += myEdgelist.get(i).cost;
				}
			}

			for (int i = 1; i < N+1; i ++) {
				System.out.println(" i = " + i + " parent = " + parent[i]);
			}			
			
			System.out.println("answer = " + answer);
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

}
