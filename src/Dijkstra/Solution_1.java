package Dijkstra;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_1 {

	static int nV;
	static int nE;
	static ArrayList<dEdge> myAList;
	
	public static void main(String[] args) {
	        
	        try {
				System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\Dijkstra\\Dijkstra.txt"));
				Scanner sc = new Scanner(System.in);	 
				
				nV = sc.nextInt();
				nE = sc.nextInt();
				
				myAList = new ArrayList<>();
				
				for (int i = 0; i < nE; i++) {
					int[] node = new int[2];
					int distance; 
					node[0] = sc.nextInt();
					node[1] = sc.nextInt();
					distance = sc.nextInt();
					
					myAList.add(new dEdge(node, distance));
				}
				
				for (int i = 0; i < nE; i ++) {
					System.out.println("i = " + i + " start = " + myAList.get(i).node[0] + " end = " + myAList.get(i).node[1] + " distance = " + myAList.get(i).distance);
				}			

				
				myDij(1);
				
	        } catch (Exception e) {
	        	System.out.println(e.toString());
	        }
	}
	
	public static void myDij(int pstart) {
		int mySet[] = new int[nV+1];
		boolean isChecked[] = new boolean[nV+1];
		
		// initial set for mySet with MAX
		for (int i = 1; i < nV + 1; i++) {
			mySet[i] = Integer.MAX_VALUE;
		}
		
		mySet[pstart] = 0;
		isChecked[pstart] = true;
		
		for (int i = 0; i < nE; i++) {
			if (myAList.get(i).node[0] == pstart) {
				mySet[myAList.get(i).node[1]] = myAList.get(i).distance;
			}
			
		}
		
		for (int i = 0; i < nV + 1; i ++) {
			System.out.println("i = " + i + " distance = " + mySet[i]);
		}
		
		for (int a = 0; a < nV -1; a ++) {
			//Find Node has shortest distance
			int curval = Integer.MAX_VALUE;
			int idx = -1;
			
			for (int i = 1; i < nV + 1; i ++) {
				if (!isChecked[i] && mySet[i] < curval) {
					curval = mySet[i];
					idx = i;
				}
				
			}
			
			isChecked[idx] =  true;
			for (int i = 1; i < nV + 1; i ++) {
				if(!isChecked[i]) {
					for (int j = 0; j < nE; j++) {
						if (myAList.get(j).node[0] == idx && myAList.get(j).node[1] == i && myAList.get(j).distance != 0 ) {
							if (mySet[i] > mySet[idx] + myAList.get(j).distance) {
								mySet[i] = mySet[idx] + myAList.get(j).distance;
							}
						}
					}
				}
			}
//			System.out.println(mySet[a] + " ");			
		}
		
		for (int i = 1; i < nV + 1; i ++) {
			System.out.println(mySet[i] + " ");
		}
	}
}
