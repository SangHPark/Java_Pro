package knapsack;

public class Solution {
	
	static int N = 5;
	static int W = 15;
	
	static int[] ci = {2, 1, 10, 2, 5};
	static int[] wi = {9, 1, 4, 2, 12};
	
	static int[][] M = new int[N+1][W+1];
	static int[][] S = new int[N+1][W+1];
	
	public static void main(String[] args) {
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				M[i][j] = -1;
			}
		}
		
		System.out.println(knapSack(N,W));
		printSolution(N,W);
		
	}
	
	
	private static void printSolution(int i, int w) {
		if (i == 0) {
			return;
		}
		
		if (S[i][w] == 1 ) {
			printSolution(i -1, w - wi[i - 1]);
			System.out.println(i + " ");
		} else {
			printSolution(i -1, w);
		}
			
	}
	

	private static int knapSack(int i, int w) {
		// TODO Auto-generated method stub
		if (i == 0 ) { return 0;}
		
		if (M[i][w] != -1) {
			return M[i][w];
		}
		
		//i번졔 물건을 담지 않는 경우
		M[i][w] = knapSack(i - 1, w);
		
		if (w >= wi[i-1]) {
				M[i][w] = Math.max(M[i][w], knapSack(i-1, w - wi[i - 1]) + ci[i - 1]);
				if (knapSack(i -1, w) < M[i][w]) {
					S[i][w] = 1;
				}
		}
		
		return M[i][w];
	}


//	if (wt[n-1] > W) {
//		return knapSack(W, wt, val, n-1);
//	}
//	else return max( val[n-1] + knapSack(W-wt[n-1], wt, val, n-1),
//					knapSack(W, wt, val, n-1));
	
	

//	static int knapSack2(int W, int wt[], int val[], int n) {
//		int i, w;
//		int K[][] = new int[n+1][W+1];
//		
//		for (i = 0; i <= n; i++) {
//			for (w = 0; w <= W; w++) {
//				if (i == 0 || w == 0) {
//					K[i][w] = 0;
//				} else if (wt[i-1] <= W) {
//					K[i][w] = max(val[i-1] + K[i-1][W-wt[i-1]],  K[i-1][w]); 
//				} else
//	                   K[i][w] = K[i-1][w]; 
//				
//			}
//		}
//		
//		return K[n][W];
//	}

}
