package MST;

public class Solution {
	static int N = 10;
	static int[] parent ;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}
	
//		unionParent(1,2);
//		unionParent(2,3);
//		unionParent(2,5);
		
		unionParent(3,8);
		unionParent(8,6);
		unionParent(1,6);		
		
//		for (int x = 0; x < N; x++ ) {
//			System.out.println("x = " + x + " Parent = " + parent[x]);
//		}
		
		System.out.println("Is 1 and 3 connected : " + isConnected(1,3));
		
		
	}
	
	public static int getParent(int x) {
		if (parent[x] == x) return x;
		
		return parent[x] = getParent(parent[x]);
	}
	
//	public static void unionParent(int a, int b) {
//		int pa = getParent(a);
//		int pb = getParent(b);
//		
//		if (pa < pb) parent[b] = pa;
//		else parent[a] = pb;
//	}
	
	public static void unionParent(int a, int b) {
		a = getParent(a);
		b = getParent(b);
		
		if (a < b) parent[b] = a;
		else parent[a] = b;
	}	
	
	public static String isConnected(int a, int b) {
		int pa = getParent(a);
		int pb = getParent(b);
		
		if (pa == pb) return "Yes";
		else return "No";
	}
	
	
}
