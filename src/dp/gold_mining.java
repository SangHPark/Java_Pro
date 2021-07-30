package dp;

// Again NOT Correct
public class gold_mining {

	static int N;
	static int M;
//	static int[][] mine = {
//			{1,3,3,2},
//			{2,1,4,1},
//			{0,6,4,7}
//	};

	static int[][] mine = {
			{1,3,20,5},
			{2,2, 4,1},
			{5,0, 2,3},
			{0,6, 1,2}			
	};	
	
	static int[] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 4;
		int M = 4;

		dp = new int[M];
		
		int max = 0;
		for (int i = 0; i < N; i ++) {
			if (max < mine[i][0]) {
				max = mine[i][0];
			}
		}
		
		dp[0] = max;
		
		int max_input=0;
		
		for (int c = 0; c < M-1; c ++) {
			for (int r = 0; r < N; r ++ ) {
				
				if (c == M-1) {
					System.out.println("LMK");
				}

				// from top-left				
				int t_l;
				
				if (((r - 1) >= 0) && ((r - 1) < N)) {
					t_l = mine[r-1][c+1];
				} else {
					t_l = 0;
				};
 
				// from left				
				int l;
				
				l = mine[r][c+1];


				// from bottom-left				
				int b_l;
				
				if (((r + 1) >= 0) && ((r + 1) < N)) {
					b_l = mine[r+1][c+1];
				} else {
					b_l = 0;
				};
				
				
				max_input = Math.max(t_l, Math.max(l,  b_l));
				
			}
			
			dp[c+1] = max_input;
		}
		
		for (int i = 0; i < M; i ++) {
			System.out.println(dp[i]);
		}
	}

}
