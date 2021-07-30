package MST;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kruskal {
	static int nV;
	static int nE;
	static ArrayList<Edge> eArrList;
	static int[] parent ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\MST\\baekjoon_1922.txt"));
			Scanner sc = new Scanner(System.in);
		
			
			nV = sc.nextInt();
			nE = sc.nextInt();
			
			eArrList = new ArrayList<Edge>();
			
			parent = new int[nV];
			
		
			for (int i =0; i < nE; i++) {
				int[] node = new int[2];
				node[0] = sc.nextInt();
				node[1] = sc.nextInt();
				int distance = sc.nextInt();
				
				eArrList.add(new Edge(node, distance));
			}
			
			Collections.sort(eArrList);
			
			
			for (int i = 0; i < nE; i ++) {
				System.out.println("i = " + i + " start = " + eArrList.get(i).node[0] + " end = " + eArrList.get(i).node[1] + " distance = " + eArrList.get(i).distance);
			}			
			

			for (int i = 0; i <nV; i++) {
				parent[i] = i;
			}
			
			//before union parent
			System.out.println("Before");
			for (int i = 0; i < nV; i ++) {
				System.out.println("i = " + i + " Parent = " + getParent(i));
			}			
			
			
			int sum = 0;
			for (int i = 0; i < nE; i++) {
				if (!hasSameParent(eArrList.get(i).node[0] - 1, eArrList.get(i).node[1] - 1)) {
					sum += eArrList.get(i).distance;
					unionParent(eArrList.get(i).node[0] - 1, eArrList.get(i).node[1] - 1);					
				}

			}

			//after union parent		
			System.out.println("After");
			for (int i = 0; i < nV; i ++) {
				System.out.println("i = " + i + " Parent = " + getParent(i));
			}			

			System.out.println("MST = " + sum);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}


	}
	
	
	public static int getParent(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = getParent(parent[x]);
	}
	
	public static void unionParent(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		
		if (pa < pb) parent[b] = pa;
		else parent[a] = pb;
	}
	
	public static boolean hasSameParent(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		
		if (pa == pb) return true;
		else return false;
	}
		

}

