package dp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ant_worrier {

	static int N;
	static int[] dp;
//	static int[] eats = {1,3,1,5};
	static int[] eats;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
//		int N = 4;

//		eats = new int[N];
		
//		System.setIn(new FileInputStream(""));
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		dp = new int[N];
		eats = new int[N];
		
		for (int i = 0; i < N; i++) {
			eats[i] = sc.nextInt();
		}
		
		
		dp[0] = eats[0];
		dp[1] = Math.max(eats[0], eats[1]);
		
//		dp[2] = Math.max(dp[1], dp[0] + eats[2]);
//		
//		dp[3] = Math.max(dp[2], dp[1] + eats[3]);
		
		for (int i = 2; i < N; i ++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + eats[i]);
//			System.out.println(dp[i]);
		}
		
		System.out.println(dp[N-1]);
				
	}

}
