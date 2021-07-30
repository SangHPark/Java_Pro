package dp;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class position_soldier {
	static int N;

	static int dp[];
	
	static ArrayList<Integer> myalist;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		System.setIn(new FileInputStream("C:\\Users\\SDSA\\eclipse-workspace-Study\\Java_Pro\\src\\dp\\position_soldier.txt"));
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new int[N];
		
		myalist = new ArrayList<Integer>();
		
		Arrays.fill(dp,1);
		
		for (int i = 0; i < N;  i ++) {
			myalist.add(sc.nextInt());
		}
		
		Collections.reverse(myalist);;
		
		
		for (int i = 1; i < N; i ++) {
			for (int j = 0; j < i; j ++) {
				if (myalist.get(j) < myalist.get(i)) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		for (int i = 0; i < N; i ++) {
			max = Math.max(max,  dp[i]); 
		}
		
		System.out.println(N - max);
	}

}
