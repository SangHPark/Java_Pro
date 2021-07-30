package MST;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class newEdge implements Comparable<newEdge>{
    int v1;
    int v2;
    int cost;
    newEdge(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }
    @Override
    public int compareTo(newEdge o) {
        if(this.cost < o.cost)
            return -1;
        else if(this.cost == o.cost)
            return 0;
        else
            return 1;
    }
}
public class Main {
	
    public static int[] parent; 
    public static ArrayList<newEdge> newEdgeList;
    public static int answer = 0;
	
    public static int find(int x) {
        if(parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parent[y] = x;
    }
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return true;
        else
            return false;
    }
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\MST\\baekjoon_1922.txt"));
        Scanner sc = new Scanner(System.in);
        int e = sc.nextInt();
        int v = sc.nextInt();
		
        newEdgeList = new ArrayList<newEdge>();
		
        for(int i = 0; i < v; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            newEdgeList.add(new newEdge(v1, v2, cost));
        }
		
        Collections.sort(newEdgeList);
		
        parent = new int[e+1];
        for(int i = 1; i <= e; i++) {
            parent[i] = i;
        }
		
		for (int i = 0; i < v; i ++) {
			newEdge newEdge = newEdgeList.get(i);
			System.out.println(newEdge.v1 + " " + newEdge.v2 + " " + newEdge.cost);
		}

        	
        for(int i = 0; i < v; i++) {
            newEdge newEdge = newEdgeList.get(i);
            if(!isSameParent(newEdge.v1, newEdge.v2)) {
                union(newEdge.v1, newEdge.v2);
                answer += newEdge.cost;
            }
        }
		
        System.out.println(answer);	
    }	
}
