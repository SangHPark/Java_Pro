package Dijkstra;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class myD_Solution {
	static int nV;
	static int nE;
	static int INF = 100000000;
	static int start = 1;
	static ArrayList<dEdge> myArrList;
	
	static int[] mySet;
	static String[] isChecked;

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\Dijkstra\\Dijkstra.txt"));
			Scanner sc = new Scanner(System.in);
		
			
			nV = sc.nextInt();
			nE = sc.nextInt();
			
			myArrList = new ArrayList<dEdge>();
			
			mySet = new int[nV];
			isChecked = new String[nV];
			
			for (int i =0; i < nV; i++) {
				mySet[i] = INF;
				isChecked[i] = "Not Yet";
			}
			
			
		
			for (int i =0; i < nE; i++) {
				int[] node = new int[2];
				node[0] = sc.nextInt();
				node[1] = sc.nextInt();
				int distance = sc.nextInt();
				
				myArrList.add(new dEdge(node, distance));
			}
			
//			Collections.sort(myArrList);
			
			
			for (int i = 0; i < nE; i ++) {
				System.out.println("i = " + i + " start = " + myArrList.get(i).node[0] + " end = " + myArrList.get(i).node[1] + " distance = " + myArrList.get(i).distance);
			}			


			
			mySet[0] = 0; // 출발점에서 출발점 까지는 0
			isChecked[0] = "Checked"; // 출발점에서 출발점 까지는 0 

			myD(1); // Array는ㄴ 0부터 index 이나, 출발점은 1부터 시ㅈ
			
			for (int j = 0; j < nV; j++) {
				System.out.println("Checked or Not: " + isChecked[j] +  " Result: " + mySet[j]);
			}


			
//			System.out.println("Index for Shortest " + idx + " shortest distance: " + curval);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}
	
	public static void myD(int pstart) {
		for (int i = 0; i < nV; i ++) {
//			System.out.println("i :" + i);
			if (isChecked[i] == "Checked") continue;

			
			for (int j = 0; j < nE; j++) {
				if ((myArrList.get(j).node[0]) == pstart) {
//					System.out.println("j :" + j);
					mySet[myArrList.get(j).node[1] - 1] = myArrList.get(j).distance;
				}
			}
		}
		
		//Find vertex has shortest distance
//		int curval = INF;
//		int idx = 0;
//		for (int i = 1; i < nV; i ++) {
//			if (curval > mySet[i]) { curval = mySet[i]; idx = i; }
//		}			
//		
//		myD(idx);
		
	}
	
}
