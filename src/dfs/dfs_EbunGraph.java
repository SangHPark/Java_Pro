package dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dfs_EbunGraph {

	static int T;
	static int nV;
	static int nE;
	static ArrayList<ArrayList<Integer>> myArrayL;
	static boolean[] visited;
	static String[] colored;
	static boolean isEbunGraph;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\dfs\\dfs_EbunGraph.txt"));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			T = Integer.parseInt(br.readLine());
			
			
			
			for (int i = 0; i < T; i++) {
				String[] Input = br.readLine().split(" ");
				nV = Integer.parseInt(Input[0]);
				nE = Integer.parseInt(Input[1]);
				
				myArrayL = new ArrayList<>();
				
				visited = new boolean[nV + 1];
				colored = new String[nV + 1];
				
				for (int j = 0; j < nV + 1; j++) {
					myArrayL.add(new ArrayList());
				}
				
				for (int j = 0; j < nE ; j++) {
					Input = br.readLine().split(" ");
					int start = Integer.parseInt(Input[0]);
					int end = Integer.parseInt(Input[1]);
					myArrayL.get(start).add(end);
					myArrayL.get(end).add(start);
					
				}
				
				visited[1] = true;
				colored[1] = "RED";
				isEbunGraph = true;
				myBFS(1, colored[1]);
				System.out.println( isEbunGraph ? "YES" : "NO");
			}
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}
	
	static void myBFS(int start, String s_colored) {
		for (int i : myArrayL.get(start) ) {
			//			System.out.println(" start #: " + start + " start color = " + s_colored + ", i = " + i + " i-colored = " + colored[i]);
			if (!visited[i]) {
				visited[i] = true;
				if (s_colored == "RED")	{ colored[i] = "BLUE";}
				else if (s_colored == "BLUE") colored[i] = "RED";

				myBFS(i, colored[i]);

			} else {
				if (s_colored != colored[i]) {
					//					System.out.println(" i = " + i + " Diff Colored");
				} else {
					//					System.out.println("Same Color");
					isEbunGraph = false;
				}
			}
		}
	}

}
