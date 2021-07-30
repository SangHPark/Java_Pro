package binanytreesearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class binaryindextree {
	static int N;
	static int M;
	static int K;
	static int T;
	
	static long[] tree;
	static long[] arr;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\binanytreesearch\\indextree.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t < T+ 1; t++) {
			
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		tree = new long[N+1];
		arr = new long[N+1];
		
        for (int i = 1; i < N + 1; i++) {
        	long x = Long.parseLong(br.readLine().trim());
        	arr[i] = x;
            update(i,x);
        }
        
//        for (int i = 1; i < N+1; i ++) {
//        	System.out.print(tree[i] +" ");
//        }
        
		for (int i = 1; i <= M + K ; i ++ ) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (a == 1) {
				update(b, c - arr[b]);
				arr[b] = c;
			} 
			else {
				System.out.println(prefix_sum(c) - prefix_sum(b-1));
			}
		}

//		System.out.println(" ");
//        for (int i = 1; i < N+1; i ++) {
//        	System.out.print(tree[i] +" ");
//        }
		}
	}
	
	static void update(int i, long dif) {
		while (i <= N) {
			tree[i] += dif;
//			System.out.println("before " + i);
			i += (i & -i);
//			System.out.println("after " + i);
		}
	}
	
	static long prefix_sum(int i) {
		long result = 0;
		while (i > 0) {
			result += tree[i];
			i -= (i & -i);
		}
		return result;
	}

}
