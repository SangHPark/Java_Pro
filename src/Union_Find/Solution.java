package Union_Find;

public class Solution {
	static int N = 10;
	static int[] parent ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	
		unionParent(1,2);
		unionParent(2,3);
		unionParent(2,5);
		
		for (int x = 0; x < N; x++ ) {
			System.out.println("x = " + x + " Parent = " + parent[x]);
		}
		
		System.out.println("Is 1 and 5 connected : " + isConnected(1,5));
		
		
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
	
	public static String isConnected(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		
		if (pa == pb) return "Yes";
		else return "No";
	}
	
	
}
