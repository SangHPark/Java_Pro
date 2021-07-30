package dp;

public class gold_mining2 {

	static int N = 3;
	static int M = 4;;
	static int[][] mine = {
			{1,3,3,2},
			{2,1,4,1},
			{0,6,4,7}
	};

//	static int[][] mine = {
//			{1,3, 1,5},
//			{2,2, 4,1},
//			{5,0, 2,3},
//			{0,6, 1,2}			
//	};	
	
	static int[][] dp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int N = 4;
//		int M = 4;

		dp = new int[N][M];
		
//		int max = 0;
//		for (int i = 0; i < N; i ++) {
//			dp[i][0]  = mine[i][0];
//		}
//		
		
		for (int c = 0; c < M; c ++) {
			for (int r = 0; r < N; r ++ ) {
				
//				if (c == M-1) {
//					System.out.println("LMK");
//				}

				// from top-left				
				int t_l;
				
				int f_x = r - 1;
				int f_y = c - 1;
				
				if (check_valid(f_x, f_y)) {
					t_l = dp[f_x][f_y];
				} else {
					t_l = 0;
				};
 
				// from left				
				int l;
				
				f_x = r;
				f_y = c - 1;

				if (check_valid(f_x, f_y)) {
					l = dp[f_x][f_y];
				} else {
					l = 0;
				};
				
				// from bottom-left				
				int b_l;
				
				f_x = r + 1;
				f_y = c - 1;

				if (check_valid(f_x, f_y)) {
					b_l = dp[f_x][f_y];
				} else {
					b_l = 0;
				};
				
				
				dp[r][c] = mine[r][c] + Math.max(t_l, Math.max(l,  b_l));
				
			}
			
//			dp[c+1] = max_input;
		}
		
		int max = 0;
		for (int i = 0; i < N; i ++) {
			if (max < dp[i][M-1]) {
				max = dp[i][M-1];
			}
		}
		
		System.out.println(max);
	}

	static boolean check_valid (int from_x, int from_y) {
		if (from_x >= 0 && from_x < N && from_y >= 0 && from_y < M) return true;
		return false;
	}
}
