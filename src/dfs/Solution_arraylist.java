package dfs;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_arraylist {
	static int nV = 0;
	static int nE = 0;
	static int start = 0;
	static ArrayList<ArrayList<Integer>> arrlist;
	
	static boolean[] visited;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\dfs\\dfs2.txt"));
			Scanner sc = new Scanner(System.in);
		
			
			nV = sc.nextInt();
			nE = sc.nextInt();
			
			start = sc.nextInt();			
			
			arrlist = new ArrayList();
			visited = new boolean[nV+1];
			
			
			for (int i =0; i < nV + 1; i++) {
				arrlist.add(new ArrayList());
			}
			
			
			
			for (int i = 0; i < nE; i ++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				arrlist.get(x).add(y);
				arrlist.get(y).add(x);
			}
			
			
			for (int i = 0; i < nV + 1; i ++) {
				System.out.println("i = " + i + " value = " + arrlist.get(i));
			}			
			
			DFS(start);

			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}

	public static void DFS(int i) {
		
		visited[i] = true;
		
		System.out.println(i + " ");
		
		for (int j : arrlist.get(i) ) {
			if (visited[j] == false) {
				DFS(j);
			}
		}
		
	}

}
