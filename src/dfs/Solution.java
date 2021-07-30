package dfs;

import java.util.ArrayList;

public class Solution {
	static int V = 5;
	static int[] visited = new int[5];
	
	static ArrayList<Integer>[] adjList = new ArrayList[V];
	public static void main(String[] args) {
		
		adjList[0] = new ArrayList<Integer>();
		adjList[0].add(1);
		adjList[0].add(2);
		
		adjList[1] = new ArrayList<Integer>();
		adjList[1].add(0);
		adjList[1].add(2);		
		
		adjList[2] = new ArrayList<Integer>();
		adjList[2].add(0);
		adjList[2].add(1);			
		adjList[2].add(3);
		adjList[2].add(4);
		
		adjList[3] = new ArrayList<Integer>();
		adjList[3].add(2);
		
		adjList[4] = new ArrayList<Integer>();
		adjList[4].add(2);
		
		for (int i =0; i < V; i++) {
			visited[i] = 0;
		}
		
		
		for (int i = 0; i <V ; i ++) {
			System.out.println("i = " + i + " value = " + adjList[i]);
		}		

		dfs(0);
		
	}
	private static void dfs(int node) {
		// TODO Auto-generated method stub
		visited[node] = 1;
		
		processVortex(node);
		
		if (adjList[node] != null) {
			for (int adjaent : adjList[node] ) {
				if (visited[adjaent] == 1) {
					continue;
				}
				
				dfs(adjaent);
			}
		}
		
	}
	private static void processVortex(int node) {
		System.out.println(node );
		
	}
}
