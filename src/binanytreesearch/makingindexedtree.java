package binanytreesearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Mess Up
public class makingindexedtree {

	static int N;
	static int M;
	static int K;
	
	static int T;
	static int Q;
	
	static long[] A, B;
	static int size = 200002;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\binanytreesearch\\indextree.txt"));
		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro2\\src\\samsung_test\\P_0041_kheap_event.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		for (int t =1 ; t < 2; t++) {
			st = new StringTokenizer(br.readLine());
			Q = Integer.parseInt(st.nextToken());

			
			//트리 상단의 높이 구함

//	        while (size < Q)
//	        	size <<= 1;

			A = new long[size];
			B = new long[2*size];
			
			for (int q = 1; q < Q + 1; q ++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				
				if (op == 1) {
					int x = Integer.parseInt(st.nextToken()) + 100000;
					A[x] ++;
//					update(x, 1);
					
			        for (int i = size / 2 ; i <= 2 * size -1 ; i++) {
		            int P = i / 2;
		            while (P != 0) {
		                A[P] = A[P] + A[i];
		                P /= 2;
		            }
		        }	  
					
//					
				} else {
					int k = Integer.parseInt(st.nextToken());
				}
			}
			
//		N = Integer.parseInt(st.nextToken());
//		M = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(st.nextToken());
		}

		

		
//		for (int i = size ; i <= size + N -1 ; i ++) {
//			A[i] = Integer.parseInt(br.readLine());
//
//		}
		
		
			
		for (int i = 1; i < size; i ++) {
			if (A[i] != 0)
			System.out.print(" i = " + i + " A[i] = " + A[i] + " ");
			
		}
		
		System.out.println(" ");
		
		for (int i = 1; i < size * 2; i ++) {
			if (B[i] != 0)
			System.out.print(" i = " + i + " B[i] = " + B[i] + " ");
			
		}		
	}

	    static void update(int idx, long val) {
	    	
	    	
	        for (int i = size; i <= size + N - 1; i++) {
	            int P = i / 2;
	            while (P != 0) {
	                A[P] = A[P] + A[i];
	                P /= 2;
	            }
	        }
	        
	        
    
	    }
}

	