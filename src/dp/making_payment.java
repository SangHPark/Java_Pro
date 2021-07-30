package dp;

import java.util.Arrays;


public class making_payment {

	static int[] d;
	static int[] c;
	static int INF = 10001;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int N = 2;
		c = new int[N];

		c[0] = 2;
		c[1] = 3;

		int M = 30;
		d = new int[M+1];
		
//  initial set
		Arrays.fill(d, INF);
		
//		for (int i = 1; i < N+1; i ++) {
//			for (int j = 1; j < M+1; j++) {
//				if (c[i] == j) {
//					d[j] = 1;
//				}
//			}
//		}

		d[0] = 0;		
		
		
		for (int i = 0; i < N; i ++) {
			for (int j = c[i]; j <= M; j++) {
				if ((d[j - c[i]]) != INF) {
					d[j] = Math.min(d[j],  d[j - c[i]] + 1);
				}
			}
		}
		System.out.println(d[M]);
		 
		
	}

}
