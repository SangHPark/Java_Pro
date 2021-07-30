package binanytreesearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class tryagain {
	static int T;
	static int Q;
	
	static int N,M, K;
	
	private static long[] tree;
	static class Node {
		Node left;
		Node right;
		
		int value;
		
		Node(int v) {
			this.value = v;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\binanytreesearch\\indextree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for (int t =1 ; t < 2; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
	        M = Integer.parseInt(st.nextToken());
	        K = Integer.parseInt(st.nextToken());


			int S = 1;
			while (S < N)
            S <<= 1;

//	        int S = 200000;
        // 사이즈보다 두 배 크게 만들면 기존 배열과 그 부모노드들이 모두 들어갈 수 있는 크기가 됩니다.
	        tree = new long[2 * S];
	        
//	        for (int i = S; i <= S + N - 1; i++)
//	            tree[i] = Long.parseLong(br.readLine().trim());
	        
	        for (int i = S; i <= S + N - 1; i++)
	            tree[i] = Long.parseLong(br.readLine().trim());	        
	        
	        for (int i = S; i <= S + N - 1; i++) {
	            int P = i / 2;
	            while (P != 0) {
	                tree[P] = tree[P] + tree[i];
	                P /= 2;
	            }
	        }
	        
	        for (int i = 1; i <= S + N - 1; i ++) {
//	        	if (tree[i] != 0) 
	        	System.out.println("i = " + i + "  " + tree[i]);
	        }
		}
	}
}

